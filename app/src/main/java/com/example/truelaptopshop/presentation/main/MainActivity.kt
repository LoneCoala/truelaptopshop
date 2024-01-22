package com.example.truelaptopshop.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.viewModelScope
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.example.truelaptopshop.R
import com.example.truelaptopshop.data.API.ApiInterface
import com.example.truelaptopshop.data.API.ServiceGenerator
import com.example.truelaptopshop.data.model.Dependencies
import com.example.truelaptopshop.data.model.Entity.LaptopDBEntity
import com.example.truelaptopshop.domain.interactors.NavigateToShoppingCartUseCase
import com.example.truelaptopshop.domain.interactors.ShowErrorUseCase
import com.example.truelaptopshop.domain.interactors.ShowPostsUseCase
import com.example.truelaptopshop.domain.model.PostModel
import com.example.truelaptopshop.presentation.favouritesLaptops.ShoppingCartActivity
import com.example.truelaptopshop.presentation.laptopDetail.LaptopActivity
import com.example.truelaptopshop.presentation.laptopDetail.LaptopContract
import com.example.truelaptopshop.presentation.laptopDetail.LaptopPresenterr

class MainActivity : AppCompatActivity(), MainContact.View {
    private lateinit var mytoolBar: Toolbar
    private lateinit var presenter: MainContact.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mytoolBar = findViewById(R.id.toolBar)
        setSupportActionBar(mytoolBar)

        val imageShop = findViewById<ImageView>(R.id.imageShop)
        imageShop.setOnClickListener {
            presenter.onShopClicked()
        }
        presenter = MainPresent(this, ServiceGenerator.buildService(ApiInterface::class.java))
        presenter.loadPosts()
    }


    override fun showPosts(posts: MutableList<PostModel>) {
        val rec = findViewById<RecyclerView>(R.id.recycleView)
        var main = this
        val showPostsUseCase = ShowPostsUseCase(posts, rec, main)
        showPostsUseCase.execute()
    }

    override fun showError(error: String) {
        val showErrorUseCase = ShowErrorUseCase(error)
        showErrorUseCase.execute()
    }

    override fun navigateToShoppingCart() {
        var navigateToShoppingCartUseCase = NavigateToShoppingCartUseCase(this, ShoppingCartActivity())
        navigateToShoppingCartUseCase.execute()
    }
}