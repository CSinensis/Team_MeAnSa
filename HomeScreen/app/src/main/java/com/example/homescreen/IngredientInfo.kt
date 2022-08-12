package com.example.homescreen
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalFoundationApi::class)
@Composable

fun IngredientInfo(navController: NavController, ING_INDEX: Int){
    val item = Model.IngList[ING_INDEX]
    val name = item.productName

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Back to List") },
                backgroundColor = MaterialTheme.colors.primary,
                navigationIcon = {
                    IconButton(onClick = {navController.navigate(route = Screen.IngList.route)}) {
                        Icon(ImageVector.vectorResource(R.drawable.arrow), "")
                    }
                }
            )
        },
        content = {
                  Column(modifier = Modifier
                      .fillMaxSize()
                      .padding(15.dp)) {
                      Box(modifier = Modifier
                          .size(height = 300.dp, width = 300.dp)
                          .background(color = Color.LightGray)){

                      }
                      Divider(
                          color = Color.Black,
                          thickness = 2.dp,
                          modifier = Modifier
                              .padding(15.dp)
                      )
                      Row(){
                          Column() {
                              Text(text = "Land Use and Farming")
                              Text(text = "Processing")
                              Text(text = "Transport")
                              Text(text = "Retail, Packaging, Losses")
                          }
                          Column() {
                              Text(text = "10g")
                              Text(text = "10g")
                              Text(text = "10g")
                              Text(text = "10g")
                          }
                      }
                      Divider(
                          color = Color.Black,
                          thickness = 2.dp,
                          modifier = Modifier
                              .padding(15.dp)
                      )
                  }
        },
    )
//    Box(modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center)
//    {
//        Column(){
//            Text(
//                modifier = Modifier.clickable {
//                    navController.navigate(route = Screen.IngList.route)
//                },
//                text = "Ingredient Name:",
//                color = MaterialTheme.colors.primary,
//                fontSize = MaterialTheme.typography.h3.fontSize,
//                fontWeight = FontWeight.Bold
//            )
//            Text(
//                modifier = Modifier.clickable {
//                    navController.navigate(route = Screen.Home.route)
//                },
//                text = "Home",
//                color = MaterialTheme.colors.primary,
//                fontSize = MaterialTheme.typography.h3.fontSize,
//                fontWeight = FontWeight.Bold
//            )
//            Text(
//                text = name,
//                color = MaterialTheme.colors.primary,
//                fontSize = MaterialTheme.typography.h3.fontSize,
//                fontWeight = FontWeight.Bold
//            )
//            Text(
//                text = item.carbonFootprint.toString(),
//                color = MaterialTheme.colors.primary,
//                fontSize = MaterialTheme.typography.h3.fontSize,
//                fontWeight = FontWeight.Bold
//            )
//        }
//    }
}

@Composable
@Preview(showBackground = true)
fun IngredientInfoPreview(){
    IngredientInfo(
        navController = rememberNavController(), ING_INDEX = 1
    )
}