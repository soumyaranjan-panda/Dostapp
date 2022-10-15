package com.example.dost.Objects

import androidx.annotation.DrawableRes

data class Dog(val id: Int,
               val name: String,
               val age: Int,
               val gender: String,
               val color: String,
               val weight: Double,
               val location: String,
               @DrawableRes val image: Int,
               val about: String,
               val description: String,
               val owner:  Owner)
