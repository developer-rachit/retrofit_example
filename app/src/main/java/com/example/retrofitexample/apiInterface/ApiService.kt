package com.example.retrofitexample.apiInterface

import com.example.retrofitexample.data.Post
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    fun getPosts(): Call<List<Post>>
}
