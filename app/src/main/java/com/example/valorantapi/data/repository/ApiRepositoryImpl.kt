package com.example.valorantapi.data.repository

import com.example.valorantapi.data.api.ApiEndpoints
import com.example.valorantapi.data.model.agent.DataModel
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(private val apiDetails: ApiEndpoints): ApiRepository{
    override suspend fun getAgents(): List<DataModel> = apiDetails.getAgents()

    override suspend fun getWeapons(): List<DataModel> = apiDetails.getWeapons()

}