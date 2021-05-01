package com.agus18104002.pertemuan3.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.agus18104002.pertemuan3.models.PokemonSet

@Dao
interface PokemonSetDao {
    @Query("SELECT * FROM PokemonSet")
    suspend fun getAll(): MutableList<PokemonSet>

    @Query("DELETE FROM PokemonSet")
    suspend fun deleteAll()

    @Insert
    suspend fun insertAll(vararg pokemonSet: PokemonSet)
}