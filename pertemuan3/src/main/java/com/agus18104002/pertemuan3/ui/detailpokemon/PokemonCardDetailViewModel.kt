package com.agus18104002.pertemuan3.ui.detailpokemon

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.agus18104002.pertemuan3.models.PokemonCard

class PokemonCardDetailViewModel : ViewModel() {
    private val mViewState = MutableLiveData<PokemonCardDetailViewState>().apply {
        value =
            PokemonCardDetailViewState(null)
    }
    val viewState: LiveData<PokemonCardDetailViewState>
        get() = mViewState

    fun setData(pokemonCard: PokemonCard) {
        mViewState.value = mViewState.value?.copy(data = pokemonCard)
    }
}