package com.pobezhkin.starwars.presentation.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pobezhkin.starwars.domain.model.StarHeroes

@Composable
fun StarCard(starHeroes: StarHeroes, onClick : (String) -> Unit = {}) {
    Card(
        onClick =   {
            val id = starHeroes.url.split("/").dropLast(1).last()
            onClick(id)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.9f)
        ),
        border = BorderStroke(1.dp, Color.White.copy(alpha = 0.6f)),
        shape = RoundedCornerShape(16.dp)
        ,

                content = {
            Column {

                Text(
                    text = starHeroes.name,
                    modifier = Modifier.padding(10.dp),
                    style = MaterialTheme.typography.headlineLarge
                )
                Row {
                    Text("Рост: ${starHeroes.height}", modifier = Modifier.padding(5.dp))
                    Text("Вес: ${starHeroes.mass}", modifier = Modifier.padding(5.dp))
                    Text(
                        text = "Глаза: ${starHeroes.eyeColor}",
                        modifier = Modifier.padding(5.dp),
                    )
                    Text(
                        text = "Волосы: ${starHeroes.hairColor}",
                        modifier = Modifier.padding(5.dp),
                    )
                }
            }

        }
    )
}

@Preview(showBackground = true)
@Composable
fun StarCardPreview() {
    StarCard(
        starHeroes = StarHeroes(
            name = "Luke Skywalker",
            height = "172",
            mass = "77",
            hairColor = "blond",
            skinColor = "fair",
            eyeColor = "blue",
            birthYear = "19BBY",
            gender = "male",
            homeworld = "",
            films = emptyList(),
            species = emptyList(),
            vehicles = emptyList(),
            url = ""
        )
    )
}