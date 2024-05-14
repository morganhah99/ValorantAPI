package com.example.valorantapi.ui.agent

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.valorantapi.R
import com.example.valorantapi.databinding.FragmentAgentsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AgentsFragment : Fragment() {

    lateinit var binding: FragmentAgentsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentAgentsBinding.inflate(inflater, container, false)
        val root = binding.root

        val agentViewModel = ViewModelProvider(this)[AgentViewModel::class.java]


        agentViewModel.agentList.observe(viewLifecycleOwner) {
            binding.rvAgentList.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = AgentListAdapter(it.data)
            }

            Log.d("AgentsFragment", it.data.toString())
        }


        // Inflate the layout for this fragment
        return root
    }


}