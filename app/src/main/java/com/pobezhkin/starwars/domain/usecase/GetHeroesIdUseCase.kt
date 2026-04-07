package com.pobezhkin.starwars.domain.usecase

import com.pobezhkin.starwars.domain.model.StarHeroes
import com.pobezhkin.starwars.domain.repository.StarHeroesRepository
import com.pobezhkin.starwars.domain.util.Result
import javax.inject.Inject

class GetHeroesIdUseCase  @Inject constructor(
    private val starHeroesRepository: StarHeroesRepository,
){
    suspend operator fun invoke(id : String): Result<StarHeroes> {
        return starHeroesRepository.getByIdHeroes(id)
    }
}