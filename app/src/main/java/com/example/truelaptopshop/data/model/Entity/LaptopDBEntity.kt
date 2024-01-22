package com.example.truelaptopshop.data.model.Entity

import androidx.room.*
import com.example.truelaptopshop.domain.model.PostModel

@Entity(
    tableName = "laptops",
    indices = [Index("id")],
)

data class LaptopDBEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val info: String
)