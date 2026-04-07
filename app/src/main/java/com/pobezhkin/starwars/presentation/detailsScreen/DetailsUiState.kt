package com.pobezhkin.starwars.presentation.detailsScreen

import com.pobezhkin.starwars.domain.model.StarHeroes

sealed class DetailsUiState {
    object Loading : DetailsUiState()
    data class Success(val starHeroes : StarHeroes ) : DetailsUiState()
    data class Error(val message: String ): DetailsUiState()
}