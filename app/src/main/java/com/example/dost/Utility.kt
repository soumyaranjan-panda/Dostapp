package com.example.dost

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*


import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.dost.Objects.Dog
import com.example.dost.viewModels.HomeViewModel

//onClick = (navController.navigate(route = "details/${dog.id}"))
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ImageCard(dog: Dog, viewModel: HomeViewModel, navController: NavController){

    Box(modifier = Modifier
        .height(250.dp)
        .width(162.dp)
        .padding(start = 15.dp, end = 0.dp, top = 10.dp, bottom = 10.dp)
    ){
        Card(
            modifier = Modifier.fillMaxWidth().clickable {

            },
            shape = RoundedCornerShape(15.dp),
            elevation = 5.dp, onClick = {
                viewModel.setdogId(dog.id)
                navController.navigate("detail")
            }

        ) {
            Box(modifier = Modifier.height(250.dp)){
                Image(
                    painter = painterResource(id = dog.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 400f
                        )
                    )
                )
                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                    contentAlignment = Alignment.TopEnd
                ){
                    GenderTag(name = dog.gender)
                }
                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                    contentAlignment = Alignment.BottomStart
                ){
                    Column() {
                        Text(text = dog.name, style = TextStyle(color = Color.White), fontSize = 14.sp)
                        Text(text = dog.description, style = TextStyle(color = Color.White), fontSize = 10.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun AdsCard(painter: Painter, modifier: Modifier = Modifier){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(152.dp)
        .padding(12.dp)){
        Card(
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            elevation = 5.dp
        ) {
            Box(modifier = Modifier.height(200.dp)){
                Image(
                    painter = painter,
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Black.copy(0.5f),
                                MaterialTheme.colors.surface.copy(0.8f),
                            ),
                            startY = 5f
                        )
                    )
                )
            }
            Column {
                Text(
                    text = "Join today\n and save lives",
                    modifier = Modifier
                        .padding(start = 15.dp, top = 15.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                        onClick = {},
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(contentColor = Color.White,
                    backgroundColor = MaterialTheme.colors.onSecondary),
                modifier = Modifier
                    .padding(start = 15.dp)
                    .width(110.dp)
                    .height(34.dp)
                    .wrapContentSize()
                ) {
                Text(
                    text = "DONATE",
                    fontSize = 17.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                }
            }
        }
    }
}
@Composable
fun GenderTag(name: String) {
    val color = if (name == "Male") Color.Blue else Color.Red
    ChipView(gender = name, colorResource = color)
}
@Composable
fun ChipView(gender: String, colorResource: Color) {
    Box(
        modifier = Modifier
            .wrapContentWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(colorResource.copy(.08f))
    ) {
        Text(
            text = gender, modifier = Modifier.padding(7.dp, 3.5.dp, 7.dp, 3.5.dp),
            style = MaterialTheme.typography.caption,
            color = colorResource
        )
    }
}
@Composable
fun ChipView2(gender: String, colorResource: Color) {
    Box(
        modifier = Modifier
            .width(70.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(colorResource.copy(1f)),

        ) {
        Text(
            text = gender, modifier = Modifier
                .padding(7.dp, 3.5.dp, 7.dp, 3.5.dp)
                .align(alignment = Alignment.Center),

            style = MaterialTheme.typography.caption,
            color = Color.White,
            fontSize = 15.sp
        )
    }
}

//Row(
//modifier = Modifier
//.background(Color(0xFFF1EDE9))
//.clip(RoundedCornerShape(23.dp)),) {
//    Text(
//        text = "Dost",
//        style = MaterialTheme.typography.h4,
//        color = MaterialTheme.colors.background,
//        fontWeight = FontWeight.Bold
//    )
//    Spacer(modifier = Modifier.weight(1f))
//    Icon(painter = painterResource(id = R.drawable.ic_messanger), contentDescription = null)
//
//}
