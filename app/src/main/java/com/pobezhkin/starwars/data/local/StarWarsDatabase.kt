package com.pobezhkin.starwars.data.local.entity

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pobezhkin.starwars.data.local.entity.dao.StarHeroDao

@Database(entities = [StarHeroEntity::class], version = 1)
abstract class StarWarsDatabase: RoomDatabase() {
    abstract fun starHeroDao(): StarHeroDao
}