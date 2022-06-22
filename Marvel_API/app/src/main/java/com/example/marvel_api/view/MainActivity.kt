package com.example.marvel_api.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel_api.Api.HeroiRepository
import com.example.marvel_api.Api.model.HeroiResult
import com.example.marvel_api.Api.model.HeroiScreen
import com.example.marvel_api.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rvHeroi)

        Thread(Runnable {
            loadHerois(recyclerView)
        }).start()
    }
    private fun loadHerois(
        recyclerView: RecyclerView
    ) {

        val heroisApiResult = HeroiRepository.listHerois()

        heroisApiResult?.data?.results?.let {
            val herois: List<HeroiResult> = it.map {
                HeroiResult(it.name, it.thumbnail, it.urls)
            }

            Log.d("HEROI_API", it.toString())

            val layoutManager = LinearLayoutManager(this)

            recyclerView.post {
                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = HeroiAdapter(herois)
            }
        }
    }
}