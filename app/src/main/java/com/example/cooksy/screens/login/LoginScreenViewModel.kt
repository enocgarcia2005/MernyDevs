package com.example.cooksy.screens.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class LoginScreenViewModel:ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
    }

    fun logIn(email:String, password:String, home: () -> Unit) =
        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful){
                            Log.d("Cooksy","Bienvenido")
                            home()
                        }else{
                            Log.d("Cooksy",task.result.toString())
                        }
                    }
            }
            catch (ex:Exception){
                Log.d("Cooksy",ex.message.toString())

            }
        }
}