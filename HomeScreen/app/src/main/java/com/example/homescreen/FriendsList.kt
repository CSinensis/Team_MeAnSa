package com.example.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable

fun FriendsList(navController: NavController){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(
            modifier = Modifier.clickable {
                navController.navigate(route = Screen.Home.route)
            },
            text = "Detail",
            color = MaterialTheme.colors.primary,
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun FriendsListCurrentScreen(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavController
) {
    var friendsList = remember{ Model.IngList.toMutableStateList<Friend>()}
    val openDialog = remember{mutableStateOf(false)}
    var newFriendName by remember { mutableStateOf("")}
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = {
                    Row(modifier = Modifier
                        .fillMaxWidth().fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly

                    ) {
                        Button(
                            onClick = {navController.navigate(route = Screen.Profile.route)},
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray)){
                            Text(
                                text = "Profile",
                                style = TextStyle(fontSize = 15.sp),
                                color = Color.White
                            )
                        }
                        Button(
                            onClick = {navController.navigate(route = Screen.IngList.route)},
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)) {
                            Text(
                                text = "Shopping List",
                                style = TextStyle(fontSize = 15.sp),
                                color = Color.Black
                            )
                        }
                        Button(
                            onClick = {navController.navigate(route = Screen.Profile.route)},
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray)) {
                            Text(
                                text = "Friends List",
                                style = TextStyle(fontSize = 15.sp),
                                color = Color.White
                            )
                        }
                    }
                    Text(text = stringResource(id = R.string.app_name)) },
                backgroundColor = MaterialTheme.colors.primaryVariant,
            )
        },
        content = {

            Column {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp, start = 8.dp, end = 30.dp)) {
                    Text(text = "Friends",modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                        .padding(8.dp))

                }
                Surface(modifier = Modifier.padding(all = Dp(5f))) {
                    LazyColumn {
                        itemsIndexed(friendsList) { _, item ->
                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .padding(all = 8.dp)) {
                                Surface(
                                    shape = RoundedCornerShape(8.dp),
                                    elevation = 4.dp,
                                    modifier = Modifier.clickable(onClick = {
                                        //navController.navigate(route = Screen.Profile.passID(Model.FriendsList.indexOf(item)))
                                    })
                                ) {
                                    Row(modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(all = 8.dp)) {
                                        val image = painterResource(R.drawable.user_image)
                                        Image(
                                            painter = image,
                                            contentDescription = null,
                                            modifier = Modifier
                                                .wrapContentSize()
                                                .clickable {},
                                            contentScale = ContentScale.Crop
                                        )
                                        Column (horizontalAlignment = Alignment.End){
                                            Text(
                                                text = item.name,
                                                modifier = Modifier
                                                    .weight(1f)
                                                    .align(Alignment.CenterVertically)
                                                    .padding(8.dp)
                                            )
                                            Text(
                                                text = item.distance.toString() + "miles",
                                                modifier = Modifier
                                                    .weight(1f)
                                                    .align(Alignment.CenterVertically)
                                                    .padding(8.dp)
                                            )
                                        }
                                        Button(
                                            onClick = {navController.navigate(route = Screen.IngRequest.route)},
                                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray)){
                                            Text(
                                                text = "Request Ingredient",
                                                style = TextStyle(fontSize = 15.sp),
                                                color = Color.White
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}






@Composable
@Preview(showBackground = true)
fun FriendsListPreview(){
    FriendsList(navController = rememberNavController())
    FriendsListCurrentScreen(navController = rememberNavController())
}
