package com.pobezhkin.starwars.data.local.entity


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "starHero")
data class StarHeroEntity (
    @PrimaryKey
    val url: String,
    val name: String,
    val height: String,
    val mass: String,
    val hairColor: String,
    val skinColor: String,
    val eyeColor: String,
    val homeworld: String,
    val birthYear: String,
    val gender: String,

)