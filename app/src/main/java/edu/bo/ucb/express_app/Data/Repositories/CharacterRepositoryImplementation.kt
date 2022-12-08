package edu.bo.ucb.express_app.Data.Repositories

import edu.bo.ucb.express_app.Data.Result
import edu.bo.ucb.express_app.Data.Source.Remote.RickAndMortyApi
import edu.bo.ucb.express_app.Data.Source.Remote.Dto.toCharacter
import edu.bo.ucb.express_app.Data.Source.Remote.Dto.toListCharacters
import edu.bo.ucb.express_app.Domain.Model.Character
import edu.bo.ucb.express_app.Domain.Model.Characters
import edu.bo.ucb.express_app.Domain.Repositories.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class CharacterRepositoryImplementation @Inject constructor(
    private val api: RickAndMortyApi
    ): CharacterRepository {

        override fun getCharacters(page: Int): Flow<Result<List<Characters>>> = flow{
            emit(Result.Loading())
            try {
                val response = api.getCharacters(page).toListCharacters()
                emit(Result.Success(response))
            } catch (e: HttpException) {
                emit(Result.Error(
                    message = "Oops, something went wrong",
                    data = null
                ))
            } catch (e: IOException) {
                emit(Result.Error(
                    message = "Couldn't reach server, check your internet connection",
                    data = null
                ))
            }
        }

        override suspend fun getCharacter(id: Int): Result<Character> {
            val response = try {
                api.getCharacter(id)
            } catch (e: Exception) {
                return Result.Error("An unknown error occurred")
            }
            return Result.Success(response.toCharacter())
        }
    }