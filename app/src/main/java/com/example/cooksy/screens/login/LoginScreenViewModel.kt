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

    private val _confirmPassword = MutableLiveData<String>()
    val confirmPassword: LiveData<String> = _confirmPassword

    private val _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean> = _error

    fun isError(){
        _error.value = true
    }
    fun isNotError(){
        _error.value = false
    }
    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
    }

    fun onConfirmPasswordChange(confirmPassword:String){
        _confirmPassword.value = confirmPassword
    }
    fun logIn(
        email:String,
        password:String,
        home: () -> Unit
    ) =
        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnSuccessListener {authResult->
                        Log.d("FB", "" +
                                "singInWithEmailAndPassword Logueado!!!: $authResult")
                        home()
                    }
                    .addOnFailureListener{ex->
                        Log.d("FB", "" +
                                "singInWithEmailAndPassword Falló!!!: ${ex.localizedMessage}")
                    }
            }
            catch (ex:Exception){
                Log.d("Cooksy",ex.message.toString())

            }
        }

    fun register(
        email:String,
        password:String,
        home: () -> Unit
    ){
        if (_loading.value == false){
            _loading.value = true
            auth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener {authResult->
                    Log.d("FB", "" +
                            "singInWithEmailAndPassword Logueado!!!: $authResult")
                    home()
                }

                .addOnFailureListener{ex->
                        Log.d("FB", "" +
                                "singInWithEmailAndPassword Falló!!!: ${ex.localizedMessage}")
                }
                    _loading.value = false

        }
    }
}