package br.com.movilenext.taco.core.di

import br.com.movilenext.taco.data.ws.category.CategoryApi
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [TestNetworkModule::class])
interface NetworkComponent {
    fun getCategoryApi(): CategoryApi
}

@Module
class TestNetworkModule {
    @Provides
    @Singleton
    @Named("stub")
    fun provideStubApi(@Named("stub") client: OkHttpClient) =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("http://jsonstub.com/")
            .client(client)
            .build()

    @Provides
    @Singleton
    @Named("stub")
    fun provideStubClient(): OkHttpClient {
        val headerInterceptor = Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("JsonStub-User-Key", "1e317a0c-c9d9-4621-a7c8-82bbc34cded7")
                .addHeader("JsonStub-Project-Key", "7d23849f-d2e8-44be-b94b-a5ed270d0f72")
                .build()
            chain.proceed(request)
        }

        val interceptor = HttpLoggingInterceptor()

        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(headerInterceptor)
            .build()
    }


    @Provides
    @Singleton
    fun provideCategoryApi(@Named("stub") retrofit: Retrofit): CategoryApi = retrofit.create(CategoryApi::class.java)

}
