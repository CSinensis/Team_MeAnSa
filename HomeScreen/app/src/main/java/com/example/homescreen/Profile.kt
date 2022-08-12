package com.example.signinscreen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
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
import com.example.homescreen.R
import com.example.homescreen.Screen


@Composable
fun ProfileScreen(navController: NavController,scaffoldState: ScaffoldState = rememberScaffoldState()){
    val notification = rememberSaveable{ mutableStateOf("")}
    if (notification.value.isNotEmpty()){
        Toast.makeText(LocalContext.current, notification.value, Toast.LENGTH_LONG).show()
        notification.value = ""
    }
    var name by rememberSaveable{ mutableStateOf("default name")}
    var username by rememberSaveable{mutableStateOf("default username")}
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
        content = {Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(8.dp)
        ){
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ){
//            Text(
//                text = "Cancel",
//                modifier = Modifier.clickable{"Cancelled"})
//            Text(
//                text = "Save",
//                modifier = Modifier.clickable{"Profile Updated"}
//            )
//
//        }
            ProfileImage()
            Row(
                modifier = Modifier
                    .fillMaxSize(),
//                .padding(start = 4.dp, end = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "Name", modifier = Modifier.width(100.dp))
                TextField(value = name, onValueChange = {name = it})
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp, end = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "Username", modifier = Modifier.width(100.dp))
                TextField(value = username, onValueChange = {name = it})
            }
            ProgressBar()
            Challenge()
            }
        }
    )
}

@Composable
fun ProfileImage(){
    val painter = painterResource(R.drawable.user_image)

    Column(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally
    ){
        Card(
            shape = CircleShape,
            modifier = Modifier
                .padding(8.dp)
                .size(70.dp)
        ){
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .clickable {},
                contentScale = ContentScale.Crop
            )

        }
    }
}
@Composable
fun ProgressBar(){
    Column(modifier = Modifier
        .padding(20.dp)
        .fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Your Weekly Carbon Impact",
            fontWeight = FontWeight.Bold, fontSize = 20.sp)}
        LinearProgressIndicator(
            progress = 0.7f,
            color = MaterialTheme.colors.primaryVariant,
            modifier = Modifier
                .fillMaxWidth()
                .height(15.dp),
            backgroundColor = Color.LightGray
        )
}

@Composable
fun Challenge(){
    Column(modifier = Modifier
        .padding(15.dp)
        .fillMaxSize(),
//    horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Divider(
            color = Color.Black,
            thickness = 2.dp,
            modifier = Modifier
                .padding(15.dp)
        )
        Text(
            text = "Your Challenges:",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Column() {
            Row(){
            val checkedStatus1 = remember {
                mutableStateOf(false)
            }
            Checkbox(
                checked = checkedStatus1.value,
                onCheckedChange = { checkedStatus1.value = it },
                modifier = Modifier.padding(5.dp)
            )
            Text(
                text = "Recycle leftovers from Denny’s",
                modifier = Modifier.padding(15.dp),
                fontSize = 18.sp
            )}
            Row(){
            val checkedStatus2 = remember {
                mutableStateOf(false)
            }
            Checkbox(
                checked = checkedStatus2.value,
                onCheckedChange = { checkedStatus2.value = it },
                modifier = Modifier.padding(5.dp)
            )
            Text(
                text = "Turn off lights when not using",
                modifier = Modifier.padding(15.dp),
                fontSize = 18.sp
            )}
            Row(){
                val checkedStatus3 = remember {
                    mutableStateOf(false)
                }
                Checkbox(
                    checked = checkedStatus3.value,
                    onCheckedChange = { checkedStatus3.value = it },
                    modifier = Modifier.padding(5.dp)
                )
                Text(
                    text = "Bring reusable bag to the supermarket",
                    modifier = Modifier.padding(15.dp),
                    fontSize = 18.sp
                )
            }
            Button(modifier = Modifier.fillMaxSize(),
                onClick = {},
                shape = CutCornerShape(10),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant))

            {
                Text(text = "Add Challenges to Yourself",color = Color.White)}
        }
    }
}


@Preview(showBackground = true)

@Composable
fun ProfilePreview() {
    ProfileScreen(navController = rememberNavController())
}