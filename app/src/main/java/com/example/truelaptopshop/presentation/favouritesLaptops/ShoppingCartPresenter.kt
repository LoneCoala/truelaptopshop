package com.example.truelaptopshop.presentation.favouritesLaptops

import com.example.truelaptopshop.data.API.ApiInterface
import com.example.truelaptopshop.domain.interactors.FavoriteShoppingLaptopsUseCase
import com.example.truelaptopshop.domain.interactors.LoadPostsUseCase
import com.example.truelaptopshop.domain.interactors.LoadShoppingLaptopsUseCase
import com.example.truelaptopshop.domain.interactors.OnShopClickedUseCase
import com.example.truelaptopshop.presentation.main.MainContact

class ShoppingCartPresenter(private val view: ShoppingCartContact.View, private val apiInterface: ApiInterface) :
    ShoppingCartContact.Presenter {
    var loadShoppingLaptopsUseCase = LoadShoppingLaptopsUseCase(view, apiInterface)
    var favoriteShoppingLaptopsUseCase = FavoriteShoppingLaptopsUseCase(view)

    override fun loadPosts() {
        loadShoppingLaptopsUseCase.execute()
    }

    override fun onShopClicked() {
        favoriteShoppingLaptopsUseCase.execute()
    }
}