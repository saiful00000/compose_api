package com.example.composeapi.presentation.activities.story_posts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.composeapi.R
import com.example.composeapi.presentation.viewmodels.StoryPostViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoryDetailsScreen(navController: NavHostController, viewModel: StoryPostViewModel) {

//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    val postId = navBackStackEntry?.arguments?.getInt("postId")

    LaunchedEffect(Unit) {
        viewModel.getSingleStoryPost(1)
    }

    val storyPost by viewModel.storyPost.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Details") },
                navigationIcon = {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier.padding(8.dp)
                            .clickable {
                                navController.popBackStack()
                            }
                    )
                },
            )
        },
        content = { contentPadding ->
            if (storyPost == null) {
                Column (
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(text = "Loading...")
                }
            } else {
                Column(
                    modifier = Modifier.padding(contentPadding)
                ) {
                    Text(
                        text = storyPost?.title ?: "-",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = storyPost?.body ?: "-",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    )
}