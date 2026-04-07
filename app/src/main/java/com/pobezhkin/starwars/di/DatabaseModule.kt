package com.pobezhkin.starwars.di

import android.content.Context
import androidx.room.Room
import com.pobezhkin.starwars.data.local.entity.StarWarsDatabase
import com.pobezhkin.starwars.data.local.entity.dao.StarHeroDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): StarWarsDatabase {
        return Room.databaseBuilder(
            context,
            StarWarsDatabase::class.java,
            "starwars.db"
        ).build()
    }

    @Provides
    fun provideStarHeroDao(database: StarWarsDatabase): StarHeroDao {
        return database.starHeroDao()
    }
}