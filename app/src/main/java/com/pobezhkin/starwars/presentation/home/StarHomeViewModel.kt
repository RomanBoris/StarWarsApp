package com.pobezhkin.starwars.presentation.home

import androidx.lifecycle.ViewModel
import com.pobezhkin.starwars.domain.usecase.GetStarHeroesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class StarHomeViewModel @Inject constructor(
    private val getStarHeroesUseCase: GetStarHeroesUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow<StarHomeUiState>(StarHomeUiState.Loading)
    val state: StateFlow<StarHomeUiState> = _state.asStateFlow()

    init {


    }



}