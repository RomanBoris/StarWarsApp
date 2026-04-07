package com.pobezhkin.starwars.data.local.entity.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pobezhkin.starwars.data.local.entity.StarHeroEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StarHeroDao {
    @Query("SELECT * FROM starHero")
    fun getAllStarHeroes(): Flow<List<StarHeroEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStarHeroes(heroes: List<StarHeroEntity>)

    @Query("DELETE FROM starHero")
    suspend fun clearHeroes()
}