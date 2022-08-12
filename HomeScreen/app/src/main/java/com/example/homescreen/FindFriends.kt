package com.example.homescreen
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
@Preview(showBackground = true)

fun FindFriendsPreview(){
    FindFriends(
        navController = rememberNavController()
    )
}