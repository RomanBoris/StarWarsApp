package com.pobezhkin.starwars.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pobezhkin.starwars.domain.usecase.GetStarHeroesUseCase
import com.pobezhkin.starwars.domain.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StarHomeViewModel @Inject constructor(
    private val getStarHeroesUseCase: GetStarHeroesUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow<StarHomeUiState>(StarHomeUiState.Loading)
    val state: StateFlow<StarHomeUiState> = _state.asStateFlow()

    init {

        loadHeroesList()
    }

    private fun loadHeroesList(){

        viewModelScope.launch {
            when(val result = getStarHeroesUseCase()){
                is Result.Error -> _state.value = StarHomeUiState.Error(result.message)
                is Result.Success -> _state.value = StarHomeUiState.Success(result.data)
            }
        }

    }

}