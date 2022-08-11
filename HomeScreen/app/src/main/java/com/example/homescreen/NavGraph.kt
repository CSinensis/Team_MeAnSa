package com.example.homescreen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(navController = navController,
        startDestination = Screen.Home.route){
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
            route = Screen.IngredientInfo.route
        ){
            IngredientInfo(navController = navController)
        }

    }
}