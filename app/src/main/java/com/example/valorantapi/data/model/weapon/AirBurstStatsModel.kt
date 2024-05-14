package com.example.valorantapi.data.model.weapon


import com.google.gson.annotations.SerializedName

data class AirBurstStatsModel(
    @SerializedName("burstDistance")
    val burstDistance: Double? = 0.0,
    @SerializedName("shotgunPelletCount")
    val shotgunPelletCount: Int? = 0
)