package com.example.truelaptopshop.presentation.main;

import androidx.recyclerview.widget.RecyclerView
import com.example.truelaptopshop.domain.model.PostModel

interface MainContact {
    interface View {
        fun showPosts(posts: MutableList<PostModel>)
        fun showError(error: String)
        fun navigateToShoppingCart()
    }

    interface Presenter {
        fun loadPosts()
        fun onShopClicked()
    }
}