package com.example.marvel_api.Api.model

import com.example.marvel_api.Api.model.HeroisApiResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface HeroiService {
    @GET("characters")
    fun listHerois(): Call<HeroisApiResult>
}