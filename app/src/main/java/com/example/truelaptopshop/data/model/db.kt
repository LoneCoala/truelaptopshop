package com.example.truelaptopshop.data.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.truelaptopshop.data.model.Entity.LaptopDBEntity

@Database(
    version = 1,
    entities = [
        LaptopDBEntity::class
    ]
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun getlaptopDao(): LaptopDao
}