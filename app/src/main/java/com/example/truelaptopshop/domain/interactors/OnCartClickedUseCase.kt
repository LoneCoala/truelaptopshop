package com.example.truelaptopshop.domain.interactors

import android.content.Intent
import com.example.truelaptopshop.presentation.laptopDetail.LaptopContract
import com.example.truelaptopshop.presentation.laptopDetail.LaptopRepository

class OnCartClickedUseCase(private val view: LaptopContract.View) {
     fun execute() {
        view.navigateToCart()
    }
}