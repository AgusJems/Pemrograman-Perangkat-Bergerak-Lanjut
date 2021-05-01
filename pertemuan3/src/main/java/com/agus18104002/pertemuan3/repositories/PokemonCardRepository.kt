package com.agus18104002.pertemuan3.repositories

import com.agus18104002.pertemuan3.datastores.pokemoncard.PokemonCardDataStore
import com.agus18104002.pertemuan3.models.PokemonCard

class PokemonCardRepository private constructor() : BaseRepository<PokemonCardDataStore>() {
    suspend fun getPokemons(set: String): MutableList<PokemonCard>? {
        val cache = localDataStore?.getPokemons(set)
        if (cache != null) return cache
        val response = remoteDataStore?.getPokemons(set)
        localDataStore?.addAll(set, response)
        return response
    }

    companion object {
        val instance by lazy { PokemonCardRepository() }
    }
}