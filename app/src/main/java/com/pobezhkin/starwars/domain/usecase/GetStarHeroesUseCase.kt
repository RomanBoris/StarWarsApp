package com.pobezhkin.starwars.domain.usecase

import com.pobezhkin.starwars.domain.model.StarHeroes
import com.pobezhkin.starwars.domain.repository.StarHeroesRepository
import javax.inject.Inject
import com.pobezhkin.starwars.domain.util.Result

class GetStarHeroesUseCase @Inject constructor(
    private val starHeroesRepository: StarHeroesRepository,
) {
    suspend operator fun invoke(): Result<List<StarHeroes>>{
        return starHeroesRepository.getAllHeroes()
    }
}