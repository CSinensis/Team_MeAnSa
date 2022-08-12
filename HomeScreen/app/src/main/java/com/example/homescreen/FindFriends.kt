package com.example.homescreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable

fun FindFriends(navController: NavController){
    Box(modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center
    ){
        Text(
            modifier = Modifier.clickable {
                navController.navigate(route = Screen.FriendsList.route)
            },
            text = "Home",
            color = MaterialTheme.colors.primary,
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun AppBar(onSearchClicked: () -> Unit){
    TopAppBar(
        backgroundColor = MaterialTheme.colors.primaryVariant,
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Search for people",
                    modifier = Modifier.clickable { "Cancelled" },
                    color = Color.White,
                    fontSize = 20.sp
                )
                androidx.compose.foundation.Image(
                    painter = painterResource(id = R.drawable.search_ic),
                    contentDescription = "Search Icon")
            }
        }
    }
}

@Composable
fun FindFriendsScreen(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavController
) {
    var friendsList = remember{ Model.IngList.toMutableStateList<Friend>()}
    val openDialog = remember{mutableStateOf(false)}
    var newFriendName by remember { mutableStateOf("")}
    Scaffold(
        scaffoldState = scaffoldState,
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
                                            onClick = {navController.navigate(route = Screen.FriendsRequestConfirm.route)},
                                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray)){
                                            Text(
                                                text = "Add Friend",
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

fun FindFriendsPreview(){
    FindFriendsScreen(
        navController = rememberNavController()
    )
}