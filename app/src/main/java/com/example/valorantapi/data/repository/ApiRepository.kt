package com.example.valorantapi.data.repository

import com.example.valorantapi.data.model.agent.AgentModel
import com.example.valorantapi.data.model.weapon.WeaponModel

interface ApiRepository {


    suspend fun getAgents():List<AgentModel>

    suspend fun getWeapons():List<WeaponModel>

}