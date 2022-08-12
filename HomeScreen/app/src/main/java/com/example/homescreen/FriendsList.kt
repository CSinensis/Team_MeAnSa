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
                                        Text(
                                            text = item.name,
                                            modifier = Modifier
                                                .weight(1f)
                                                .align(Alignment.CenterVertically)
                                                .padding(8.dp)
                                        )
                                        Text(
                                            text = item.productQuantity.toString(),
                                            modifier = Modifier
                                                .weight(1f)
                                                .align(Alignment.CenterVertically)
                                                .padding(8.dp)
                                        )
                                        Text(
                                            text = item.carbonFootprint.toString(),
                                            modifier = Modifier
                                                .weight(1f)
                                                .align(Alignment.CenterVertically)
                                                .padding(8.dp)
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
                backgroundColor = MaterialTheme.colors.secondary,
                contentColor = contentColorFor(MaterialTheme.colors.onSecondary),
                content = { Icon(ImageVector.vectorResource(R.drawable.plus), "") }
            )

        }
    )
}

//@Composable
//private fun ScreenBody() {
//    when (val result = AmbientScreenState.current.productListUi) {
//        is ResultStatus.Loading -> LoadingScreen()
//        is ResultStatus.Success -> SuccessScreen(result.data)
//        is ResultStatus.Error -> ErrorScreen()
//    }
//}

//@Composable
//private fun LoadingScreen() {
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) { CircularProgressIndicator() }
//}

//@Composable
//private fun SuccessScreen(productList: List<Ingredient>?) {
//
//    Column(
//        Modifier
//            .fillMaxWidth()
//            .padding(8.dp, 8.dp, 8.dp, 96.dp)
//            .verticalScroll(rememberScrollState())
//    ) {
//        productList?.forEach { post -> ProductCurrentItem(post) }
//    }
//}


//@Composable
//private fun ErrorScreen() {
//    EmptyScreen(
//        R.string.empty_view_product_list_title,
//        R.string.empty_view_product_list_subtitle_text
//    )
//}

@Composable
private fun Fab() {
    val openDialog = remember{mutableStateOf(true) }
    FloatingActionButton(
        onClick = {},
        backgroundColor = MaterialTheme.colors.secondary,
        contentColor = contentColorFor(MaterialTheme.colors.onSecondary),
        content = { Icon(ImageVector.vectorResource(R.drawable.plus), "") }
    )
}


// on below line we are creating a pop up window dialog method
@Composable
fun PopupWindowDialog() {
    val openDialog = remember{mutableStateOf(false) }
    val buttonTitle = remember{mutableStateOf("Show Pop Up")}
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            onClick = {
                openDialog.value = !openDialog.value
                if (!openDialog.value) {
                    buttonTitle.value = "Show Pop Up"
                }
            }
        ) {
            Text(text = buttonTitle.value, modifier = Modifier.padding(3.dp))
        }
        Box {
            val popupWidth = 300.dp
            val popupHeight = 100.dp
            if (openDialog.value) {
                buttonTitle.value = "Hide Pop Up"
                // on below line we are adding pop up
                Popup(
                    // on below line we are adding
                    // alignment and properties.
                    alignment = Alignment.TopCenter,
                    properties = PopupProperties()
                ) {

                    // on the below line we are creating a box.
                    Box(
                        // adding modifier to it.
                        Modifier
                            .size(popupWidth, popupHeight)
                            .padding(top = 5.dp)
                            // on below line we are adding background color
                            .background(
                                MaterialTheme.colors.primaryVariant,
                                RoundedCornerShape(10.dp)
                            )
                            // on below line we are adding border.
                            .border(1.dp, color = Color.Black, RoundedCornerShape(10.dp))
                    ) {

                        // on below line we are adding column
                        Column(
                            // on below line we are adding modifier to it.
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 20.dp),
                            // on below line we are adding horizontal and vertical
                            // arrangement to it.
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            // on below line we are adding text for our pop up
                            Text(
                                text = "Welcome to Geeks for Geeks",
                                color = Color.White,
                                // on below line we are adding padding to it
                                modifier = Modifier.padding(vertical = 5.dp),
                                // on below line we are adding font size.
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun IngListPreview(){
    IngList(navController = rememberNavController())
    ProductListCurrentScreen(navController = rememberNavController())
}
