package com.pobezhkin.starwars.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.pobezhkin.starwars.R
import com.pobezhkin.starwars.presentation.home.components.StarCard

@Composable
fun StarHomeScreen(
    modifier: Modifier = Modifier,
    viewModel: StarHomeViewModel = hiltViewModel(),
    onHeroesClick: (String) -> Unit
){
    val searchQuery by viewModel.searchQuery.collectAsState()
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
                Column() {
                    OutlinedTextField(
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            focusedBorderColor = Color(0xFF4DD9FF),
                            unfocusedBorderColor = Color.White.copy(alpha = 0.5f),
                            cursorColor = Color(0xFF4DD9FF)
                        ),
                        value = searchQuery,
                        onValueChange = { viewModel.onSearchQueryChange(it) },
                        placeholder = { Text(color = Color(0xFFFFFFFF), text = "Поиск персонажа...") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )

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



}