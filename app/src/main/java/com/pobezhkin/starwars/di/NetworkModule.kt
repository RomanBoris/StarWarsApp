package com.pobezhkin.starwars.di

import com.pobezhkin.starwars.data.remote.StarApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private val BASE_URL = "https://swapi.dev/"

    @Singleton
    @Provides
    fun  HttpClienLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }


    @Singleton
    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(com.pobezhkin.starwars.di.NetworkModule.BASE_URL)
            .client(okHttpClient)
            .build()


    @Singleton
    @Provides
    fun provideNewsApiService(retrofit: Retrofit) : StarApiService = retrofit.create(StarApiService::class.java)

}
