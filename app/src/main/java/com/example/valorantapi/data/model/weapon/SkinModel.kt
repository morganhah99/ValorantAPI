package com.example.valorantapi.data.model.weapon


import com.google.gson.annotations.SerializedName

data class SkinModel(
    @SerializedName("assetPath")
    val assetPath: String? = "",
    @SerializedName("chromas")
    val chromas: List<ChromaModel?>? = listOf(),
    @SerializedName("contentTierUuid")
    val contentTierUuid: String? = "",
    @SerializedName("displayIcon")
    val displayIcon: String? = "",
    @SerializedName("displayName")
    val displayName: String? = "",
    @SerializedName("levels")
    val levels: List<LevelModel?>? = listOf(),
    @SerializedName("themeUuid")
    val themeUuid: String? = "",
    @SerializedName("uuid")
    val uuid: String? = "",
    @SerializedName("wallpaper")
    val wallpaper: String? = ""
)