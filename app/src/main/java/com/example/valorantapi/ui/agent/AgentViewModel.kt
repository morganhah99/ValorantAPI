package com.example.valorantapi.ui.agent

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorantapi.data.model.agent.AgentModel
import com.example.valorantapi.data.model.agent.DataModel
import com.example.valorantapi.data.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentViewModel @Inject constructor(private val repository:ApiRepository) :ViewModel(){
    private val _agentList = MutableLiveData<AgentModel>()
    val agentList: LiveData<AgentModel> = _agentList


    init {
        getAllAgents()
    }

    private fun getAllAgents() {

        viewModelScope.launch {
            val allAgents = repository.getAgents()

            if(allAgents != null){
                _agentList.postValue(allAgents)
            }

            Log.d("AgentViewModel",allAgents.toString())
        }

    }


}