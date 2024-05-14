package com.example.valorantapi.ui.agent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.valorantapi.R


/**
 * A simple [Fragment] subclass.
 * Use the [AgentDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AgentDetailsFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_agent_details, container, false)
    }

}