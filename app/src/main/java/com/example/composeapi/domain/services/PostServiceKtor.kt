package com.example.composeapi.domain.services

import com.example.composeapi.data.dto.PostRequest
import com.example.composeapi.data.dto.PostResponse

interface PostServiceKtor {
    suspend fun getPosts(): List<PostResponse>

    suspend fun createPost(postRequest: PostRequest) : PostResponse?
}