package com.agus18104002.pertemuan3.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.agus18104002.pertemuan3.models.PokemonCard
import com.agus18104002.pertemuan3.models.PokemonSet

@Database(entities = [PokemonCard::class, PokemonSet::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pokemonCardDao(): PokemonCardDao
    abstract fun pokemonSetDao(): PokemonSetDao

    companion object {
        private var instance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            instance?.let { return it }
            instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "pokemon-card"
            ).build()
            return instance!!
        }
    }
}