package com.pobezhkin.starwars.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.pobezhkin.starwars.presentation.home.components.StarCard
import androidx.compose.foundation.lazy.items

@Composable
fun StarHomeScreen(
    modifier: Modifier = Modifier,
    viewModel: StarHomeViewModel = hiltViewModel(),
    onHeroesClick: (String) -> Unit
){
    val state by viewModel.state.collectAsState()
    val _state = state

    when (_state) {
        is StarHomeUiState.Error -> {

            Text("${_state.message}")

        }

        StarHomeUiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(modifier = modifier)
            }
        }

        is StarHomeUiState.Success -> {

            LazyColumn(modifier = modifier) {
                items(_state.starHeroes) { starList ->
                    StarCard(
                        starHeroes = starList,
                        onClick = onHeroesClick
                    )
                }
            }

        }
    }



}