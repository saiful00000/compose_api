package com.example.composeapi.data.models

import kotlinx.serialization.Serializable

data class StoryPost(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String,
)

