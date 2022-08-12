package com.example.homescreen

import androidx.compose.foundation.*
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


//class AddIngredient : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            AddIngredientPreview()
//        }
//    }
//}

@Composable
fun AddStuff(navController: NavController) {
    var newIngName by remember { mutableStateOf("")}
    var newIngQuant by remember { mutableStateOf("")}
    var addList = remember{ Addables.addableList.toMutableStateList<Addable>()}
//    Questions "Which items you want to add?"
    Scaffold(
        topBar = {
            AppBar(
                onSearchClicked = {}
            )
        },
        content = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment =  Alignment.CenterHorizontally
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .height(480.dp)
                ) {
                    itemsIndexed(addList){ _, model ->
                        ListRow(model = model)
                    }
                }
                Box(
                    Modifier
                        .size(400.dp, 220.dp)
                        .padding(top = 5.dp)
                        // on below line we are adding background color
                        .background(MaterialTheme.colors.primaryVariant, RoundedCornerShape(10.dp))
                        // on below line we are adding border.
                        .border(1.dp, color = Color.LightGray, RoundedCornerShape(10.dp))
                ){
                    Column(verticalArrangement = Arrangement.SpaceEvenly){
                        Text(
                            text = "Add Custom Ingredient",
                            modifier = Modifier.padding(start = 10.dp,top = 10.dp),
                            color = Color.White,
                            fontSize = 20.sp
                        )
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp, vertical = 10.dp),
                            value = newIngName,
                            onValueChange = {newIngName = it},
                            label = { Text(text = "Produce Name") },
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.White
                            ),
                            trailingIcon = {
                                IconButton(onClick = {newIngName = ""}) {
                                    Icon(imageVector = Icons.Filled.Clear, contentDescription = "")
                                }
                            }
                        )
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp, vertical = 10.dp),
                            value = newIngQuant,
                            onValueChange = {newIngQuant = it},
                            label = { Text(text = "Quantity (g)") },
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.White
                            ),
                            trailingIcon = {
                                IconButton(onClick = {newIngQuant = ""}) {
                                    Icon(imageVector = Icons.Filled.Clear, contentDescription = "")
                                }
                            }
                        )
                    }
                }
                Button(
                    onClick = {editIngList(newIngName,newIngQuant)
                        newIngName = ""
                        newIngQuant = ""},
                    shape = CutCornerShape(10),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant))
                {
                    Text(text = "Add Items to Shopping List",color = Color.White) }
            }

        }

    )

    }


fun editIngList(newIngName: String,newIngQuant: String){
    val newQuant = newIngQuant.toLong()
    val carbonFootprint: Long = getCarbonFootprint(newIngName,newQuant)
    val newIng = Ingredient(newIngName,newQuant,carbonFootprint)
    Model.IngList = Model.IngList + listOf(newIng)
}

fun getCarbonFootprint(newIngName: String, newQuant: Long): Long{
    return 10.toLong()
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
@Composable
fun ListRow(model: Addable) {
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
        Image(
            painter = painterResource(id = model.drawableID),
            contentDescription = "",
            modifier = Modifier
                .size(120.dp)
                .padding(10.dp)
        )
        Text(
            text = model.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )
    }
}


@Preview(showBackground = true)
@Composable
fun AddIngredientPreview(){
    AddStuff(navController = rememberNavController())
}