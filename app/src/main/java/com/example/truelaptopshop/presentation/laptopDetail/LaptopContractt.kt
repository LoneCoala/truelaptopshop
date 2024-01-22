package com.example.truelaptopshop.presentation.laptopDetail

import android.content.Intent

interface LaptopContract {
    interface View {
        fun showLaptopDetails(name: String, gpu: String, cpu: String, ram: String, ssd: String, screen: String, os: String, color: String, pic: String, price: String)
        fun navigateToCart()
    }

    interface Presenter {
        fun loadData(intent: Intent)
        fun onCartClicked()
    }

    interface Repository {

    }
}