package com.agus18104002.pertemuan3.datastores.pokemonset

import com.agus18104002.pertemuan3.local.PokemonSetDao
import com.agus18104002.pertemuan3.models.PokemonSet

class PokemonSetRoomDataStore(private val pokemonSetDao: PokemonSetDao) : PokemonSetDataStore {
    override suspend fun getSets(): MutableList<PokemonSet>? {
        val response = pokemonSetDao.getAll()
        return if (response.isEmpty()) null else response
    }

    override suspend fun addAll(sets: MutableList<PokemonSet>?) {
        sets?.let { pokemonSetDao.insertAll() }
    }
}