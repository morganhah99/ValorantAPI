package com.example.valorantapi.data.api

import com.example.valorantapi.data.model.agent.DataModel
import retrofit2.http.GET

interface ApiEndpoints {

    @GET(ApiDetails.AGENTS_ENDPOINT)
    suspend fun getAgents():List<DataModel>

    @GET(ApiDetails.WEAPONS_ENDPOINT)
    suspend fun getWeapons():List<DataModel>
}