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

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeaponsBinding.inflate(inflater, container, false)

        val root: View = binding.root

        return root
    }


}