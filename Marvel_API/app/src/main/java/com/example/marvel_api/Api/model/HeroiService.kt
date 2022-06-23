package com.example.marvel_api.Api.model

import retrofit2.Call
import retrofit2.http.GET

// Aqui é onde fazemos o GET das informações na raiz da API, a partir dela é feita a listagem das informações coletadas em HeroiApiResult

interface HeroiService {
    @GET("characters")
    fun listHerois(): Call<HeroisApiResult>
}