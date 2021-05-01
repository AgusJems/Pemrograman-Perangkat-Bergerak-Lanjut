package com.agus18104002.pertemuan3.repositories

import com.agus18104002.pertemuan3.datastores.pokemonset.PokemonSetDataStore
import com.agus18104002.pertemuan3.models.PokemonSet

class PokemonSetRepository private constructor() : BaseRepository<PokemonSetDataStore>() {
    suspend fun getSets(): MutableList<PokemonSet>? {
        val cache = localDataStore?.getSets()
        if (cache != null) return cache
        val response = remoteDataStore?.getSets()
        localDataStore?.addAll(response)
        return response
    }

    companion object {
        val instance by lazy { PokemonSetRepository() }
    }
}
