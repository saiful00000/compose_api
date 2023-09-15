package com.example.composeapi.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeapi.presentation.activities.story_posts.StoryDetailsScreen
import com.example.composeapi.presentation.activities.story_posts.StoryPostListScreen
import com.example.composeapi.presentation.viewmodels.StoryPostViewModel

@Composable
fun AppNavigator() {
    val navHostController = rememberNavController()
    val storyPostViewModel: StoryPostViewModel = viewModel()

    NavHost(
        navController = navHostController,
        startDestination = RouteNames.storyPostListScreen,
    ){
        composable(RouteNames.storyPostListScreen){
            StoryPostListScreen(navController = navHostController, viewModel = storyPostViewModel)
        }

        composable(RouteNames.storyPostDetailsScreen+"/{postId}"){
            StoryDetailsScreen(navController = navHostController, viewModel = storyPostViewModel)
        }

    }
}