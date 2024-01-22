package com.example.truelaptopshop.data.API

import com.example.truelaptopshop.domain.model.PostModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/laptops")
    fun getPosts() :Call<MutableList<PostModel>>
}