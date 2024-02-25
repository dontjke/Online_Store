package com.stepanov.onlinestore.repository


import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("items")
    val items: List<Item>
)