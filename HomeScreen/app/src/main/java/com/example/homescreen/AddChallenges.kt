package com.example.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.signinscreen.SetChallenges


//class AddIngredient : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            AddIngredientPreview()
//        }
//    }
//}

@Composable
fun AddChallenges(navController: NavController,personIndex:Int) {
    var newChallenge by remember { mutableStateOf("")}
    val person = FriendList.friendList[personIndex]
    var ChallengeList = remember{ person.challengeList.toMutableStateList<Challenge>()}
    var pastChallengeList = remember{person.pastChallengeList.toMutableStateList<Challenge>()}
//    Questions "Which items you want to add?"
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Return to Profile") },
                backgroundColor = MaterialTheme.colors.primary,
                navigationIcon = {
                    IconButton(onClick = {
                        if (personIndex == 0){
                            navController.navigate(route = Screen.Profile.route)
                        }
                        else {
                            navController.navigate(route = Screen.FriendProfile.passFriendID(personIndex))
                        }
                    }) {
                        Icon(ImageVector.vectorResource(R.drawable.arrow), "")
                    }
                }
            )
        },
        content = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment =  Alignment.CenterHorizontally
            ) {
                Box(
                    Modifier
                        .size(400.dp, 130.dp)
                        .padding(top = 5.dp)
                        // on below line we are adding background color
                        .background(MaterialTheme.colors.primaryVariant, RoundedCornerShape(10.dp))
                        // on below line we are adding border.
                        .border(1.dp, color = Color.LightGray, RoundedCornerShape(10.dp))
                ){
                    Column(verticalArrangement = Arrangement.SpaceEvenly){
                        Text(
                            text = "Add New Challenge",
                            modifier = Modifier.padding(start = 10.dp,top = 10.dp),
                            color = Color.White,
                            fontSize = 20.sp
                        )
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp, vertical = 10.dp),
                            value = newChallenge,
                            onValueChange = {newChallenge = it},
                            label = { Text(text = "Challenge Description") },
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.White
                            ),
                            trailingIcon = {
                                IconButton(onClick = {newChallenge = ""}) {
                                    Icon(imageVector = Icons.Filled.Clear, contentDescription = "")
                                }
                            }
                        )
                    }
                }
                Button(
                    onClick = {
                        ChallengeList += listOf(Challenge(newChallenge))
                        person.challengeList = ChallengeList
                        newChallenge = "" },
                    shape = CutCornerShape(10),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant))
                {
                    Text(text = "Add Challenge",color = Color.White) }
                Divider(
                    color = Color.Black,
                    thickness = 3.dp,
                    modifier = Modifier
                        .padding(15.dp)
                )
                Text(
                    text = "Your Active Challenges:",
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
                    itemsIndexed(ChallengeList) { _, item ->
                        Row(modifier = Modifier.fillMaxWidth()
                            .clickable{
                                pastChallengeList.add(item)
                                person.pastChallengeList = pastChallengeList
                                ChallengeList.remove(item)
                                person.challengeList = ChallengeList
                            }){
                            SetChallenges(challenge = item)
                        }
                        }
                }
                Divider(
                    color = Color.Black,
                    thickness = 3.dp,
                    modifier = Modifier
                        .padding(15.dp)
                )
                Text(
                    text = "Your Past Challenges:",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(end = 157.dp)
                )
                LazyColumn(
                    modifier = Modifier
//                .fillMaxSize()
                        .background(Color.White)
                        .height(160.dp)

                ) {
                    itemsIndexed(pastChallengeList) {_,item ->
                        PastChallenges(challenge = item)
                    }
                }
            }
        }
    )

}


//fun editChallenges(newChallenge: String,){
//    val newQuant = newIngQuant.toLong()
//    val carbonFootprint: Long = getCarbonFootprint(newIngName,newQuant)
//    val newIng = Ingredient(newIngName,newQuant,carbonFootprint)
//    person = Model.IngList + listOf(newIng)
//}

@Composable
fun PastChallenges(challenge: Challenge) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        val checkedStatus = remember {
            mutableStateOf(true)
        }
        Checkbox(
            checked = checkedStatus.value,
            onCheckedChange = { checkedStatus.value = it },
            modifier = Modifier.padding(1.dp)
        )
        Text(
            text = challenge.title,
            fontSize = 19.sp,
            color = Color.Black
        )
    }
}



@Preview(showBackground = true)
@Composable
fun AddChallengePreview(){
    AddChallenges(navController = rememberNavController(), personIndex = 0)
}