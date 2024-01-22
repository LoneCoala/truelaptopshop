package com.example.truelaptopshop.domain.interactors

import com.example.truelaptopshop.data.API.ApiInterface
import com.example.truelaptopshop.domain.model.PostModel
import com.example.truelaptopshop.presentation.main.MainContact
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoadPostsUseCase(private val view: MainContact.View, private val apiInterface: ApiInterface) {
    fun execute() {
            val call = apiInterface.getPosts()
            call.enqueue(object : Callback<MutableList<PostModel>> {
                override fun onResponse(
                    call: Call<MutableList<PostModel>>,
                    response: Response<MutableList<PostModel>>
                ) {
                    if (response.isSuccessful()) {
                        view.showPosts(response.body()!!)
                    } else {
                        view.showError(response.message())
                    }
                }
                override fun onFailure(call: Call<MutableList<PostModel>>, t: Throwable) {
                    view.showError(t.message.toString())
                }
            })
        }
}