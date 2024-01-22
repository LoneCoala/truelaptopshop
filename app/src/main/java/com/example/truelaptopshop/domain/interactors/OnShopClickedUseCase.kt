package com.example.truelaptopshop.domain.interactors

import com.example.truelaptopshop.presentation.main.MainContact

class OnShopClickedUseCase(private val view: MainContact.View){
     fun execute() {
        view.navigateToShoppingCart()
    }
}