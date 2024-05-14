package com.example.valorantapi.ui.weapon

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.valorantapi.databinding.FragmentWeaponsBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class WeaponsFragment : Fragment() {

    lateinit var binding: FragmentWeaponsBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeaponsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val weaponViewModel = ViewModelProvider(this)[WeaponsViewModel::class.java]

        weaponViewModel.weaponList.observe(viewLifecycleOwner) {

            binding.rvWeapons.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = WeaponsAdapter(it.data)
            }

        }

        return root

    }


}

