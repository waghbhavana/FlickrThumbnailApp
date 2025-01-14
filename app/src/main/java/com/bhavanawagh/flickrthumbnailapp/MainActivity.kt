package com.bhavanawagh.flickrthumbnailapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bhavanawagh.flickrthumbnailapp.data.Item
import com.bhavanawagh.flickrthumbnailapp.screens.ThumbnailDetailScreen
import com.bhavanawagh.flickrthumbnailapp.screens.ThumbnailsScreen
import com.bhavanawagh.flickrthumbnailapp.ui.theme.FlickrThumbnailAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: FlickrViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            getFlickerThumbnails(viewModel)

        }
    }
}


@Composable
fun NavigationStack(items: List<Item>){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.ThumbnailsScreen.route){

        composable(route=Screens.ThumbnailsScreen.route){
            ThumbnailsScreen(items) { item: Item ->
                // val encodedItem = Uri.encode(Gson().toJson(item))
                println("item clicked")
            }



        }

//        composable(route=Screens.DetailScreen.route +"?item={text}" ,
//            listOf( navArgument("item") {
//                type = NavType.
//                nullable = false
//            })
//        ){
//            //ThumbnailDetailScreen()
//        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun getFlickerThumbnails(viewModel: FlickrViewModel) {

    var tags: String by remember {
        mutableStateOf("")
    }

    val result = viewModel.flickrThumbnails.collectAsState()


    Column(modifier = Modifier.padding(8.dp)) {

        Row(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            OutlinedTextField(value = tags, onValueChange = { tags = it })
            Button(onClick = {

                try {
                    viewModel.getFlickrThumbnails(tags)

                    println(" result >> ${result.value.toString()}")


                } catch (e: Exception) {
                    println("Exception occurd")
                }

            }) {
                Text(text = "Submit")
            }
        }

        println("MainActivity result from state>> ${result.value}")
        if (result.value != null) {
          //  Text(text = result.value.toString())
            var items: List<Item> = result.value!!.items
            NavigationStack(items)
           // ThumbnailsScreen(items)
        }

    }
}

