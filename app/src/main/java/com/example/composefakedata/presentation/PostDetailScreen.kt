package com.example.composefakedata.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composefakedata.viewmodel.PostViewModel

@Composable
fun PostDetailsScreen(postId: String?, viewModel: PostViewModel = viewModel()) {
    val post = viewModel.postList.find { it.id.toString() == postId }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (post != null) {
            Text(text = "Post Details",
                style = MaterialTheme.typography.headlineMedium)
            Text(text = "User ID: ${post.userId}",
                modifier = Modifier.padding(top = 8.dp))
            Text(text = "Post ID: ${post.id}",
                modifier = Modifier.padding(top = 4.dp))
            Text(
                text = post.title,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(top = 16.dp),
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = post.body,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 8.dp)
            )
        } else {
            Text(text = "Post not found or loading...")
        }
    }
}
