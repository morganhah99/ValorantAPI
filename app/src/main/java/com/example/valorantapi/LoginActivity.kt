package com.example.valorantapi

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import com.example.valorantapi.databinding.ActivityLoginBinding
import com.example.valorantapi.ui.MainActivity
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.security.MessageDigest
import java.util.UUID

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var auth: FirebaseAuth

    private fun isVerifiedUser() {
        auth.signInWithEmailAndPassword(
            binding.etEmail.text.toString(),
            binding.etPassword.text.toString()
        ).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d("LoginActivity", "loginUserWithEmail:success")
                val user = auth.currentUser
                goToHomeActivity()
            } else {
                // If sign in fails, display a message to the user.
                Log.w("LoginActivity", "createUserWithEmail:failure", task.exception)
                Toast.makeText(
                    baseContext,
                    "Authentication failed.",
                    Toast.LENGTH_SHORT,
                ).show()
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.btnLogin.setOnClickListener {
            isVerifiedUser()
        }

        binding.btnGoogleLogin.setOnClickListener {
            logInUsingGoogle()
        }

    }

    private fun logInUsingGoogle() {
        val context = this

        val coroutineScope = CoroutineScope(Dispatchers.Main)
        val WEB_CLIENT_ID = "1086027571480-6d815j44iku92jl50vlo085nn0lq2oqe.apps.googleusercontent.com"
        val credentialManager = CredentialManager.create(context)
        val rawNonce = UUID.randomUUID().toString()
        val bytes = rawNonce.toByteArray()
        val md = MessageDigest.getInstance("SHA-256")
        val digest = md.digest(bytes)
        val hashedNonce = digest.fold(""){str, it -> str + "%02x".format(it) }

        val googleIdOption: GetGoogleIdOption = GetGoogleIdOption
            .Builder()
            .setFilterByAuthorizedAccounts(false)
            .setServerClientId(WEB_CLIENT_ID)
            .setNonce(hashedNonce)
            .build()

        val request: GetCredentialRequest = GetCredentialRequest
            .Builder()
            .addCredentialOption(googleIdOption)
            .build()

        coroutineScope.launch {
            val result = credentialManager.getCredential(
                request = request,
                context = context,
            )
            val credential = result.credential

            val googleIdTokenCredential = GoogleIdTokenCredential
                .createFrom(credential.data)

            val googleIdToken = googleIdTokenCredential.idToken

            Log.i(TAG,googleIdToken )

            Toast.makeText(context, "Signed In", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onStart() {
        super.onStart()
        val user = auth.currentUser
        if (user != null) goToHomeActivity()
    }

    fun goToHomeActivity() {
        startActivity(
            Intent(this,
                MainActivity::class.java
            )
        ).also { this@LoginActivity.finish() }
    }
}