package com.example.valorantapi.data.model.weapon


import com.google.gson.annotations.SerializedName

data class AltShotgunStatsModel(
    @SerializedName("burstRate")
    val burstRate: Double? = 0.0,
    @SerializedName("shotgunPelletCount")
    val shotgunPelletCount: Int? = 0
)