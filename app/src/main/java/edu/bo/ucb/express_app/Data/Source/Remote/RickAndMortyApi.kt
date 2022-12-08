package edu.bo.ucb.express_app.Data.Source.Remote

import edu.bo.ucb.express_app.Data.Source.Remote.Dto.CharacterDto
import edu.bo.ucb.express_app.Data.Source.Remote.Dto.CharactersDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApi {

    @GET("character/")
    suspend fun getCharacters(
        @Query("page") page: Int
    ): CharactersDto

    @GET("character/{id}")
    suspend fun getCharacter(
        @Path("id") id: Int
    ): CharacterDto
}