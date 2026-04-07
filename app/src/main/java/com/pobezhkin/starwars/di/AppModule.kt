package com.pobezhkin.starwars.di

import com.pobezhkin.starwars.data.repository.StarHeroesRepositoryImpl
import com.pobezhkin.starwars.domain.repository.StarHeroesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule{
    @Binds
    abstract fun bindNewRepository(
        impl: StarHeroesRepositoryImpl
    ): StarHeroesRepository

}