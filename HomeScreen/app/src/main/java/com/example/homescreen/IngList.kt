package com.example.homescreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable

fun IngList(navController: NavController){
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
fun ProductListCurrentScreen(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavController
) {
    val ing1 = Ingredient("hi",1,1)
    val ing2 = Ingredient("hi",1,1)


    var ingrList = remember{ Model.IngList.toMutableStateList<Ingredient>()}

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name)) },
                backgroundColor = MaterialTheme.colors.primary,
                navigationIcon = {
                    IconButton(onClick = {navController.navigate(route = Screen.Home.route)}) {
                        Icon(ImageVector.vectorResource(R.drawable.arrow), "")
                    }
                }
            )
        },
        content = {
//            ScreenBody()

            Column {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp, start = 8.dp, end = 30.dp)) {
                    Text(text = "Produce Name",modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                        .padding(8.dp))
                    Text(text = "Quantity",modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                        .padding(8.dp))
                    Text(text = "Carbon Footprint",modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                        .padding(8.dp))

                }
                Surface(modifier = Modifier.padding(all = Dp(5f))) {
                    LazyColumn {

                        itemsIndexed(ingrList) { index, item ->

                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .padding(all = 8.dp)) {
                                Surface(
                                    shape = RoundedCornerShape(8.dp),
                                    elevation = 4.dp,
                                    modifier = Modifier.clickable(onClick = {

                                    })
                                ) {
                                    Row(modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(all = 8.dp)) {
                                        Text(
                                            text = item.productName,
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
//            CreateProductDialog()
        },
        floatingActionButton = { Fab() }
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
    FloatingActionButton(
        onClick = {},
        backgroundColor = MaterialTheme.colors.secondary,
        contentColor = contentColorFor(MaterialTheme.colors.onSecondary),
        content = { Icon(ImageVector.vectorResource(R.drawable.plus), "") }
    )
}
//
//@Composable
//fun getIngredient(){
//    var msg = remember { mutableStateOf("Hello") }
//    AlertDialog(
//        onDismissRequest = {},
//        title = {
//            Text(
//                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp),
//                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
//                text = "hello"
//            )
//        },
//        buttons = {  }
//    )
//}


@Composable
@Preview(showBackground = true)
fun IngListPreview(){
    IngList(navController = rememberNavController())
    ProductListCurrentScreen(navController = rememberNavController())
}
