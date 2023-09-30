package com.example.cooksy.screens.login

import android.util.Log
import android.util.Patterns
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

    private val _emailValid = MutableLiveData<Boolean>()
    val emailValid: LiveData<Boolean> = _emailValid

    private val _passwordValid = MutableLiveData<Boolean>()
    val passwordValid: LiveData<Boolean> = _passwordValid

    private val _enabled = MutableLiveData<Boolean>()
    val enabled: LiveData<Boolean> = _enabled

    private val _active = MutableLiveData<Boolean>()
    val active: LiveData<Boolean> = _active

    private val _hidden = MutableLiveData<Boolean>()
    val hidden: LiveData<Boolean> = _hidden


    fun activeRadioButton(value:Boolean){
        _active.value = !value
    }
    fun hiddenPassword(value:Boolean){
        _hidden.value = !value
    }
    fun isEnabled(){
        _enabled.value = !_email.value.isNullOrEmpty() &&
                !_password.value.isNullOrEmpty()
    }
     fun confirmPasswordEmpty(){
         _enabled.value = !_confirmPassword.value.isNullOrEmpty() &&
                 !_email.value.isNullOrEmpty() &&
                 !_password.value.isNullOrEmpty()
     }
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

    fun isEmail(email: String) {
        _emailValid.value = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isPassword(password: String) {
        _passwordValid.value = password.length > 7
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