package com.example.truelaptopshop

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/laptops")
    fun getPosts() :Call<MutableList<PostModel>>
}