package com.example.composeapi.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeapi.data.models.StoryPost
import com.example.composeapi.data.remote.repositories.StoryPostRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception


class StoryPostViewModel: ViewModel() {
    private val TAG = "StoryPostViewModel";
    private val repository = StoryPostRepository()

    private val _storyPosts = MutableStateFlow<List<StoryPost>>(emptyList())
    val storyPosts: StateFlow<List<StoryPost>> = _storyPosts.asStateFlow()

    private val _storyPost = MutableStateFlow<StoryPost?>(null)
    val storyPost: StateFlow<StoryPost?> = _storyPost.asStateFlow()

    fun getCreditCards() {
        viewModelScope.launch {
            try {
                _storyPosts.value = repository.getStoryPosts()
            }catch (e: Exception){
                Log.e("$TAG getStoryPosts => ", e.toString())
            }
        }
    }

    fun getSingleStoryPost(postId: Int) {
        viewModelScope.launch {
            try {
                _storyPost.value = repository.getSinglePost(postId)
            }catch (e: Exception){
                Log.e("$TAG getSingleStoryPost => ", e.toString())
            }
        }
    }

}