package com.example.valorantapi.ui.agent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.valorantapi.R
import com.example.valorantapi.data.api.ApiResponse
import com.example.valorantapi.databinding.FragmentAgentsBinding
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AgentsFragment : Fragment() {

    lateinit var binding: FragmentAgentsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = FragmentAgentsBinding.inflate(inflater, container, false)
        val root = binding.root

        val agentViewModel = ViewModelProvider(this)[AgentViewModel::class.java]


        agentViewModel.agentList.observe(viewLifecycleOwner) { response ->
            when (response) {
                is ApiResponse.SuccessState -> {
                    binding.progressBar.visibility = View.GONE
                    binding.rvAgentList.visibility = View.VISIBLE
                    binding.tvError.visibility = View.GONE
                    binding.rvAgentList.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = AgentListAdapter(response.data.data) { agent ->
                            findNavController().navigate(
                                R.id.action_agentsFragment_to_agentDetailsFragment,
                                bundleOf("displayName" to agent.displayName,
                                    "displayIcon" to agent.displayIcon,
                                    "description" to agent.description,
                                    "role" to agent.role?.displayName
                                )

                            )

                        }
                    }
                }
                is ApiResponse.ErrorState -> {
                    binding.progressBar.visibility = View.GONE
                    binding.tvError.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.GONE
                }
                else -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.rvAgentList.visibility = View.GONE
                    binding.tvError.visibility = View.GONE
                }
            }
        }

        //
        Firebase.analytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT,
            bundleOf(
                FirebaseAnalytics.Param.ITEM_ID to "232",
                FirebaseAnalytics.Param.ITEM_NAME to "Number",
                FirebaseAnalytics.Param.CONTENT_TYPE to "Dummy",
            )
        )

//        throw RuntimeException("Test Crash")

        return root



    }


}