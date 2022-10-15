package com.example.dost.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.dost.R


@Composable
fun DogInfoCard(name: String, gender: String, location: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Column(modifier = Modifier.align(Alignment.CenterVertically)) {
            Text(
                text = name,
                modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
                color = MaterialTheme.colors.surface,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(4.dp))

            Row(verticalAlignment = Alignment.Bottom) {

                val locationIcon: Painter = painterResource(id = R.drawable.ic_baseline_location_on_24)

                Icon(
                    painter = locationIcon,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp, 16.dp),
                    tint = Color.Red
                )

                Text(
                    text = location,
                    modifier = Modifier.padding(1.dp, 2.dp, 2.dp, 0.dp),
                    color = MaterialTheme.colors.surface,
                    style = MaterialTheme.typography.caption
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            Gender(gender)
        }
    }
}
@Composable
fun Gender(name: String) {
    val color = if (name == "Male") Color(0xffFF0000) else Color(0xff0500FF)
    CV(gender = name, colorResource = color)
}
@Composable
fun CV(gender: String, colorResource: Color) {
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