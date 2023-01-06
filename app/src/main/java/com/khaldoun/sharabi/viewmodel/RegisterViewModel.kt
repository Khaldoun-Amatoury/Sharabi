package com.khaldoun.sharabi.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.khaldoun.sharabi.data.User
import com.khaldoun.sharabi.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel //dagger hilt injects dependencies in your
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

//classes

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val firebaseAuth: FirebaseAuth
): ViewModel(){

    private val _register = MutableStateFlow<Resource<FirebaseUser>>(Resource.Loading())
    val register: Flow<Resource<FirebaseUser>> = _register

    fun createAccountWithEmailAndPassword(user: User, password: String){
        firebaseAuth.createUserWithEmailAndPassword(user.email  , password) //loading
            .addOnSuccessListener { //is executed if the registration was successfully done
                it.user?.let{
                    _register.value = Resource.Success(it)
                }
            }.addOnFailureListener{ //failure
                _register.value = Resource.Error(it.message.toString())
            }
    }

}