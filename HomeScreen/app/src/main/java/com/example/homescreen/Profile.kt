package com.example.signinscreen

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.homescreen.Person
import com.example.homescreen.R
import com.example.homescreen.Screen


@Composable
fun ProfileScreen(navController: NavController,scaffoldState: ScaffoldState = rememberScaffoldState()){
    val notification = rememberSaveable{ mutableStateOf("")}
    if (notification.value.isNotEmpty()){
        Toast.makeText(LocalContext.current, notification.value, Toast.LENGTH_LONG).show()
        notification.value = ""
    }
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
                                style = TextStyle(fontSize = 15.sp),
                                color = Color.Black
                            )
                        }
                        Button(
                            onClick = {navController.navigate(route = Screen.IngList.route)},
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray)) {
                            Text(
                                text = "Shopping List",
                                style = TextStyle(fontSize = 15.sp),
                                color = Color.White
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
//        my code start here (set profile image + info)
        content = {Column(    modifier = Modifier.padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(13.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // User's image
                Image(
                    modifier = Modifier
                        .size(98.dp)
                        .clip(shape = CircleShape),
                    painter = painterResource(id = R.drawable.profile_image),
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
                            text = person1.name,
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
                            text = person1.username,
                            style = TextStyle(
                                fontSize = 16.sp,
                                color = Color.Gray,
                                letterSpacing = (0.8).sp
                            ),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Row() {
                            Text(
                                text = person1.achievement,
                                style = TextStyle(
                                    fontSize = 13.sp,
                                    fontStyle = FontStyle.Italic,
                                    letterSpacing = (0.8).sp
                                )
                            )
                            Icon(
                                imageVector = Icons.Filled.Face,
                                tint = Color.Black,
                                modifier = Modifier.padding(end = 4.dp)
                            )
                        }
                    }
                }
            }
            ProfileImage()
            ProgressBar()
            Challenge()
        }
            }
        }
    )
}


@Composable
fun ProgressBar(){
    Column(modifier = Modifier
        .padding(15.dp)
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Your Weekly Carbon Impact",
            fontWeight = FontWeight.Bold, fontSize = 20.sp)}
    LinearProgressIndicator(
        progress = 0.7f,
        color = MainColor,
        modifier = Modifier
            .fillMaxWidth(0.85f)
            .height(15.dp),
        backgroundColor = Color.LightGray
    )
    Text(
        text = "60lbs",
        fontWeight = FontWeight.Bold,
        color = Color.Red,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, start = 320.dp)
    )
}

@Composable
fun Challenge(){
    fun Challenge(){
        Column(modifier = Modifier
            .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
//        .fillMaxSize(),
//    horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Divider(
                color = Color.Black,
                thickness = 3.dp,
                modifier = Modifier
                    .padding(15.dp)
            )
            Text(
                text = "Your Challenges:",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(end = 157.dp)
            )
            LazyColumn(
                modifier = Modifier
//                .fillMaxSize()
                    .background(Color.White)
                    .height(205.dp)

            ) {
                items(ChallengeList1) { model ->
                    SetChallenges(model = model)
                }
            }
            Button(
                onClick = {},
                shape = CutCornerShape(10),
                colors = ButtonDefaults.buttonColors(backgroundColor = MainColor))

            {
                Text(text = "Add Challenges to Yourself",color = Color.White)}
        }
    }

    @Composable
    fun SetChallenges(model: Challenge) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
        ) {
            val checkedStatus = remember {
                mutableStateOf(false)
            }
            Checkbox(
                checked = checkedStatus.value,
                onCheckedChange = { checkedStatus.value = it },
                modifier = Modifier.padding(1.dp)
            )
            Text(
                text = model.title,
                fontSize = 19.sp,
                color = Color.Black
            )
        }
    }


    @Preview(showBackground = true)

@Composable
fun ProfilePreview() {
    ProfileScreen(navController = rememberNavController())
}