package com.pobezhkin.starwars.data.repository


import com.pobezhkin.starwars.data.local.entity.dao.StarHeroDao
import com.pobezhkin.starwars.data.mapper.toEntity
import com.pobezhkin.starwars.data.mapper.toStarHeroes
import com.pobezhkin.starwars.data.remote.StarApiService
import com.pobezhkin.starwars.domain.model.StarHeroes
import com.pobezhkin.starwars.domain.repository.StarHeroesRepository
import com.pobezhkin.starwars.domain.util.Result
import kotlinx.coroutines.flow.first
import java.io.IOException
import javax.inject.Inject
import retrofit2.HttpException
class StarHeroesRepositoryImpl @Inject constructor(
    private val starApiService: StarApiService,
    private val starHeroDao: StarHeroDao
) : StarHeroesRepository {

    override suspend fun getAllHeroes(): Result<List<StarHeroes>> {
        return try {
            val starResponce = starApiService.getTopHeroes(
                page = 1
            ).resultsHeroes.map { it.toStarHeroes() }
            starHeroDao.clearHeroes()
            starHeroDao.insertStarHeroes( starResponce.map { it.toEntity() } )
            Result.Success(starResponce)
        } catch (e: IOException) {
            val cashed = starHeroDao.getAllStarHeroes()
                .first()
                .map { it.toStarHeroes() }
            if (cashed.isEmpty()) Result.Error("Нет подключения к интернету")
            else Result.Success(cashed)

        } catch (e: HttpException) {
            Result.Error("Ошибка сервера: ${e.code()}")
        } catch (e: Exception) {
            Result.Error("Неизвестная ошибка")
        }
    }

        override suspend fun getByIdHeroes(id: String): Result<StarHeroes> {
            return  try {
                val starResponceId = starApiService.getHeroById(
                  heroId = id
                ).toStarHeroes()
                Result.Success(starResponceId)
            } catch (e: IOException) {
                val cashed =  starHeroDao.getHeroById(id)?.toStarHeroes()
                if (cashed == null) Result.Error("Нет подключения к интернету")
                else Result.Success(cashed)
            } catch (e: HttpException) {
                Result.Error("Ошибка сервера: ${e.code()}")
            } catch (e: Exception) {
                Result.Error("Неизвестная ошибка")
            }
        }


}
