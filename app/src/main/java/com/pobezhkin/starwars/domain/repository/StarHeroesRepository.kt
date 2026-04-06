package com.pobezhkin.starwars.domain.repository

import com.pobezhkin.starwars.domain.model.StarHeroes
import com.pobezhkin.starwars.domain.util.Result

interface StarHeroesRepository {
    suspend fun getAllHeroes(): Result<List<StarHeroes>>
}