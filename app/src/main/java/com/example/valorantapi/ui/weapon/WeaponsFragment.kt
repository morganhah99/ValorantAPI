package com.example.valorantapi.ui.weapon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.valorantapi.R
import com.example.valorantapi.databinding.FragmentWeaponsBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class WeaponsFragment : Fragment() {

    private var _binding: FragmentWeaponsBinding? = null

    private val weaponViewModel: WeaponsViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weapons, container, false)
    }


}