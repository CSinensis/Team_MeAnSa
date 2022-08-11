package com.example.homescreen

import androidx.compose.runtime.mutableStateListOf

object Model{
    val ing1 = Ingredient("hi",1,1)
    val ing2 = Ingredient("hi",1,1)
    val ing3 = Ingredient("hi",1,1)
    val ing4 = Ingredient("hi",1,1)
    val ing5 = Ingredient("hi",1,1)
    val ing6 = Ingredient("hi",1,1)
    val ing7 = Ingredient("hi",1,1)
    val ing8 = Ingredient("hi",1,1)
    val ing9 = Ingredient("hi",1,1)
    val ing10 = Ingredient("hi",1,1)



    var IngList: List<Ingredient> = mutableStateListOf(ing1,ing2,ing3,ing4,ing5,ing6,ing7,ing8,ing9,ing10)
//        mutableListOf()
}



data class Ingredient (
    val productName: String,
    val productQuantity: Long,
    val carbonFootprint: Long
)