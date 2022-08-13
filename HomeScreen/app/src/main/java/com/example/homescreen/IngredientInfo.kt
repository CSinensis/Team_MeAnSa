package com.example.homescreen
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@OptIn(ExperimentalFoundationApi::class)
@Composable

fun IngredientInfo(navController: NavController, ING_INDEX: Int){
    val item = Model.IngList[ING_INDEX]
    val markers = item.mapLocations
    val center = LatLng(39.8, -98.5)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(center, 2f)
    }
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
                      Text(text = "Item Name: ${item.productName}",
                      fontWeight = FontWeight.Bold,
                      fontSize = 24.sp,
                      modifier = Modifier.padding(start = 15.dp,bottom = 15.dp))
                      Box(modifier = Modifier
                          .size(height = 350.dp, width = 330.dp)
                          .background(color = Color.LightGray).align(Alignment.CenterHorizontally)
                      ){
                          GoogleMap(
                              modifier = Modifier.fillMaxSize(),
                              cameraPositionState = cameraPositionState
                          ){
                              Marker(
                                  state = MarkerState(position = LatLng(markers[0].lat,markers[0].long)),
                                  title = markers[0].title
                              )
                              Marker(
                                  state = MarkerState(position = LatLng(markers[1].lat,markers[1].long)),
                                  title = markers[1].title
                              )
                              Marker(
                                  state = MarkerState(position = LatLng(markers[2].lat,markers[2].long)),
                                  title = markers[2].title
                              )
                          }
                      }
                      Divider(
                          color = Color.Black,
                          thickness = 2.dp,
                          modifier = Modifier
                              .padding(15.dp)
                      )
                      Row(modifier = Modifier
                          .fillMaxWidth()
                          .padding(start = 15.dp), horizontalArrangement = Arrangement.Start){
                          Text(text = "Carbon Footprint Breakdown",
                              fontSize = 19.sp,
                              fontWeight = FontWeight.Bold)
                      }
                      Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                          Column(modifier = Modifier.padding(start = 15.dp),horizontalAlignment = Alignment.Start) {
                              Text(text = "Land Use and Farming",
                                  fontSize = 19.sp)
                              Text(text = "Processing",
                                  fontSize = 19.sp)
                              Text(text = "Transport",
                                  fontSize = 19.sp)
                              Text(text = "Other",
                                  fontSize = 19.sp)
                              Text(text = "Total",
                                  fontSize = 19.sp,
                                  fontWeight = FontWeight.Bold
                              )
                          }
                          Column(modifier = Modifier.fillMaxWidth(),horizontalAlignment = Alignment.CenterHorizontally) {
                              Text(text = "${item.farm}g",
                                  fontSize = 19.sp)
                              Text(text = "${item.process}g",
                                  fontSize = 19.sp)
                              Text(text = "${item.transport}g",
                                  fontSize = 19.sp)
                              Text(text = "${item.other}g",
                                  fontSize = 19.sp)
                              Text(text = "${item.carbonFootprint}g",
                                  fontSize = 19.sp,
                              fontWeight = FontWeight.Bold)
                          }
                      }
                      Divider(
                          color = Color.Black,
                          thickness = 2.dp,
                          modifier = Modifier
                              .padding(15.dp)
                      )
                      Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
                          Button(
                              onClick = {},
                              colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
                          ) {
                              Text(
                                  text = "Request Ingredient from Friends",
                                  style = TextStyle(fontSize = 18.sp),
                                  color = Color.White)

                          }
                      }
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