package com.example.marvel_api.Api

import android.util.Log
import com.example.marvel_api.Api.model.*
import com.example.marvel_api.extensions.md5
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

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

//        call.enqueue(object : Callback<HeroisApiResult> {
//            override fun onResponse(
//                call: Call<HeroisApiResult>,
//                response: Response<HeroisApiResult>
//            ) {
//                if (response.isSuccessful) {
//                    val body = response.body()
//                    body?.data?.results?.let {
//                        Log.d("HEROI_API", it[0].name)
//                        for (item in it) {
//                            Log.d("HEROI_API", item.name)
//                        }
//
//                    }
//                }
//                Log.d("HEROI_API", "Heroi list Loaded")
//            }
//
//            override fun onFailure(call: Call<HeroisApiResult>, t: Throwable) {
//                Log.e("HEROI_API", "ERROR Loading heroi list", t)
//            }
//        })
    }
}
