package com.example.composeapi.presentation.activities.story_posts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.composeapi.presentation.navigation.RouteNames
import com.example.composeapi.presentation.viewmodels.StoryPostViewModel

@Composable
fun StoryPostListScreen(navController: NavHostController, viewModel: StoryPostViewModel) {
    val storyPosts by viewModel.storyPosts.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getCreditCards()
    }

    Column {
        if (storyPosts.isEmpty()) {
            // Show loading indicator or placeholder
            Text(text = "Loading...")
        } else {
            // Display the list of credit cards
            LazyColumn {
                items(storyPosts) { post ->
                    Card(
                        elevation = CardDefaults.cardElevation(2.dp),
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate("${RouteNames.storyPostDetailsScreen}/${post.id}")
                            },
                    ) {
                        Column(
                            Modifier.padding(8.dp)
                        ) {
                            Text(
                                text = post.title,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = post.body,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
        }
    }
}