package com.example.valorantapi.data.model.weapon


import com.google.gson.annotations.SerializedName

data class AdsStatsModel(
    @SerializedName("burstCount")
    val burstCount: Int? = 0,
    @SerializedName("fireRate")
    val fireRate: Double? = 0.0,
    @SerializedName("firstBulletAccuracy")
    val firstBulletAccuracy: Double? = 0.0,
    @SerializedName("runSpeedMultiplier")
    val runSpeedMultiplier: Double? = 0.0,
    @SerializedName("zoomMultiplier")
    val zoomMultiplier: Double? = 0.0
)