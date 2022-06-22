package com.example.marvel_api.view

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.marvel_api.Api.model.HeroiResult
import com.example.marvel_api.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val heroi = intent.getParcelableExtra<HeroiResult>("heroi")
        if (heroi != null){
            val imageView : ImageView = findViewById(R.id.ivHeroidt)
            val textView2 : TextView = findViewById(R.id.tvNamedt)
            val textView3 : TextView = findViewById(R.id.tvComicsdt)
            val textView4 : TextView = findViewById(R.id.tvSeriesdt)
            val textView5 : TextView = findViewById(R.id.tvStoriesdt)

            var midia2 = "${heroi.thumbnail?.path}.${heroi.thumbnail?.extension}"
            var lista = midia2.split(":").toMutableList()
            lista[0] = lista[0]+"s"
            Log.d("MIDIA_INTENT", lista.toString())

            midia2 = "${lista[0]}:${lista[1]}"

            Log.d("HEROI_INTENT", heroi.toString())

            Glide.with(this).load(midia2).into(imageView)
            textView2.text = "Herói: ${heroi.name}"
            textView3.text = "Comics: ${heroi.comics?.available.toString()}"
            textView4.text = "Series: ${heroi.series?.available.toString()}"
            textView5.text = "Histórias: ${heroi.stories?.available.toString()}"
        }

    }
}
