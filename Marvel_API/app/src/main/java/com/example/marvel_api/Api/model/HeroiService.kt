package com.example.marvel_api.Api.model

import retrofit2.Call
import retrofit2.http.GET

interface HeroiService {
    @GET("characters")
    fun listHerois(): Call<HeroisApiResult>
}