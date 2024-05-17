package com.example.valorantapi.data.api

import com.example.valorantapi.data.model.agent.AgentModel
import com.example.valorantapi.data.model.githubrepo.RepoSearchResponse
import com.example.valorantapi.data.model.weapon.WeaponModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiEndpoints {

    @GET(ApiDetails.AGENTS_ENDPOINT)
    suspend fun getAgents(): AgentModel

    @GET(ApiDetails.WEAPONS_ENDPOINT)
    suspend fun getWeapons(): WeaponModel

    @GET(ApiDetails.GITHUB_ENDPOINT)
    suspend fun searchRepos(
        @Query("q") query: String,
        @Query("p") page: Int,
        @Query("per_page") itemsPerPage: Int
    ): RepoSearchResponse
}