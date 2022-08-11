package com.example.homescreen

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object IngList: Screen(route = "ing_list")
    object IngredientInfo: Screen(route = "ingredient_info")

}