package com.example.composeapi.data.remote.repositories

import com.example.composeapi.data.models.StoryPost
import com.example.composeapi.data.remote.network.RetrofitInstance

class StoryPostRepository{
    private val storyPostService = RetrofitInstance.storyPostService

    suspend fun getStoryPosts(): List<StoryPost>  {
        return storyPostService.getStoryPosts()
    }

    suspend fun getSinglePost(id: Int): StoryPost {
        return storyPostService.getSinglePost(id)
    }
}