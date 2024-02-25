package com.stepanov.onlinestore.repository


import com.google.gson.annotations.SerializedName

data class Feedback(
    @SerializedName("count")
    val count: Int,
    @SerializedName("rating")
    val rating: Double
)