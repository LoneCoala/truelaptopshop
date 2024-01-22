package com.example.truelaptopshop.domain.interactors

import android.app.Activity
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.example.truelaptopshop.presentation.favouritesLaptops.ShoppingCartActivity
import com.example.truelaptopshop.presentation.main.MainActivity

class NavigateToShoppingCartUseCase(private val mainActivity: Activity, private val shoppingCartActivity: ShoppingCartActivity) {
    fun execute() {
        val intent = Intent(mainActivity, shoppingCartActivity::class.java)
        startActivity(mainActivity, intent, null)
    }
}