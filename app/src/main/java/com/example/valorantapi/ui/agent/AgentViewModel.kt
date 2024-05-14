package com.example.valorantapi.ui.agent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorantapi.data.model.agent.AgentModel
import com.example.valorantapi.data.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentViewModel @Inject constructor(repository:ApiRepository) :ViewModel(){
    private val _agentList = MutableLiveData<ArrayList<AgentModel>>()
    val personList: LiveData<ArrayList<AgentModel>> = _agentList


    init {
        getAllAgents()
    }

    private fun getAllAgents() {

        viewModelScope.launch {
//            val allAgents =
        }

    }


}