package com.github.igorkoppen.pokedexapp.data.api
import com.github.igorkoppen.pokedexapp.domain.Pokemon


class PokemonRepository(private val api: PokemonAPI) {
    suspend fun getPokemonData(id: Int): Pokemon {
        val response = api.getPokemon(id)
        val sprites = listOfNotNull(
            response.sprites.frontDefault,
            response.sprites.backDefault,
            response.sprites.frontShiny,
            response.sprites.backShiny
        )
        return Pokemon(response.name,response.height,response.weight,sprites, response.sprites.other.officialArtwork.frontDefault)
    }
}