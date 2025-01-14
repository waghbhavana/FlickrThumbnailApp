package com.bhavanawagh.flickrthumbnailapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bhavanawagh.flickrthumbnailapp.data.FlickrResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class FlickrViewModel @Inject constructor(private val repository: FlickrRepository) : ViewModel(){

    private val _flickrThumbnails= MutableStateFlow<FlickrResponse?>(null)
    var flickrThumbnails :  StateFlow<FlickrResponse?> = _flickrThumbnails

    fun getFlickrThumbnails(tag: String){

        viewModelScope.launch {
           try{
               val result: Response<FlickrResponse> = repository.getFlickrThumbnails("porcupine")
               println(result)
               if (result.isSuccessful) {
                   _flickrThumbnails.value = result.body()!!
//                   println("FlickrViewModel : ${result.body()}")
               }
           }catch (e: Exception){
               println(e)
           }
        }

    }
}