package com.pobezhkin.starwars.presentation.home

import com.pobezhkin.starwars.domain.model.StarHeroes

sealed class StarHomeUiState {
    object Loading : StarHomeUiState()
    data class Success(val starHeroes: List<StarHeroes> ) : StarHomeUiState()
    data class Error(val message: String ): StarHomeUiState()
}