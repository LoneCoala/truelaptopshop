package com.example.truelaptopshop.domain.model

data class PostModel (
    var id: Int? = null,
    var name: String? = null,
    var gpu: String? = null,
    var cpu: String? = null,
    var ram: Int? = null,
    var ssd: Int? = null,
    var screen: Int? = null,
    var os: String? = null,
    var color: String? = null,
    var pic: String? = null,
    var price: Int? = null
)