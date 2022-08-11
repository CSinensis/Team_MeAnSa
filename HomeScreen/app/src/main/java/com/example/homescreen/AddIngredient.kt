package com.example.signinscreen

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.TopAppBar
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import com.example.signinscreen.ui.theme.MainColor

//class AddIngredient : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            AddIngredientPreview()
//        }
//    }
//}

@Composable
fun AddStuff() {
//    Questions "Which items you want to add?"
    Scaffold(
        topBar = {
            AppBar(
                onSearchClicked = {}
            )
        }
    ){}

//   Add Eggs and Bacon
    Column(modifier = Modifier
        .padding(40.dp)
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
//                    edit here
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            val checkedStatus1 = remember {
                mutableStateOf(false)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.eggs),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                )
                Row() {
                    Checkbox(
                        checked = checkedStatus1.value,
                        onCheckedChange = { checkedStatus1.value = it },
//                        modifier = Modifier.padding(1.dp)
                    )
                    Text(
                        text = "Eggs",
                        modifier = Modifier.padding(15.dp),
                        fontSize = 15.sp
                    )
                }
            }
            Column(horizontalAlignment = Alignment.End) {
                Image(
                    painter = painterResource(id = R.drawable.bacon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                )
                Row() {
                    Checkbox(
                        checked = checkedStatus1.value,
                        onCheckedChange = { checkedStatus1.value = it },
//                        modifier = Modifier.padding(5.dp)
                    )
                    Text(
                        text = "Bacon",
                        modifier = Modifier.padding(15.dp),
                        fontSize = 15.sp
                    )
                }
            }
            }

// Add Beef & Corn
        Column(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth() ){
            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
            ) {
                val checkedStatus1 = remember {
                    mutableStateOf(false)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.bread),
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                    )
                    Row() {
                        Checkbox(
                            checked = checkedStatus1.value,
                            onCheckedChange = { checkedStatus1.value = it },
//                            modifier = Modifier.padding(5.dp)
                        )
                        Text(
                            text = "Bread",
                            modifier = Modifier.padding(15.dp),
                            fontSize = 15.sp
                        )
                    }
                }
                Column(horizontalAlignment = Alignment.End) {
                    Image(
                        painter = painterResource(id = R.drawable.lettuce),
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                    )
                    Row() {
                        Checkbox(
                            checked = checkedStatus1.value,
                            onCheckedChange = { checkedStatus1.value = it },
//                            modifier = Modifier.padding(5.dp)
                        )
                        Text(
                            text = "Lettuce",
                            modifier = Modifier.padding(15.dp),
                            fontSize = 15.sp
                        )
                    }
                }
            }
// Add lettuce and bread
            Column(modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth()
                ) {
                    val checkedStatus1 = remember {
                        mutableStateOf(false)
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.beef),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                        )
                        Row() {
                            Checkbox(
                                checked = checkedStatus1.value,
                                onCheckedChange = { checkedStatus1.value = it },
//                            modifier = Modifier.padding(5.dp)
                            )
                            Text(
                                text = "Beef",
                                modifier = Modifier.padding(15.dp),
                                fontSize = 15.sp
                            )
                        }
                    }
                    Column(horizontalAlignment = Alignment.End) {
                        Image(
                            painter = painterResource(id = R.drawable.corn),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                        )
                        Row() {
                            Checkbox(
                                checked = checkedStatus1.value,
                                onCheckedChange = { checkedStatus1.value = it },
//                            modifier = Modifier.padding(5.dp)
                            )
                            Text(
                                text = "Corn",
                                modifier = Modifier.padding(15.dp),
                                fontSize = 15.sp
                            )
                        }
                    }
                }
            }

            }
        Button(
            onClick = {},
            shape = CutCornerShape(10),
            colors = ButtonDefaults.buttonColors(backgroundColor = MainColor))

        {
            Text(text = "Add Items to Shopping List",color = Color.White) }

    }
        }


@Composable
fun AppBar(onSearchClicked: () -> Unit){
    TopAppBar(
        backgroundColor = MainColor,
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
                    text = "Search items here...",
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

@Preview(showBackground = true)
@Composable
fun AddIngredientPreview(){
    AddStuff()
}