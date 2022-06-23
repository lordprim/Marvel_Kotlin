package com.example.marvel_api.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel_api.Api.model.HeroiResult
import com.example.marvel_api.R

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        val recyclerView = findViewById<RecyclerView>(R.id.rvFavoriteHeroi)

    }
}