package com.example.composefakedata.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.composefakedata.viewmodel.PostViewModel

@Composable
fun PostScreen(navController: NavController, viewModel: PostViewModel = viewModel()) {
    val posts = viewModel.postList

    LazyColumn {
        items(posts) { post ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate("details_screen/${post.id}")
                    }
            ) {
                Column(modifier = Modifier
                    .padding(10.dp))
                {
                    Text(text = "User ID: ${post.userId}")
                    Text(text = "Post ID: ${post.id}")
                    Text(text = post.title,
                        modifier = Modifier
                            .padding(bottom = 5.dp),
                        color = colorResource(id = com.example.composefakedata.R.color.purple_700),
                        fontSize = 20.sp)
                    Text(text = post.body)
                }
            }
        }
    }
}
