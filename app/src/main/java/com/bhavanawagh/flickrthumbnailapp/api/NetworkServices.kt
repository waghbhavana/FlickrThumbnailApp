package com.bhavanawagh.flickrthumbnailapp.api

import com.bhavanawagh.flickrthumbnailapp.data.FlickrResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkServices {
    @GET("services/feeds/photos_public.gne?format=json&nojsoncallback=1")
    suspend fun getFlickrThumbnails(@Query("tags") query:String): Response<FlickrResponse>
}