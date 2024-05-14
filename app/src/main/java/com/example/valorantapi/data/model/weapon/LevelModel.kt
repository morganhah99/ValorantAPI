package com.example.valorantapi.data.model.weapon


import com.google.gson.annotations.SerializedName

data class LevelModel(
    @SerializedName("assetPath")
    val assetPath: String? = "",
    @SerializedName("displayIcon")
    val displayIcon: String? = "",
    @SerializedName("displayName")
    val displayName: String? = "",
    @SerializedName("levelItem")
    val levelItem: String? = "",
    @SerializedName("streamedVideo")
    val streamedVideo: String? = "",
    @SerializedName("uuid")
    val uuid: String? = ""
)