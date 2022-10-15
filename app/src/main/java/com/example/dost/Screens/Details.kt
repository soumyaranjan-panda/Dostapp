package com.example.dost.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.dost.Components.DogInfoCard
import com.example.dost.Components.InfoCard
import com.example.dost.Components.OwnerCard
import com.example.dost.Data.DataSource
import com.example.dost.viewModels.HomeViewModel


@Composable
fun DetailsView(viewModel:HomeViewModel,navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.onPrimary)
    ) {
        val dog = DataSource.dogList[viewModel.dogId.value]

        item {
            dog.apply {

                val dogImage: Painter = painterResource(id = dog.image)
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(360.dp),
                    painter = dogImage,
                    alignment = Alignment.CenterStart,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
                DogInfoCard(name, gender, location)
            }
        }

        item {
            dog.apply {

                Spacer(modifier = Modifier.height(5.dp))
                Title(title = "My Story")
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = about,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 0.dp, 16.dp, 0.dp),
                    color = Color.Black,
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Start
                )
            }
        }

        item {
            dog.apply {

                Spacer(modifier = Modifier.height(24.dp))
                Title(title = "Dog info")
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 0.dp, 16.dp, 0.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    InfoCard(title = "Age", value = dog.age.toString().plus(" yrs"))
                    InfoCard(title = "Color", value = color)
                    InfoCard(title = "Weight", value = weight.toString().plus("Kg"))
                }
            }
        }

        item {
            dog.apply {

                Spacer(modifier = Modifier.height(24.dp))
                Title(title = "Owner info")
                Spacer(modifier = Modifier.height(16.dp))
                owner.apply {
                    OwnerCard(name, bio, image)
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(36.dp))
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
                    .padding(16.dp, 0.dp, 16.dp, 0.dp)
                    .clip(RoundedCornerShape(30)),
                colors = ButtonDefaults.textButtonColors(
                    backgroundColor = MaterialTheme.colors.background,
                    contentColor = Color.White
                )
            ) {
                Text("Adopt me")
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun Title(title: String) {
    Text(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp, 0.dp, 0.dp),
        color = Color.Black,
        style = MaterialTheme.typography.subtitle1,
        fontWeight = FontWeight.W600,
        textAlign = TextAlign.Start
    )
}