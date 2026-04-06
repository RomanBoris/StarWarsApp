package com.pobezhkin.starwars.data.remote

import com.pobezhkin.starwars.data.remote.dto.StarHeroesResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface StarApiService {
    @GET("people/")
    suspend fun getTopHeroes(
        @Query("page") page : Int
    ): StarHeroesResponseDto
}