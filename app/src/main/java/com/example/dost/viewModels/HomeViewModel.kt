package com.example.dost.viewModels

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import kotlin.math.absoluteValue

class HomeViewModel: ViewModel() {
    var dogId: MutableState<Int> = mutableStateOf(0)
    fun setdogId(dogIdValue:Int){
        dogId.value = dogIdValue
    }
}