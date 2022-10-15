package com.example.dost.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.dost.AdsCard
import com.example.dost.ChipView2
import com.example.dost.Data.DataSource.dogList
import com.example.dost.ImageCard
import com.example.dost.Objects.Dog
import com.example.dost.R
import com.example.dost.viewModels.HomeViewModel
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(viewModel: HomeViewModel,navController: NavController){
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val listState = rememberLazyListState()

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = { Text(stringResource(id = R.string.drawer), color = Color.Black) },
        topBar = {
            TopAppBar(
                elevation = 0.dp,
                backgroundColor = MaterialTheme.colors.surface
            ) {
                IconButton(
                    onClick = {
                        coroutineScope.launch { scaffoldState.drawerState.open() }
                    }
                ) {
                    Icon(Icons.Filled.Menu, contentDescription = null, tint = MaterialTheme.colors.onSecondary)
                }
            }
        },
        bottomBar = {
            BottomAppBar(
                cutoutShape = CircleShape,
                elevation = 5.dp,
                backgroundColor = MaterialTheme.colors.onPrimary
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Icon(Icons.Filled.Home, contentDescription = null)
                    Icon(Icons.Filled.Person, contentDescription = null)
                    Spacer(modifier = Modifier.width(70.dp))
                    Icon(Icons.Filled.ShoppingCart, contentDescription = null)
                    Icon(Icons.Filled.Settings, contentDescription = null)
                }
            }
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                backgroundColor = MaterialTheme.colors.onSecondary,
                text = {
                    Icon(Icons.Default.Add, contentDescription = null)
                },
                onClick = {}
            )
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        content = { innerPadding ->
            //....
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.surface)
            ){
                Column {
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = stringResource(id = R.string.PA),
                        modifier = Modifier.padding(start = 15.dp, end = 15.dp),
                        fontSize = 30.sp,
                        color = MaterialTheme.colors.onSecondary,
                        fontWeight = FontWeight.Bold)
                    Text(text = stringResource(id = R.string.FILP),
                        modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 5.dp),
                        fontSize = 15.sp,
                        color = MaterialTheme.colors.onPrimary,
                        fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(5.dp))
                    var textState by remember { mutableStateOf("") }
                    val maxLength = 110
                    val lightBlue = Color(0xffD9D9D9)
                    Column {
                        TextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            value = textState,
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.White,
                                cursorColor = Color.Black.copy(0.2f),
                                disabledLabelColor = lightBlue,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                textColor = Color.Black
                            ),
                            placeholder = {
                                Text(text = stringResource(id = R.string.tapn), color = Color.Black.copy(0.5f))
                            },
                            leadingIcon = {
                                IconButton(
                                    modifier = Modifier
                                        .alpha(ContentAlpha.disabled)
                                        .padding(start = 3.dp),
                                    onClick = {}
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Search,
                                        contentDescription = stringResource(id = R.string.SI),
                                        tint = Color.Black
                                    )
                                }
                            },
                            onValueChange = {
                                if (it.length <= maxLength) textState = it
                            },
                            shape = RoundedCornerShape(30.dp),
                            singleLine = true
                        )
                    }
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Spacer(modifier = Modifier.height(65.dp))
                        Text(text = stringResource(id = R.string.FYP),
                            modifier = Modifier.padding(start = 15.dp, end = 15.dp),
                            fontSize = 25.sp,
                            color = MaterialTheme.colors.onSecondary,
                            fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.weight(1f))
                        ChipView2(gender = stringResource(id = R.string.adopt), colorResource = MaterialTheme.colors.onSecondary)
                        Spacer(modifier = Modifier.width(5.dp))
                        ChipView2(gender = stringResource(id = R.string.donate), colorResource = MaterialTheme.colors.onSurface)
                        Spacer(modifier = Modifier.width(5.dp))
                    }
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        state = listState
                    ) {
                        items(dogList) {
                            dogList.forEach(){
                                ImageCard(
                                    dog = it,
                                    viewModel,navController
                                )
                            }

                        }
                    }
                    AdsCard(painter = painterResource(id = R.drawable.dog1))
                }
            }
        }
    )
}

