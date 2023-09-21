package com.example.composeapi.data.remote.service

import com.example.composeapi.data.dto.PostRequest
import com.example.composeapi.data.dto.PostResponse
import com.example.composeapi.data.remote.res.HttpRoutes
import com.example.composeapi.domain.services.PostServiceKtor
import io.ktor.client.HttpClient
import io.ktor.client.features.ClientRequestException
import io.ktor.client.features.RedirectResponseException
import io.ktor.client.features.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType

class PostServiceKtorImpl(
    private val client: HttpClient
): PostServiceKtor {
    override suspend fun getPosts(): List<PostResponse> {
        return try {
            client.get {
                url(HttpRoutes.POSTS)
            }
        }catch (e: RedirectResponseException){
            // 3xx error
            println("HTTP Error: ${e.response.status.description}")
            emptyList()
        }catch (e: ClientRequestException){
            // 4xx errors
            println("HTTP Error: ${e.response.status.description}")
            emptyList()
        }catch (e: ServerResponseException){
            // 5xx errors
            println("HTTP Error: ${e.response.status.description}")
            emptyList()
        }catch (e: Exception){
            println("HTTP Error: ${e.message}")
            emptyList()
        }
    }

    override suspend fun createPost(postRequest: PostRequest): PostResponse? {
        return try {
            client.get<PostResponse> {
                url(HttpRoutes.POSTS)
                contentType(ContentType.Application.Json)
                body = postRequest
            }
        }catch (e: RedirectResponseException){
            // 3xx error
            println("HTTP Error: ${e.response.status.description}")
            null
        }catch (e: ClientRequestException){
            // 4xx errors
            println("HTTP Error: ${e.response.status.description}")
            null
        }catch (e: ServerResponseException){
            // 5xx errors
            println("HTTP Error: ${e.response.status.description}")
            null
        }catch (e: Exception){
            println("HTTP Error: ${e.message}")
            null
        }
    }
}