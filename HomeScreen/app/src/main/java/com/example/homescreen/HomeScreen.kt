package com.example.homescreen
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable

fun HomeScreen(navController: NavController){
    Box(modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center)
    {
        Column(){
            Text(
                modifier = Modifier.clickable {
                    println("hello")
                    navController.navigate(route = Screen.IngList.route)
                },
                text = "Home",
                color = MaterialTheme.colors.primary,
                fontSize = MaterialTheme.typography.h3.fontSize,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.clickable {
                    println("hello")
                    navController.navigate(route = Screen.IngredientInfo.passID(0))
                },
                text = "Ingredient",
                color = MaterialTheme.colors.primary,
                fontSize = MaterialTheme.typography.h3.fontSize,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    HomeScreen(
        navController = rememberNavController()
    )
}