package com.example.truelaptopshop.presentation.favouritesLaptops

import com.example.truelaptopshop.domain.model.PostModel

interface ShoppingCartContact {
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