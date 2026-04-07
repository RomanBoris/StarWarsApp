package com.pobezhkin.starwars.presentation.detailsScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pobezhkin.starwars.domain.usecase.GetHeroesIdUseCase
import com.pobezhkin.starwars.domain.util.Result
import com.pobezhkin.starwars.presentation.home.StarHomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
private val getHeroesIdUseCase: GetHeroesIdUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = MutableStateFlow<DetailsUiState>(DetailsUiState.Loading)
    val state: StateFlow<DetailsUiState> = _state.asStateFlow()
    private val heroId : String = savedStateHandle["heroName"] ?: ""

    init {

        loadHeroById()

    }

    private fun loadHeroById(){

        viewModelScope.launch {
            when(val resultById = getHeroesIdUseCase(heroId)){
                is Result.Error -> _state.value = DetailsUiState.Error(resultById.message)
                is Result.Success -> _state.value = DetailsUiState.Success(resultById.data)
            }
        }

    }

}

