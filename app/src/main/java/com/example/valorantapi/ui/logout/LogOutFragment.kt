package com.example.valorantapi.ui.logout

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.valorantapi.LoginActivity
import com.example.valorantapi.R
import com.google.firebase.auth.FirebaseAuth


class LogOutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        FirebaseAuth.getInstance().signOut()
        startActivity(Intent(activity, LoginActivity::class.java)).also { activity?.finish() }
        return inflater.inflate(R.layout.fragment_log_out, container, false)
    }


}