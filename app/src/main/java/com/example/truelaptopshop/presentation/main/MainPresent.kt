package com.example.truelaptopshop.presentation.main;

import androidx.lifecycle.ViewModel
import com.example.truelaptopshop.data.API.ApiInterface
import com.example.truelaptopshop.data.model.Entity.laptop
import com.example.truelaptopshop.data.model.LaptopDao
import com.example.truelaptopshop.data.model.LaptopRepository
import com.example.truelaptopshop.domain.interactors.LoadPostsUseCase
import com.example.truelaptopshop.domain.interactors.OnShopClickedUseCase
import com.example.truelaptopshop.domain.model.PostModel


class MainPresent(private val view: MainContact.View, private val apiInterface: ApiInterface) :
        MainContact.Presenter {
        var loadPostsUseCase = LoadPostsUseCase(view, apiInterface)
        var onShopClickedUseCase = OnShopClickedUseCase(view)

        override fun loadPosts() {
                loadPostsUseCase.execute()
        }

        override fun onShopClicked() {
                onShopClickedUseCase.execute()
        }

}
