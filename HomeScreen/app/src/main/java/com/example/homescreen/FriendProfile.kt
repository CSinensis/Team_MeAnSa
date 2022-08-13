package com.example.signinscreen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.homescreen.FriendList
import com.example.homescreen.R
import com.example.homescreen.Screen


@Composable
fun FriendProfileScreen(personIndex: Int,navController: NavController,scaffoldState: ScaffoldState = rememberScaffoldState()){
    val notification = rememberSaveable{ mutableStateOf("")}
    if (notification.value.isNotEmpty()){
        Toast.makeText(LocalContext.current, notification.value, Toast.LENGTH_LONG).show()
        notification.value = ""
    }
    val person = FriendList.friendList[personIndex]
//    var name by rememberSaveable{ mutableStateOf("default name")}
//    var username by rememberSaveable{mutableStateOf("default username")}
    Scaffold(scaffoldState = scaffoldState,
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
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)){
                            Text(
                                text = "Profile",
                                style = TextStyle(fontSize = 18.sp),
                                color = Color.Black
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
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray)) {
                            Text(
                                text = "Friends List",
                                style = TextStyle(fontSize = 18.sp),
                                color = Color.White
                            )
                        }
                    }
                    Text(text = stringResource(id = R.string.app_name)) },
                backgroundColor = MaterialTheme.colors.primaryVariant,
            )
        },
//        my code start here (set profile image + info)
        content = {
            Column(    modifier = Modifier.padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(13.dp),
                verticalAlignment = Alignment.CenterVertically) {
                // User's image
                Image(
                    modifier = Modifier
                        .size(98.dp)
                        .clip(shape = CircleShape),
                    painter = painterResource(id = person.profilePic),
                    contentDescription = "Your Image"
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .weight(weight = 3f, fill = false)
                            .padding(start = 16.dp)
                    ) {

                        // User's name
                        Text(
                            text = person.name,
                            style = TextStyle(
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold
                            ),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        // Username
                        Text(
                            text = person.username,
                            style = TextStyle(
                                fontSize = 16.sp,
                                color = Color.Gray,
                                letterSpacing = (0.8).sp
                            ),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Row{
                            Text(
                                text = person.achievement,
                                style = TextStyle(
                                    fontSize = 13.sp,
                                    fontStyle = FontStyle.Italic,
                                    letterSpacing = (0.8).sp
                                )
                            )
//                            Icon(
//                                imageVector = Icons.Filled.Face,
//                                tint = Color.Black,
//                                modifier = Modifier.padding(end = 4.dp)
//                            )
                        }
                    }
                }
            }
            ProgressBar(person)
            Challenge(person, navController)
        }
        },
        bottomBar = {
            TopAppBar(
                title = { Text(text = "Back to Friend List") },
                backgroundColor = MaterialTheme.colors.primary,
                navigationIcon = {
                    IconButton(onClick = {navController.navigate(route = Screen.FriendsList.route)}) {
                        Icon(ImageVector.vectorResource(R.drawable.arrow), "")
                    }
                }
            )
        }
    )
}



@Preview(showBackground = true)

@Composable
fun FriendProfilePreview() {
    FriendProfileScreen(navController = rememberNavController(), personIndex = 1)
}