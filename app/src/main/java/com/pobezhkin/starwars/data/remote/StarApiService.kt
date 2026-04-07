package com.pobezhkin.starwars.data.remote

import com.pobezhkin.starwars.data.remote.dto.StarHeroesDto
import com.pobezhkin.starwars.data.remote.dto.StarHeroesResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StarApiService {
    @GET("api/people/")
    suspend fun getTopHeroes(
        @Query("page") page : Int
    ): StarHeroesResponseDto

    @GET("api/people/{heroId}/")
    suspend fun getHeroById(
        @Path("heroId") heroId: String
    ): StarHeroesDto
}