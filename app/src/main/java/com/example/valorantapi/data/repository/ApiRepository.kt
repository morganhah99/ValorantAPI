package com.example.valorantapi.data.repository

import com.example.valorantapi.data.model.agent.AgentModel
import com.example.valorantapi.data.model.githubrepo.RepoSearchResponse
import com.example.valorantapi.data.model.weapon.WeaponModel

interface ApiRepository {


    suspend fun getAgents(): AgentModel

    suspend fun getWeapons(): WeaponModel

    suspend fun searchRepos(query: String, page: Int, itemsPerPage: Int = 10): RepoSearchResponse

}