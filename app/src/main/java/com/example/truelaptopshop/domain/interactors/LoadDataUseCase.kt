package com.example.truelaptopshop.domain.interactors

import android.content.Intent
import com.example.truelaptopshop.presentation.laptopDetail.LaptopContract
import com.example.truelaptopshop.presentation.laptopDetail.LaptopRepository


class LoadDataUseCase(private val view: LaptopContract.View) {
    private val repository: LaptopContract.Repository = LaptopRepository()

     fun execute(intent: Intent) {
        val name = intent.getStringExtra("name")
        val gpu = intent.getStringExtra("gpu")
        val cpu = intent.getStringExtra("cpu")
        val ram = intent.getStringExtra("ram")
        val ssd = intent.getStringExtra("ssd")
        val screen = intent.getStringExtra("screen")
        val os = intent.getStringExtra("os")
        val color = intent.getStringExtra("color")
        val pic = intent.getStringExtra("pic")
        val price = intent.getStringExtra("price")

        view.showLaptopDetails(name!!, gpu!!, cpu!!, ram!!, ssd!!, screen!!, os!!, color!!, pic!!, price!!)
    }
}