package com.pobezhkin.starwars.data.remote.dto

data class StarHeroesResponseDto(
    val count: Int?,
    val next: String?,
    val previous: String?,
    val results: List<StarHeroesDto>
)
