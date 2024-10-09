package com.github.igorkoppen.pokedexapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.igorkoppen.pokedexapp.data.api.PokemonRepository
import com.github.igorkoppen.pokedexapp.data.api.RetrofitClient
import com.github.igorkoppen.pokedexapp.domain.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    private val repository = PokemonRepository(RetrofitClient.pokemonApi)
    val pokemonResponse = MutableLiveData<Pokemon>()
    fun fetchPokemon(id: Int) {
        viewModelScope.launch {
            val pokemon = repository.getPokemonData(id)
            withContext(Dispatchers.Main) {
                pokemonResponse.value = pokemon
            }
        }
    }
}