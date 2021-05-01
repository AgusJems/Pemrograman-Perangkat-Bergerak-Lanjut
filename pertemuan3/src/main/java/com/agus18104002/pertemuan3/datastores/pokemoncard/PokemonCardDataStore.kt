package com.agus18104002.pertemuan3.datastores.pokemoncard

import com.agus18104002.pertemuan3.models.PokemonCard

interface PokemonCardDataStore {
    suspend fun getPokemons(set: String): MutableList<PokemonCard>?
    suspend fun addAll(set: String, pokemons: MutableList<PokemonCard>?)
}