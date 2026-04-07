package com.pobezhkin.starwars.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.pobezhkin.starwars.R
import com.pobezhkin.starwars.presentation.home.components.StarCard

@Composable
fun StarHomeScreen(
    modifier: Modifier = Modifier,
    viewModel: StarHomeViewModel = hiltViewModel(),
    onHeroesClick: (String) -> Unit
){
    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.screen1),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
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



}