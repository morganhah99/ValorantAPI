package com.example.valorantapi.ui.agent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.valorantapi.R
import com.example.valorantapi.databinding.FragmentAgentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AgentDetailsFragment : Fragment() {

    private lateinit var binding: FragmentAgentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAgentDetailsBinding.inflate(inflater, container, false)
        val agentImage = arguments?.getString("displayIcon")
        val description = arguments?.getString("description")
        val role = arguments?.getString("role")

        binding.apply {
            Glide.with(binding.root)
                .load(agentImage)
                .placeholder(R.drawable.ic_android_black_24dp)
                .into(ivAgent)
            tvRole.text = role
            tvDescription.text = description
        }

        return binding.root


    }

}