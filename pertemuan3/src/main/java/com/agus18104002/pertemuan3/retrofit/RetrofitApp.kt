package com.agus18104002.pertemuan3.retrofit

import com.agus18104002.pertemuan3.models.PokemonCard
import com.agus18104002.pertemuan3.models.PokemonSet
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object RetrofitApp {
    private const val BASE_URL = "https://api.pokemontcg.io/v1/"

    private val client = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val POKEMON_TCG_SERVICE: PokemonTcgService = client.create(PokemonTcgService::class.java)
}

interface PokemonTcgService {
    @GET("cards")
    suspend fun getCards(@Query("set") set: String): Response<PokemonCard.PokemonCardResponse>

    @GET("sets")
    suspend fun getSets(): Response<PokemonSet.PokemonSetResponse>
}