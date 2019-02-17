package br.com.movilenext.dagger2.inject

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides @Singleton
    fun provideOkHttpClient() = OkHttpClient()

//    @Provides @Singleton
//    fun provideTwitterApi(client: OkHttpClient) = TwitterApi(client)
}
