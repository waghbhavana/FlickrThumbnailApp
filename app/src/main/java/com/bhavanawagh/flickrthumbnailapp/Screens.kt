package com.bhavanawagh.flickrthumbnailapp

sealed class Screens(val route: String){
    object ThumbnailsScreen : Screens("List_Screen")
    object DetailScreen : Screens("Detail_Screen")
}
