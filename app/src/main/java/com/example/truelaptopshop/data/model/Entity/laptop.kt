package com.example.truelaptopshop.data.model.Entity

import com.example.truelaptopshop.domain.model.PostModel


data class laptop(
    val info: String
) {

    fun toLaptopDbEntity(): LaptopDBEntity = LaptopDBEntity(
        id = 0,
        info = info
    )
}