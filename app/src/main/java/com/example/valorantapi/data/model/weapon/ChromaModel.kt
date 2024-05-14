package com.example.valorantapi.data.model.weapon


import com.google.gson.annotations.SerializedName

data class ChromaModel(
    @SerializedName("assetPath")
    val assetPath: String? = "",
    @SerializedName("displayIcon")
    val displayIcon: String? = "",
    @SerializedName("displayName")
    val displayName: String? = "",
    @SerializedName("fullRender")
    val fullRender: String? = "",
    @SerializedName("streamedVideo")
    val streamedVideo: String? = "",
    @SerializedName("swatch")
    val swatch: String? = "",
    @SerializedName("uuid")
    val uuid: String? = ""
)