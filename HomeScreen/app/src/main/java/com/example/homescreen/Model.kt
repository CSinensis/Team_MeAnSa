package com.example.homescreen

import androidx.compose.runtime.mutableStateListOf

object Model{
    val ing1 = Ingredient("hi",1,1)
    val ing2 = Ingredient("hi",1,1)
    val ing3 = Ingredient("hi",1,1)
    val ing4 = Ingredient("hi",1,1)
    val ing5 = Ingredient("hi",1,1)
    val ing6 = Ingredient("hi",1,1)




    var IngList: List<Ingredient> = mutableStateListOf(ing1,ing2,ing3,ing4,ing5,ing6)
//        mutableListOf()
}


data class Ingredient (
    val productName: String,
    val productQuantity: Long,
    val carbonFootprint: Long
)


object Addables{
    val add1 = Addable("beef", R.drawable.beef)
    val add2 = Addable("bread",R.drawable.bread)
    var addableList: List<Addable> = mutableStateListOf(add1)
}

data class Addable (
    val name: String,
    val drawableID: Int
        )
