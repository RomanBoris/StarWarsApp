package com.pobezhkin.starwars.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pobezhkin.starwars.domain.model.StarHeroes
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
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()
    private var _allHeroes: List<StarHeroes> = emptyList()

    init {
        loadHeroesList()
        viewModelScope.launch {
            _searchQuery.collect { filterHeroes() }
        }
    }
    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
    }

    private fun filterHeroes() {
        val filtered = if (_searchQuery.value.isEmpty()) {
            _allHeroes
        } else {
            _allHeroes.filter {
                it.name.contains(_searchQuery.value, ignoreCase = true)
            }
        }
        _state.value = StarHomeUiState.Success(filtered)
    }

    private fun loadHeroesList(){

        viewModelScope.launch {
            when(val result = getStarHeroesUseCase()){
                is Result.Error -> _state.value = StarHomeUiState.Error(result.message)
                is Result.Success -> {
                    _allHeroes = result.data  // сохраняем полный список
                    filterHeroes()
                }
            }
        }

    }

}