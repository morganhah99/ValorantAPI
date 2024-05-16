package com.example.valorantapi.ui.logout

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.valorantapi.LoginActivity
import com.google.firebase.auth.FirebaseAuth


class LogOutFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseAuth.getInstance().signOut()
        startActivity(Intent(activity, LoginActivity::class.java)).also { activity?.finish() }
    }


}