package com.example.valorantapi.data.model.weapon


import com.google.gson.annotations.SerializedName

data class DamageRangeModel(
    @SerializedName("bodyDamage")
    val bodyDamage: Int? = 0,
    @SerializedName("headDamage")
    val headDamage: Double? = 0.0,
    @SerializedName("legDamage")
    val legDamage: Double? = 0.0,
    @SerializedName("rangeEndMeters")
    val rangeEndMeters: Int? = 0,
    @SerializedName("rangeStartMeters")
    val rangeStartMeters: Int? = 0
)