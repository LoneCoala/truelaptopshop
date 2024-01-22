package com.example.truelaptopshop.data.model


import android.content.Context
import androidx.room.Room


object Dependencies {

    private lateinit var applicationContext: Context

    fun init(context: Context) {
        applicationContext = context
    }

    private val appDatabase: AppDatabase by lazy {
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database.db")
            .createFromAsset("assets/database.db")
            .build()
    }

    val laptopRepository: LaptopRepository by lazy { LaptopRepository(appDatabase.getlaptopDao()) }
}