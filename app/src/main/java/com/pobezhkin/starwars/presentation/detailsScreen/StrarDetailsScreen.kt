package com.pobezhkin.starwars.presentation.detailsScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.pobezhkin.starwars.R
import com.pobezhkin.starwars.presentation.component.GlassCard
import com.pobezhkin.starwars.presentation.component.InfoRow
import com.pobezhkin.starwars.presentation.component.InfoSection

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StarDetailsScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    viewModel: DetailsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val _state = state

    val darkBlue = Color(0xFF0A1628)
    val accentBlue = Color(0xFF4DD9FF)
    val glassWhite = Color.White.copy(alpha = 0.12f)
    val glassBorder = accentBlue.copy(alpha = 0.4f)

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.screen2),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Scaffold(
            containerColor = Color.Transparent,
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Персонаж",
                            color = accentBlue
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onBackClick) {
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Назад",
                                tint = accentBlue
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = darkBlue.copy(alpha = 0.7f)
                    )
                )
            }
        ) { inner ->
            when (_state) {
                is DetailsUiState.Loading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(color = accentBlue)
                    }
                }
                is DetailsUiState.Error -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(_state.message, color = Color.White)
                    }
                }
                is DetailsUiState.Success -> {
                    val hero = _state.starHeroes
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(inner)
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = hero.name,
                            style = MaterialTheme.typography.headlineMedium,
                            color = accentBlue,
                            fontWeight = FontWeight.Bold
                        )
                        GlassCard(borderColor = glassBorder, background = glassWhite) {
                            InfoSection(title = "Информация") {
                                InfoRow("Пол", hero.gender)
                                InfoRow("Год рождения", hero.birthYear)
                                InfoRow("Рост", hero.height)
                                InfoRow("Вес", hero.mass)
                                InfoRow("Цвет глаз", hero.eyeColor)
                                InfoRow("Цвет волос", hero.hairColor)
                            }
                        }

                    }
                }
            }
        }
    }
}



