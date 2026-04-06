package com.pobezhkin.starwars.data.remote

import com.pobezhkin.starwars.data.remote.dto.StarHeroesResponseDto
import retrofit2.http.GET

interface StarApiService {
    @GET("people/")
    suspend fun getTopHeroes(

    ): StarHeroesResponseDto
}