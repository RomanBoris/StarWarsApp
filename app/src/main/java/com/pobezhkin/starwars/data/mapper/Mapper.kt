package com.pobezhkin.starwars.data.mapper

import com.pobezhkin.starwars.data.remote.dto.StarHeroesDto
import com.pobezhkin.starwars.domain.model.StarHeroes
import kotlin.String

fun StarHeroesDto.toStarHeroes() = StarHeroes(
    name = name ?: "",
    height = height?: "",
    mass = mass?: "",
    hairColor = hairColor?: "",
    skinColor = skinColor ?: "",
    eyeColor = eyeColor?: "",
    birthYear = birthYear?: "",
     homeworld = homeworld ?: "",
    gender = gender?: "",
    films = films?: emptyList(),
    species = species?: emptyList(),
    vehicles = vehicles ?: emptyList(),
    url = url ?: "",
)