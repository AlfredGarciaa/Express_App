package edu.bo.ucb.express_app.PokeApi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import edu.bo.ucb.express_app.Models.PokemonRespuesta;

/**
 * Created by Alfred Garcia on 08/12/22.
 * Copyright © 2016 comadreja.hitler. All rights reserved.
 */

public interface PokeApiService {

    @GET("pokemon")
    Call<PokemonRespuesta> obtenerListaPokemon(@Query("limit") int limit, @Query("offset") int offset);
}