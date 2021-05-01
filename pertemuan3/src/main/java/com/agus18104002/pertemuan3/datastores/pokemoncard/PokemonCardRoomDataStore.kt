package com.agus18104002.pertemuan3.datastores.pokemoncard

import com.agus18104002.pertemuan3.local.PokemonCardDao
import com.agus18104002.pertemuan3.models.PokemonCard

class PokemonCardRoomDataStore(private val pokemonCardDao: PokemonCardDao) : PokemonCardDataStore {
    override suspend fun getPokemons(set: String): MutableList<PokemonCard>? {
        val response = pokemonCardDao.getAll(set)
        return if (response.isEmpty()) null else response
    }

    override suspend fun addAll(set: String, pokemons: MutableList<PokemonCard>?) {
        pokemons?.let { pokemonCardDao.insertAll(*it.toTypedArray()) }
    }
}