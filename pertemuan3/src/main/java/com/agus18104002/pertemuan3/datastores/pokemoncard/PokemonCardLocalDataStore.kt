package com.agus18104002.pertemuan3.datastores.pokemoncard

import com.agus18104002.pertemuan3.models.PokemonCard

class PokemonCardLocalDataStore : PokemonCardDataStore {
    private val caches = mutableMapOf<String, MutableList<PokemonCard>?>()

    override suspend fun getPokemons(set: String): MutableList<PokemonCard>? =
        if (caches.contains(set)) caches[set] else null

    override suspend fun addAll(set: String, pokemons: MutableList<PokemonCard>?) {
        caches[set] = pokemons
    }
}