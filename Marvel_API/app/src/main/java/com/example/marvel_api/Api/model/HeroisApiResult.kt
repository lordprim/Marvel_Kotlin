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
    val urls: List<HeroiUrls>,
)

data class HeroiUrls(
    val type: String,
    val url: String
)

data class HeroiScreen(
    val path: String?,
    val extension: String?
)