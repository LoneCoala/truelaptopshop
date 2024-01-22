package com.example.truelaptopshop.domain.interactors

import com.example.truelaptopshop.presentation.favouritesLaptops.ShoppingCartContact
import com.example.truelaptopshop.presentation.main.MainContact

class FavoriteShoppingLaptopsUseCase(private val view: ShoppingCartContact.View){
    fun execute() {
        view.navigateToShoppingCart()
    }
}