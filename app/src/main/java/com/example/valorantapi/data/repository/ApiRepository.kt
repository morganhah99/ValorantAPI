package com.example.valorantapi.data.repository

import com.example.valorantapi.data.model.agent.DataModel

interface ApiRepository {


    suspend fun getAgents():List<DataModel>

    suspend fun getWeapons():List<DataModel>

}