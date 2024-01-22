package com.example.truelaptopshop.domain.interactors

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.truelaptopshop.R
import com.example.truelaptopshop.presentation.favouritesLaptops.ShoppingCartActivity
import com.example.truelaptopshop.presentation.laptopDetail.LaptopContract
import com.example.truelaptopshop.presentation.laptopDetail.LaptopPresenterr
import com.squareup.picasso.Picasso

class ShowLaptopDetailsUseCase(private val presenterr: LaptopPresenterr, private val laptopName:TextView, private  var laptopGPU: TextView,     private  var laptopCPU: TextView
,    private  var laptopRAM: TextView,    private  var laptopSSD: TextView,    private  var laptopScreen: TextView,    private  var laptopOS: TextView,    private  var laptopColor: TextView,    private  var laptopPrice: TextView,
private  var laptopPic: ImageView
) {

     fun execute(name: String, gpu: String, cpu: String, ram: String, ssd: String, screen: String, os: String, color: String, pic: String, price: String) {
        laptopName.text = name
        laptopGPU.text = "Видеокарта: $gpu"
        laptopCPU.text = "Процессор: $cpu"
        laptopRAM.text = "Оперативная память: $ram"
        laptopSSD.text = "Размер SSD: $ssd"
        laptopScreen.text = "Размер экрана: $screen дм"
        laptopOS.text = "Операционная система: $os"
        laptopColor.text = "Цвет: $color"
        laptopPrice.text = "Цена: $price"

        Picasso.get()
            .load(pic)
            .into(laptopPic)
    }

}