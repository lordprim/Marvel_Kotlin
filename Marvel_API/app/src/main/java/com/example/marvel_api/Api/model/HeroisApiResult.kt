package com.example.marvel_api.Api.model

import com.example.marvel_api.domain.Heroi

data class HeroisApiResult(
    val data: HeroiData
)

data class HeroiData(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<HeroiResult>
)

data class HeroiResult(
    val name: String,
    val thumbnail: HeroiScreen,
    val comics: HeroiComics,
    val series: HeroiSeries,
    val stories: HeroiStories,
    val events: HeroiEvents
)

data class HeroiScreen(
    val path: String?,
    val extension: String?
)

data class HeroiComics(
    val available: Int,
)

data class HeroiSeries(
    val available: Int,
)

data class HeroiStories(
    val available: Int,
)

data class HeroiEvents(
    val events: Int?,
)