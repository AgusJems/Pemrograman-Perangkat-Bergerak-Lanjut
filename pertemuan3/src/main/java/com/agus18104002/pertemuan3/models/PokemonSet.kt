package com.agus18104002.pertemuan3.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class PokemonSet(
    var name: String,
    @SerializedName("logoUrl") var logo: String,
    @PrimaryKey var code: String
) {
    data class PokemonSetResponse(
        var sets: MutableList<PokemonSet>
    )
}