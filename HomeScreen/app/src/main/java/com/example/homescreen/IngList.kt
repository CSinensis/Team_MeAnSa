package com.example.homescreen

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlin.math.round

@Composable
fun ProductListCurrentScreen(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavController
) {
    var ingrList = remember{ Model.IngList.toMutableStateList<Ingredient>()}
    val openDialog = remember{mutableStateOf(false)}
    var newIngName by remember { mutableStateOf("")}
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
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)) {
                            Text(
                                text = "Shopping List",
                                style = TextStyle(fontSize = 18.sp),
                                color = Color.Black
                            )
                        }
                        Button(
                            onClick = {navController.navigate(route = Screen.FriendsList.route)},
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray)) {
                            Text(
                                text = "Friends List",
                                style = TextStyle(fontSize = 18.sp),
                                color = Color(red = 0, blue = 0, green = 0)
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
                    .padding(top = 8.dp, bottom = 8.dp, start = 50.dp, end = 30.dp)) {
                    Text(text = "Produce Name",modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                        .padding(8.dp),
                        fontSize =  19.sp)
                    Text(text = "Quantity",modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                        .padding(8.dp),
                        fontSize =  19.sp)
                    Text(text = "Carbon Footprint",modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                        .padding(8.dp),
                        fontSize =  19.sp)

                }
                Surface(modifier = Modifier.padding(all = Dp(5f))) {
                    LazyColumn {
                        itemsIndexed(ingrList) { _, item ->
                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .padding(all = 8.dp)) {
                                Surface(
                                    shape = RoundedCornerShape(8.dp),
                                    elevation = 4.dp,
                                    modifier = Modifier.clickable(onClick = {
                                        navController.navigate(route = Screen.IngredientInfo.passID(Model.IngList.indexOf(item)))
                                    }),
                                    color = Color(red = getColor(item.carbonFootprint)[0],
                                        green = getColor(item.carbonFootprint)[1],
                                        blue = getColor(item.carbonFootprint)[2],)
                                ) {
                                    Row(modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(all = 8.dp)) {
                                        val checkedStatus = remember {
                                            mutableStateOf(false)
                                        }
                                        Checkbox(
                                            checked = checkedStatus.value,
                                            onCheckedChange = { checkedStatus.value = it
                                            },
                                            modifier = Modifier.padding(1.dp)
                                        )
                                        Text(
                                            text = item.productName,
                                            modifier = Modifier
                                                .weight(1f)
                                                .align(Alignment.CenterVertically)
                                                .padding(8.dp),
                                            fontSize =  19.sp
                                        )
                                        Text(
                                            text = item.productQuantity.toString(),
                                            modifier = Modifier
                                                .weight(1f)
                                                .align(Alignment.CenterVertically)
                                                .padding(8.dp),
                                            fontSize =  19.sp
                                        )
                                        Text(
                                            text = item.carbonFootprint.toString(),
                                            modifier = Modifier
                                                .weight(1f)
                                                .align(Alignment.CenterVertically)
                                                .padding(8.dp),
                                            fontSize =  19.sp
                                        )
                                        Column(horizontalAlignment = Alignment.End) {
                                            IconButton(onClick = {
                                                ingrList.remove(item)
                                                Model.IngList = ingrList}) {
                                                Icon(
                                                    ImageVector.vectorResource(R.drawable.ic_delete_forever_black_24dp),
                                                    ""
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
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {navController.navigate(route = Screen.AddIngredient.route)},
                backgroundColor = MaterialTheme.colors.primaryVariant,
                contentColor = contentColorFor(MaterialTheme.colors.onSecondary),
                content = { Icon(ImageVector.vectorResource(R.drawable.plus), "") }
            )

        }
    )
}

fun getColor(footprint:Long): List<Int>{
    val color1 = listOf(230, 0, 0)
    val color2 = listOf(0, 230, 0)
    val color3 = listOf(255,255,0)
    val w = footprint/1000.toDouble()
    if (footprint > 1000){
        return color1
    }
    else if (footprint in 200..500){
        return mix(w,color3,color2)
    }
    else if (footprint in 500..800){
        return mix(w,color1,color3)
    }
    else {
        return mix(w,color1,color2)
    }
}

fun mix(w: Double,color1:List<Int>,color2:List<Int>):List<Int>{
    var w1 = w
    var w2 = 1 - w1
    var rgb = listOf(
        round((color1[0] * w1 + color2[0] * w2).toDouble()).toInt(),
        round((color1[1] * w1 + color2[1] * w2).toDouble()).toInt(),
        round((color1[2] * w1 + color2[2] * w2).toDouble()).toInt()
    )
    return rgb
}


@Composable
@Preview(showBackground = true)
fun IngListPreview(){
    ProductListCurrentScreen(navController = rememberNavController())
}
