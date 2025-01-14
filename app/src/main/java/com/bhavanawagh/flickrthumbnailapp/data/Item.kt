package com.bhavanawagh.flickrthumbnailapp.data

data class Item(
    val author: String,
    val author_id: String,
    val date_taken: String,
    val description: String,
    val link: String,
    val media: Media,
    val published: String,
    val tags: String,
    val title: String
)