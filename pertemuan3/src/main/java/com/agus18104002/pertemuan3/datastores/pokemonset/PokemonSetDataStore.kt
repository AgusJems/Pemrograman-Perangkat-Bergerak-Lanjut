package com.agus18104002.pertemuan3.datastores.pokemonset

import com.agus18104002.pertemuan3.models.PokemonSet

interface PokemonSetDataStore {
    suspend fun getSets(): MutableList<PokemonSet>?
    suspend fun addAll(sets: MutableList<PokemonSet>?)
}