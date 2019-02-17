package br.com.movilenext.taco.core.di

import br.com.movilenext.taco.BuildConfig
import br.com.movilenext.taco.data.ws.category.CategoryApi
import br.com.movilenext.taco.data.ws.food.FoodApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Module
open class NetworkModule @Inject constructor() {

    @Provides
    @Singleton
    @Named("urlDomain")
    open fun provideUrlDomain(): String {
        return "https://taco-food-api.herokuapp.com/"
    }

    @Provides
    @Reusable
    fun provideRetrofit(okHttpClient: OkHttpClient, @Named("urlDomain") urlDomain: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlDomain)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideCategoryApi(retrofit: Retrofit): CategoryApi = retrofit.create(CategoryApi::class.java)

    @Provides
    @Singleton
    fun provideFoodApi(retrofit: Retrofit): FoodApi = retrofit.create(FoodApi::class.java)

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient {
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
        okHttpClientBuilder.addInterceptor(httpLoggingInterceptor)
        return okHttpClientBuilder.build()
    }
}
