package com.bhavanawagh.flickrthumbnailapp

import com.bhavanawagh.flickrthumbnailapp.api.NetworkServices
import com.bhavanawagh.flickrthumbnailapp.data.FlickrResponse
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FlickrRepository @Inject constructor(private val networkServices: NetworkServices) {

    suspend fun getFlickrThumbnails(tags: String): Response<FlickrResponse> {
       return networkServices.getFlickrThumbnails(tags)
    }
}