package com.bhavanawagh.flickrthumbnailapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.bhavanawagh.flickrthumbnailapp.data.Item

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThumbnailsScreen(items: List<Item>,OnItemClick: (Item)->Unit) {

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        verticalArrangement = Arrangement.spacedBy(3.dp),
        horizontalArrangement = Arrangement.spacedBy(3.dp)
    )
    {
        items(items.size, key = { it }) {
            Surface(
                tonalElevation = 3.dp,
                modifier = Modifier.aspectRatio(1f)
            ) {

                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(6.dp)
                        .clickable { OnItemClick(items[it]) },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    AsyncImage(
                        model = items[it].media.m,
                        // placeholder = painterResource(id = R.drawable.sudoimage),
                        // error = painterResource(id = R.drawable.sudoimage),
                        contentDescription = items[it].description,
                    )
//                    // on the below line we are adding a spacer.
//                    Spacer(modifier = Modifier.height(9.dp))
//
//                    // on below line we are creating
//                    // a text for our grid view item
//                    Text(
//                        // inside the text on below line we are
//                        // setting text as the language name
//                        // from our modal class.
//                        text = items[it].title,
//
//                        // on below line we are adding padding
//                        // for our text from all sides.
//                        modifier = Modifier.padding(4.dp),
//
//                        // on below line we are
//                        // adding color for our text
//                        color = Color.Black
//                    )
                }
            }


        }
    }

}




