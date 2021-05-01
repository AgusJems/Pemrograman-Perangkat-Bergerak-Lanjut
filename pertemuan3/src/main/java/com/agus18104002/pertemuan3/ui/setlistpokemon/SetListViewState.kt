package com.agus18104002.pertemuan3.ui.setlistpokemon

import com.agus18104002.pertemuan3.models.PokemonSet

data class SetListViewState (
    var loading: Boolean = false,
    var error: Exception? = null,
    var data: MutableList<PokemonSet>? = null
)