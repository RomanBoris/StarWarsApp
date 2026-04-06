package com.pobezhkin.starwars.domain.model

data class StarHeroes(

    val name: String,
    val height: String,
    val mass: String,
    val hairColor: String,
    val skinColor: String,
    val eyeColor: String,
   val homeworld: String,
    val birthYear: String,
    val gender: String,
    val films: List<String>,
    val species: List<String>,
    val vehicles: List<String>,
    val url: String

)
