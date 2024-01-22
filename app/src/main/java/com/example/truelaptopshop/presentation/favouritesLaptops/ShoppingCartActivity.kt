package com.example.truelaptopshop.presentation.favouritesLaptops

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.truelaptopshop.R
import com.example.truelaptopshop.data.API.ApiInterface
import com.example.truelaptopshop.data.model.Dependencies
import com.example.truelaptopshop.domain.interactors.LoadPostsUseCase
import com.example.truelaptopshop.presentation.main.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ShoppingCartActivity : AppCompatActivity() {
    private val viewModel by lazy { (Dependencies.laptopRepository) }
    private var recyclerView = findViewById<RecyclerView>(R.id.recycleView)

    override  fun onCreate(savedInstanceState: Bundle?) {
        lifecycleScope.launch {
            aboba()
        }
        Dependencies.init(applicationContext)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart)

    }

    suspend fun aboba() {
        viewModel.getAllLaptopData()
    }

}