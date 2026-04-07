package com.pobezhkin.starwars.data.repository


import com.pobezhkin.starwars.data.mapper.toStarHeroes
import com.pobezhkin.starwars.data.remote.StarApiService
import com.pobezhkin.starwars.domain.model.StarHeroes
import com.pobezhkin.starwars.domain.repository.StarHeroesRepository
import com.pobezhkin.starwars.domain.util.Result
import java.io.IOException
import javax.inject.Inject
import retrofit2.HttpException
class StarHeroesRepositoryImpl @Inject constructor(
    private val starApiService: StarApiService,
) : StarHeroesRepository {

    override suspend fun getAllHeroes(): Result<List<StarHeroes>> {
        return try {
            val starResponce = starApiService.getTopHeroes(
                page = 1
            ).resultsHeroes.map { it.toStarHeroes() }
            Result.Success(starResponce)
        } catch (e: IOException) {
            Result.Error("Нет подключения к интернету")
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
            Result.Error("Нет подключения к интернету")
        } catch (e: HttpException) {
            Result.Error("Ошибка сервера: ${e.code()}")
        } catch (e: Exception) {
            Result.Error("Неизвестная ошибка")
        }
    }


}
