package com.example.composeapi.domain.services

import com.example.composeapi.data.models.StoryPost
import retrofit2.http.GET
import retrofit2.http.Path

interface StoryPostService {
    @GET("posts")
    suspend fun getStoryPosts(): List<StoryPost>

    @GET("posts/{id}")
    suspend fun getSinglePost(@Path("id") id: Int): StoryPost
}