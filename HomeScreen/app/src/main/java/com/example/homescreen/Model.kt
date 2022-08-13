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
    val carbonFootprint: Long,
    val farm: Long = 2,
    val process: Long = 2,
    val transport: Long = 2,
    val other: Long = 2,
    val mapLocations: List<mapRef> = listOf(FootprintData.bm1,FootprintData.bm2,FootprintData.bm3)
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
    var challengeList: List<Challenge>,
    val distance: Int = 10,
    val profilePic: Int,
    var pastChallengeList: List<Challenge>
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
    var chal1 = Challenge("Limit water usage for the week")
    var chal2 = Challenge("Don't use plastic straws")
    var chal3 = Challenge("Support local farmers market")
    var chal4 = Challenge("Donate to food bank")
    var chal5 = Challenge("Plant leftover seeds in garden")
    var chal6 = Challenge("Go without meat or dairy")
    var chal7 = Challenge("Thrift clothing for the month")
    var chal8 = Challenge("Use public transportation")

    // first person
    var ChallengeList1: List<Challenge> = mutableStateListOf(challenge1, challenge2, challenge3,challenge4)

    var pastChallengeList1: List<Challenge> = mutableStateListOf(chal1,chal2,chal3,chal4,chal5)
    //    second person
    var ChallengeList2: List<Challenge> = mutableStateListOf(challenge5, challenge6)
    var pastChallengeList2: List<Challenge> = mutableStateListOf(chal6, chal7, chal8)

}

object People{
    var person1 = Person(
        "Archana Chaudhary",
        "achaudhary0204",
        "I recycle leftovers every week!",
        Challenges.ChallengeList1,
        profilePic = R.drawable.beef,
        pastChallengeList = Challenges.pastChallengeList1
    )
    var person2 = Person(
        "MeAnSa",
        "meansa2025",
        "Bring personal bag when buying foods",
        Challenges.ChallengeList2,
        profilePic = R.drawable.profilepic1,
        pastChallengeList = Challenges.pastChallengeList2
    )
}

object FriendList{
    var friendList: List<Person> = mutableStateListOf(People.person1,People.person2)
}

object FootprintData{
    val farmingCost = mapOf(
        "Beef" to 82.147,
        "Apples" to 0.197,
        "Cheese" to 19.916,
        "Coffee" to 14.573,
        "Chocolate" to 32.502,
        "Eggs" to 4.235,
        "Fish" to 11.086,
        "Corn" to 1.192,
        "Milk" to 2.265,
        "Nuts" to 0.117,
        "Rice" to 3.532
    )
    val processingCost = mapOf(
        "Beef" to 1.811,
        "Apples" to 0.004,
        "Cheese" to 0.74,
        "Coffee" to 0.613,
        "Chocolate" to 0.334,
        "Eggs" to 0.001,
        "Fish" to 0.045,
        "Corn" to 0.078,
        "Milk" to 0.154,
        "Nuts" to 0.051,
        "Rice" to 0.065
    )
    val transportCost = mapOf(
        "Beef" to 0.494,
        "Apples" to 0.096,
        "Cheese" to 0.139,
        "Coffee" to 0.135,
        "Chocolate" to 0.111,
        "Eggs" to 0.084,
        "Fish" to 0.247,
        "Corn" to 0.09,
        "Milk" to 0.093,
        "Nuts" to 0.107,
        "Rice" to 0.096
    )
    val otherCost = mapOf(
        "Beef" to 15.026,
        "Apples" to 0.132,
        "Cheese" to 3.082,
        "Coffee" to 13.207,
        "Chocolate" to 13.7,
        "Eggs" to 0.35,
        "Fish" to 2.255,
        "Corn" to 0.34,
        "Milk" to 0.639,
        "Nuts" to 0.158,
        "Rice" to 0.759
    )

    val bm1 = mapRef("Texas (1)", 31.96, -99.9)
    val bm2 = mapRef("Oklahoma (2)", 35.0,-97.0)
    val bm3 = mapRef("Missouri (3)", 37.96,-91.8318)
    val locations = mapOf(
        "Beef" to listOf(bm1,bm2,bm3),
        "Eggs" to listOf(bm1,bm2,bm3),
        "Apples" to listOf(bm1,bm2,bm3)
    )
}

data class mapRef(
    val title: String,
    val lat: Double,
    val long: Double
)
