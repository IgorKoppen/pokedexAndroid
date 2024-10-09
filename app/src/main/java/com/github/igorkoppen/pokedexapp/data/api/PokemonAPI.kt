package com.github.igorkoppen.pokedexapp.data.api

import com.github.igorkoppen.pokedexapp.data.api.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonAPI {
    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id") id: Int): PokemonResponse
}