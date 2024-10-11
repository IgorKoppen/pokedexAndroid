package com.github.igorkoppen.pokedexapp

import android.graphics.Color
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
    private var hasSearched: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainAdapter = MainAdapter()
        binding.rvSprites.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.HORIZONTAL, false
        )
        binding.rvSprites.adapter = mainAdapter
        binding.ivBackground.setImageDrawable(null)
        binding.ivBackground.setBackgroundColor(Color.BLACK)

        viewModel.pokemonResponse.observe(this) { pokemon ->
            if (hasSearched) {
                binding.tvPokemonName.text = "Nome: ${pokemon.name}"
                binding.tvPokemonHeight.text = "Altura: ${pokemon.height}m"
                binding.tvPokemonWeight.text = "Peso: ${pokemon.weight}Kg"
                Glide.with(this)
                    .load(pokemon.officialArtwork)
                    .into(binding.ivOfficialArtWork)

                mainAdapter.submitList(pokemon.imagesURL)
                binding.ivBackground.setBackgroundResource(R.drawable.background_pokedex)
            }
        }

        binding.btnSearch.setOnClickListener {
            val id = binding.etPokemonId.text.toString().toIntOrNull()
            if (id != null) {
                viewModel.fetchPokemon(id)
                binding.tvPokemonId.text = "#${id}"
                hasSearched = true
            } else {
                hasSearched = false
                binding.ivBackground.setImageDrawable(null)
                binding.ivBackground.setBackgroundColor(Color.BLACK)
            }
        }
    }
}