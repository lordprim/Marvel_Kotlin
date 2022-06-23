package com.example.marvel_api.Api

import android.util.Log
import com.example.marvel_api.Api.model.*
import com.example.marvel_api.extensions.md5
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

// Aqui é feito o login na API para coleta das informações, foi utilizado HttpClient para isso.
// A API em questão precisa de duas KEYS e uma HASH md5, a autenticação md5 é feita no arquivo StrinExtensions.kt dentro de extensions
// Para logar na API é necessário também o time zone, que é apresentado por ts na estrutura do código

object HeroiRepository {
    private val service: HeroiService

    init{
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
        httpClient.addInterceptor { chain ->
            val original = chain.request()
            val originalHttpUrl = original.url

            val ts = (Calendar.getInstance(TimeZone.getTimeZone("UTC")).timeInMillis / 1000L).toString()
            val url = originalHttpUrl.newBuilder()
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("ts", ts)
                .addQueryParameter("hash", "$ts$PRIVATE_KEY$API_KEY".md5())
                .build()
                    chain.proceed(original.newBuilder().url(url).build())
        }

// Aqui é onde o retrofit faz o acesso a URL e converte de JSON para a linguagem que o kotlin entende.
// É aqui também onde o retrofit cria o serviço que coletará as informações da API

        val retrofit = Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com:443/v1/public/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
        service = retrofit.create(HeroiService::class.java)
    }

    fun listHerois(): HeroisApiResult? {
        val call = service.listHerois()
        return call.execute().body()
    }
}
