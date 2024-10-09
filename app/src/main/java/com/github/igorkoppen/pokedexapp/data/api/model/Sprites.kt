package com.github.igorkoppen.pokedexapp.data.api.model

import com.google.gson.annotations.SerializedName

data class Sprites(
 @SerializedName("other") val other: Other,
 @SerializedName("front_default")   val frontDefault: String?,
 @SerializedName("back_default") val backDefault: String?,
 @SerializedName("front_shiny")  val frontShiny: String?,
 @SerializedName("back_shiny") val backShiny: String?
)
data class Other( @SerializedName("official-artwork") val officialArtwork: OfficialArtwork)

data class OfficialArtwork(
 @SerializedName("front_default") val frontDefault: String,
 @SerializedName("front_shiny") val  frontShiny: String?
)
