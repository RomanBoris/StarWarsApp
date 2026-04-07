package com.pobezhkin.starwars.presentation.detailsScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun StarDetailsScreen(
    modifier: Modifier = Modifier,

    viewModel: DetailsViewModel = hiltViewModel()
){
    val state by viewModel.state.collectAsState()
    val _state = state


    when (_state) {
        is DetailsUiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is DetailsUiState.Error -> {
            Text(_state.message)
        }
        is DetailsUiState.Success -> {
            val hero = _state.starHeroes
            Column(modifier = modifier.padding(16.dp)) {
                Text("Имя: ${hero.name}")
                Text("Рост: ${hero.height}")
                Text("Вес: ${hero.mass}")
                Text("Пол: ${hero.gender}")
                Text("Год рождения: ${hero.birthYear}")
                Text("Цвет глаз: ${hero.eyeColor}")
                Text("Цвет волос: ${hero.hairColor}")
            }
        }
    }
}


