package com.agus18104002.pertemuan3.ui.pokemonlist

import com.agus18104002.pertemuan3.models.PokemonCard


data class PokemonListViewState (
    val loading: Boolean = false,
    val error: Exception? = null,
    val data: MutableList<PokemonCard>? = null
)