package com.example.valorantapi.data.model.weapon


import com.google.gson.annotations.SerializedName

data class GridPositionModel(
    @SerializedName("column")
    val column: Int? = 0,
    @SerializedName("row")
    val row: Int? = 0
)