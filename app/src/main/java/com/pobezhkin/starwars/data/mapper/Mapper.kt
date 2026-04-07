package com.pobezhkin.starwars.data.mapper

import com.pobezhkin.starwars.data.local.entity.StarHeroEntity
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

fun StarHeroes.toEntity() = StarHeroEntity(
    url = url,
    name = name,
    height = height,
    mass = mass,
    hairColor = hairColor,
    skinColor = skinColor,
    eyeColor = eyeColor,
    homeworld = homeworld,
    birthYear = birthYear,
    gender = gender
)

fun StarHeroEntity.toStarHeroes() = StarHeroes(
    url = url,
    name = name,
    height = height,
    mass = mass,
    hairColor = hairColor,
    skinColor = skinColor,
    eyeColor = eyeColor,
    homeworld = homeworld,
    birthYear = birthYear,
    gender = gender,
    films = emptyList(),
    species = emptyList(),
    vehicles = emptyList()
)