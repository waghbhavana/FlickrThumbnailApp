package com.bhavanawagh.flickrthumbnailapp.di

import com.bhavanawagh.flickrthumbnailapp.api.NetworkServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    fun provideBaseUrl() : String=   "https://api.flickr.com/"

    @Provides
    fun provideGsonConverterFactory() : GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun provideRetrofitInstance(
        baseUrl: String,
        gsonConverterFactory: GsonConverterFactory
    ): NetworkServices{

        return  Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(gsonConverterFactory)
            .build().create(NetworkServices::class.java)
    }
}