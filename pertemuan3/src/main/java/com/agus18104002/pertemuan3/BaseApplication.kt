package com.agus18104002.pertemuan3

import android.app.Application
import com.agus18104002.pertemuan3.datastores.pokemoncard.PokemonCardRemoteDataStore
import com.agus18104002.pertemuan3.datastores.pokemoncard.PokemonCardRoomDataStore
import com.agus18104002.pertemuan3.datastores.pokemonset.PokemonSetRemoteDataStore
import com.agus18104002.pertemuan3.datastores.pokemonset.PokemonSetRoomDataStore
import com.agus18104002.pertemuan3.local.AppDatabase
import com.agus18104002.pertemuan3.repositories.PokemonCardRepository
import com.agus18104002.pertemuan3.repositories.PokemonSetRepository
import com.agus18104002.pertemuan3.retrofit.RetrofitApp

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val pokemonTcgService = RetrofitApp.POKEMON_TCG_SERVICE
        val appDatabase = AppDatabase.getInstance(this)
        PokemonSetRepository.instance.apply {
            init(
                PokemonSetRoomDataStore(appDatabase.pokemonSetDao()),
                PokemonSetRemoteDataStore(pokemonTcgService)
            )
        }

        PokemonCardRepository.instance.apply {
            init(
                PokemonCardRoomDataStore(appDatabase.pokemonCardDao()),
                PokemonCardRemoteDataStore(pokemonTcgService)
            )
        }
    }
}