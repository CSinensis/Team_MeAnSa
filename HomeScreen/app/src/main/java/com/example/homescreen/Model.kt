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
    val add1 = Addable("Apple", R.drawable.apple)
    val add2 = Addable("Barley", R.drawable.barley)
    val add3 = Addable("Beef", R.drawable.beef)
    val add4 = Addable("Bread",R.drawable.bread)
    val add5 = Addable("Berries & Grapes",R.drawable.graps)
    val add6 = Addable("Chicken",R.drawable.chicken)
    val add7 = Addable("Cheese", R.drawable.cheese)
    val add8 = Addable("Coffee", R.drawable.coffee)
    val add9 = Addable("Chocolate", R.drawable.choco)
    val add10 = Addable("Egg", R.drawable.eggs)
    val add11 = Addable("Groundnuts", R.drawable.groundnuts)
    val add12 = Addable("Lamb & Mutton", R.drawable.lamb)
    val add13 = Addable("Milk", R.drawable.milk)
    val add14 = Addable("Olive Oil", R.drawable.olive_oil)
    val add15 = Addable("Onion & Leek", R.drawable.onion)
    val add16 = Addable("Pork", R.drawable.pork)
    val add17 = Addable("Potatoes", R.drawable.potatoes)
    val add18 = Addable("Rice", R.drawable.rice)
    val add19 = Addable("Carrot", R.drawable.carrots)
    val add20 = Addable("Shrimp", R.drawable.shrimp)
    val add21 = Addable("Tofu", R.drawable.tofu)
    val add22 = Addable("Tomatoes", R.drawable.tomatoes)
    val add23 = Addable("Wine", R.drawable.wine)


    var addableList: List<Addable> = mutableStateListOf(
        add1, add2, add3, add4, add5, add6, add7, add8, add9, add10, add11, add12, add13,
        add14, add15, add16, add17, add18, add19, add20, add21, add22, add23)
}



data class Addable (
    val name: String,
    val drawableID: Int
)

data class Person(
    val name: String,
    val username: String,
    val achievement: String,
)

data class Challenge(
    val title: String,
//    val complete: Boolean
)

object Challenges{
    var challenge1 = Challenge("Recycle leftovers from Denny’s")
    var challenge2 = Challenge("Bring reusable bag to the supermarket")
    var challenge3 = Challenge("Recycle waste")
    var challenge4 = Challenge("Cook at home with a meal plan")
    var challenge5 = Challenge("Eat more plant-based protein")
    var challenge6 = Challenge("Not using individually-wrapped produce for a week")

    // first person
    var ChallengeList1: List<Challenge> = mutableStateListOf(challenge1, challenge2, challenge3, challenge4, challenge5)
    //    second person
    var ChallengeList2: List<Challenge> = mutableStateListOf(challenge5, challenge6)



}

object People{
    var person1 = Person("Archana Chaudhary", "achaudhary0204","I recycle leftovers every week!")
    var person2 = Person("MeAnSa", "meansa2025","Bring personal bag when buying foods")

}

data class Friend(
    val name: String

)