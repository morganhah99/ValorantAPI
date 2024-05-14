package com.example.valorantapi.data.model.weapon


import com.google.gson.annotations.SerializedName

data class ShopDataModel(
    @SerializedName("assetPath")
    val assetPath: String? = "",
    @SerializedName("canBeTrashed")
    val canBeTrashed: Boolean? = false,
    @SerializedName("category")
    val category: String? = "",
    @SerializedName("categoryText")
    val categoryText: String? = "",
    @SerializedName("cost")
    val cost: Int? = 0,
    @SerializedName("gridPosition")
    val gridPosition: GridPositionModel? = GridPositionModel(),
    @SerializedName("image")
    val image: AnyModel? = AnyModel(),
    @SerializedName("newImage")
    val newImage: String? = "",
    @SerializedName("newImage2")
    val newImage2: AnyModel? = AnyModel(),
    @SerializedName("shopOrderPriority")
    val shopOrderPriority: Int? = 0
)