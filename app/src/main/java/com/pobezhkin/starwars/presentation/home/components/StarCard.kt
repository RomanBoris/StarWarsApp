package com.pobezhkin.starwars.presentation.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pobezhkin.starwars.domain.model.StarHeroes

@Composable
fun StarCard(starHeroes: StarHeroes){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),

        content = {
            Column {

                Text(
                    text = starHeroes.name,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.headlineLarge
                )
                if (starHeroes.gender != null) {
                    Text(starHeroes.gender, modifier = Modifier.padding(16.dp))
                }

                if (starHeroes.gender != null) {
                    Text(starHeroes.mass, modifier = Modifier.padding(16.dp))
                }

                Text(
                    starHeroes.eyeColor,
                    modifier = Modifier.padding(16.dp),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style =MaterialTheme.typography.labelSmall
                )
            }

        }
    )
}