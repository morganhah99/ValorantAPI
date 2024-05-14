package com.example.valorantapi.ui.agent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.valorantapi.R
import com.example.valorantapi.databinding.FragmentAgentDetailsBinding
import com.example.valorantapi.databinding.FragmentAgentsBinding


/**
 * A simple [Fragment] subclass.
 * Use the [AgentDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AgentDetailsFragment : Fragment() {

    private lateinit var binding: FragmentAgentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAgentDetailsBinding.inflate(inflater, container, false)

        val root = binding.root

        val image = arguments?.getString("displayIcon")
        val name = arguments?.getString("displayName")
        val description = arguments?.getString("description")

        return root
    }

}