package com.example.homescreen

const val ING_INDEX = "id"

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object SignIn: Screen(route = "sign_in_screen")
    object IngList: Screen(route = "ing_list")
    object IngredientInfo: Screen(route = "ingredient_info/{$ING_INDEX}"){
        fun passID(id: Int): String{
            return "ingredient_info/$id"
        }
    }
    object Profile: Screen(route = "profile")
    object AddIngredient: Screen(route = "add_ingredient")
    object FindFriends: Screen(route = "find_friends")
    object FriendsRequestConfirm: Screen(route = "friend_request_confirmation")
    object FriendsList: Screen(route = "friends_list")

}