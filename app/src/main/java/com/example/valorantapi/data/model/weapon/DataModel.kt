package com.example.valorantapi.data.model.weapon


import com.google.gson.annotations.SerializedName

data class DataModel(
    @SerializedName("assetPath")
    val assetPath: String? = "",
    @SerializedName("category")
    val category: String? = "",
    @SerializedName("defaultSkinUuid")
    val defaultSkinUuid: String? = "",
    @SerializedName("displayIcon")
    val displayIcon: String? = "",
    @SerializedName("displayName")
    val displayName: String? = "",
    @SerializedName("killStreamIcon")
    val killStreamIcon: String? = "",
    @SerializedName("shopData")
    val shopData: ShopDataModel? = ShopDataModel(),
    @SerializedName("skins")
    val skins: List<SkinModel?>? = listOf(),
    @SerializedName("uuid")
    val uuid: String? = "",
    @SerializedName("weaponStats")
    val weaponStats: WeaponStatsModel? = WeaponStatsModel()
)