package com.example.truelaptopshop.presentation.laptopDetail

import android.content.Intent
import androidx.lifecycle.viewModelScope
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.truelaptopshop.R
import com.example.truelaptopshop.data.model.Dependencies
import com.example.truelaptopshop.data.model.Entity.LaptopDBEntity
import com.example.truelaptopshop.domain.interactors.NavigateToShoppingCartUseCase
import com.example.truelaptopshop.domain.interactors.ShowLaptopDetailsUseCase
import com.example.truelaptopshop.domain.model.PostModel
import com.example.truelaptopshop.presentation.favouritesLaptops.ShoppingCartActivity
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class LaptopActivity() : ComponentActivity(), LaptopContract.View, CoroutineScope {
    private lateinit var presenter: LaptopContract.Presenter
    private lateinit var laptopName: TextView
    private lateinit var laptopGPU: TextView
    private lateinit var laptopCPU: TextView
    private lateinit var laptopRAM: TextView
    private lateinit var laptopSSD: TextView
    private lateinit var laptopScreen: TextView
    private lateinit var laptopOS: TextView
    private lateinit var laptopColor: TextView
    private lateinit var laptopPrice: TextView
    private lateinit var laptopPic: ImageView
    private val viewModel by lazy { (Dependencies.laptopRepository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laptop)
        presenter = LaptopPresenterr(this)
        laptopName = findViewById(R.id.laptopName)
        laptopGPU = findViewById(R.id.laptopGPU)
        laptopCPU = findViewById(R.id.laptopCPU)
        laptopRAM = findViewById(R.id.laptopRAM)
        laptopSSD = findViewById(R.id.laptopSSD)
        laptopScreen = findViewById(R.id.laptopScreen)
        laptopOS = findViewById(R.id.laptopOS)
        laptopColor = findViewById(R.id.laptopColor)
        laptopPrice = findViewById(R.id.laptopPrice)
        laptopPic = findViewById(R.id.imageView)

        Dependencies.init(applicationContext)

        val imageShop = findViewById<ImageView>(R.id.imageShop)
        imageShop.setOnClickListener {
            presenter.onCartClicked()
        }

        presenter.loadData(intent)
    }

    override fun showLaptopDetails(name: String, gpu: String, cpu: String, ram: String, ssd: String, screen: String, os: String, color: String, pic: String, price: String) {
        val showLaptopDetailsUseCase = ShowLaptopDetailsUseCase(LaptopPresenterr(this),laptopName,laptopGPU,laptopCPU,laptopRAM,laptopSSD,laptopScreen,laptopOS,laptopColor,laptopPrice,laptopPic)
        showLaptopDetailsUseCase.execute(name, gpu, cpu, ram, ssd, screen, os, color, pic, price)

        val shopCart = findViewById<Button>(R.id.shopButton)
        shopCart.setOnClickListener {
            lifecycleScope.launch {
                val a = LaptopDBEntity(1, name)
                viewModel.insertNewLaptopData(a)
            }
        }
    }

    override fun navigateToCart() {
        var navigateToShoppingCartUseCase = NavigateToShoppingCartUseCase(this, ShoppingCartActivity())
        navigateToShoppingCartUseCase.execute()
    }

    override val coroutineContext: CoroutineContext
        get() = TODO("Not yet implemented")
}



class LaptopRepository : LaptopContract.Repository {

}
