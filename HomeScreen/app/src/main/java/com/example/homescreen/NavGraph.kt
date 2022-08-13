package com.example.homescreen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.signinscreen.FriendProfileScreen
import com.example.signinscreen.ProfileScreen


@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(navController = navController,
        startDestination = Screen.SignIn.route){
        composable(
            route = Screen.Home.route
        ){
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.IngList.route
        ){
            ProductListCurrentScreen(navController = navController)
        }
        composable(
            route = Screen.IngredientInfo.route,
            arguments = listOf(navArgument(ING_INDEX){
                type = NavType.IntType
            })
        ){
            val index = it.arguments?.getInt(ING_INDEX)
            if (index != null) {
                IngredientInfo(navController = navController,ING_INDEX = index)
            }
        }
        composable(
            route = Screen.SignIn.route
        ){
            SignInScreen(navController = navController)
        }
        composable(
            route = Screen.Profile.route
        ){
            ProfileScreen(navController = navController, person = People.person1)
        }
        composable(
            route = Screen.FriendProfile.route,
            arguments = listOf(navArgument(PERSON){
                type = NavType.IntType
            })
        ){
            val personIndex = it.arguments?.getInt(PERSON)
            if (personIndex != null){
                FriendProfileScreen(navController = navController, personIndex = personIndex)
            }
        }
        composable(
            route = Screen.AddChallenge.route,
            arguments = listOf(navArgument(CHAL){
                type = NavType.IntType
            })
        ){
            val personIndex = it.arguments?.getInt(CHAL)
            if (personIndex != null){
                AddChallenges(navController = navController, personIndex = personIndex)
            }
        }
        composable(
            route = Screen.AddIngredient.route
        ){
            AddStuff(navController = navController)
        }
        composable(
            route = Screen.FriendsList.route
        ){
            FriendsListCurrentScreen(navController = navController)
        }
        composable(
            route = Screen.FriendsRequestConfirm.route
        ){
            FriendRequestConfirmation(navController = navController)
        }
        composable(
            route = Screen.FindFriends.route
        ){
            FindFriends(navController = navController)
        }

    }
}