package com.example.valorantapi.ui.agent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.valorantapi.databinding.FragmentAgentDetailsBinding



class AgentDetailsFragment : Fragment() {

    private lateinit var binding: FragmentAgentDetailsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentAgentDetailsBinding.inflate(inflater, container, false)
        val name = arguments?.getString("displayName")

        binding.apply {
            tvCharacterName.text = name
        }

        return binding.root


    }

}