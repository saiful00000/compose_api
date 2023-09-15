package com.example.composeapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.composeapi.presentation.activities.story_posts.StoryPostListScreen
import com.example.composeapi.presentation.navigation.AppNavigator
import com.example.composeapi.presentation.viewmodels.StoryPostViewModel
import com.example.composeapi.ui.theme.ComposeAPITheme

class MainActivity : ComponentActivity() {

    private val creditCardViewModel: StoryPostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAPITheme {
                AppNavigator()
            }
        }
    }
}