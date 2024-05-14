package com.example.valorantapi.data.model.weapon


import com.google.gson.annotations.SerializedName

data class WeaponStatsModel(
    @SerializedName("adsStats")
    val adsStats: AdsStatsModel? = AdsStatsModel(),
    @SerializedName("airBurstStats")
    val airBurstStats: AirBurstStatsModel? = AirBurstStatsModel(),
    @SerializedName("altFireType")
    val altFireType: String? = "",
    @SerializedName("altShotgunStats")
    val altShotgunStats: AltShotgunStatsModel? = AltShotgunStatsModel(),
    @SerializedName("damageRanges")
    val damageRanges: List<DamageRangeModel?>? = listOf(),
    @SerializedName("equipTimeSeconds")
    val equipTimeSeconds: Double? = 0.0,
    @SerializedName("feature")
    val feature: String? = "",
    @SerializedName("fireMode")
    val fireMode: String? = "",
    @SerializedName("fireRate")
    val fireRate: Double? = 0.0,
    @SerializedName("firstBulletAccuracy")
    val firstBulletAccuracy: Double? = 0.0,
    @SerializedName("magazineSize")
    val magazineSize: Int? = 0,
    @SerializedName("reloadTimeSeconds")
    val reloadTimeSeconds: Double? = 0.0,
    @SerializedName("runSpeedMultiplier")
    val runSpeedMultiplier: Double? = 0.0,
    @SerializedName("shotgunPelletCount")
    val shotgunPelletCount: Int? = 0,
    @SerializedName("wallPenetration")
    val wallPenetration: String? = ""
)