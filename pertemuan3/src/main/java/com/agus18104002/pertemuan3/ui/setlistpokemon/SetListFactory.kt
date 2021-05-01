package com.agus18104002.pertemuan3.ui.setlistpokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.agus18104002.pertemuan3.repositories.PokemonSetRepository

class SetListFactory(
    private val setRepository: PokemonSetRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SetListViewModel::class.java))
            return SetListViewModel(
                setRepository
            ) as T
        throw IllegalArgumentException()
    }
}