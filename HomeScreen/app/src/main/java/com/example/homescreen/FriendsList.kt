package com.example.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun FriendsListCurrentScreen(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavController
) {
    var friendsList = remember{FriendList.friendList.toMutableStateList<Person>()}
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
                                style = TextStyle(fontSize = 18.sp),
                                color = Color.White
                            )
                        }
                        Button(
                            onClick = {navController.navigate(route = Screen.IngList.route)},
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray)) {
                            Text(
                                text = "Shopping List",
                                style = TextStyle(fontSize = 18.sp),
                                color = Color.White
                            )
                        }
                        Button(
                            onClick = {navController.navigate(route = Screen.FriendsList.route)},
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)) {
                            Text(
                                text = "Friends List",
                                style = TextStyle(fontSize = 18.sp),
                                color = Color.Black
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
                        itemsIndexed(friendsList) { index, item ->
                            if (index != 0){
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(all = 8.dp)
                                ) {
                                    Surface(
                                        shape = RoundedCornerShape(8.dp),
                                        elevation = 4.dp,
                                        modifier = Modifier.clickable(onClick = {})
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(all = 8.dp)
                                        ) {
                                            val image = painterResource(item.profilePic)
                                            Image(
                                                painter = image,
                                                contentDescription = null,
                                                modifier = Modifier.size(50.dp)
                                                    .clip(shape = CircleShape),
                                                contentScale = ContentScale.Crop,

                                                )
                                            Text(
                                                text = item.name,
                                                modifier = Modifier
                                                    .weight(1f)
                                                    .padding(8.dp)
                                            )
                                            Button(
                                                onClick = {
                                                    navController.navigate(
                                                        route = Screen.FriendProfile.passFriendID(
                                                            FriendList.friendList.indexOf(item)
                                                        )
                                                    )
                                                },
                                                colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray)
                                            ) {
                                                Text(
                                                    text = "View Profile",
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
        }
    )
}






@Composable
@Preview(showBackground = true)
fun FriendsListPreview(){
    FriendsListCurrentScreen(navController = rememberNavController())
}
