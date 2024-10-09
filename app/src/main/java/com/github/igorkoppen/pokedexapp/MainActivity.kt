package com.github.igorkoppen.pokedexapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.github.igorkoppen.pokedexapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainAdapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainAdapter = MainAdapter()
        binding.rvSprites.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL, false
        )
        binding.rvSprites.adapter = mainAdapter
        viewModel.pokemonResponse.observe(this) { pokemon ->
            binding.tvPokemonName.text = "Nome: ${pokemon.name}"
            binding.tvPokemonHeight.text = "Altura: ${pokemon.height}"
            binding.tvPokemonWeight.text = "Peso: ${pokemon.weight}"
            Glide.with(this).load(pokemon.officialArtwork).into(binding.ivOfficialArtWork)
            mainAdapter.submitList(pokemon.imagesURL)
        }

        binding.btnSearch.setOnClickListener {
            val id = binding.etPokemonId.text.toString().toIntOrNull()
            if (id != null) {
                viewModel.fetchPokemon(id)
                binding.tvPokemonId.text = "Numero: ${id}"
            }
        }
    }
}

