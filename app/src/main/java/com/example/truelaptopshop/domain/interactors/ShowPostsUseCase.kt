package com.example.truelaptopshop.domain.interactors

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.truelaptopshop.domain.adapter.PostAdapter
import com.example.truelaptopshop.domain.model.PostModel
import com.example.truelaptopshop.presentation.main.MainActivity

class ShowPostsUseCase(private val posts: MutableList<PostModel>, private val recyclerView: RecyclerView, private val mainActivity: MainActivity) {
     fun execute() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(mainActivity)
            setHasFixedSize(true)
            adapter = PostAdapter(posts)
        }
    }
}