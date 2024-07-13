package com.example.composetask.domain.model

import com.example.composetask.data.network.model.MovieDTO

data class Movie(
    val id: Int,
    val title: String,
    val year: Int,
    val genre: List<String>,
    val rating: Double,
    val director: String,
    val actors: List<String>,
    val plot: String,
    val poster: String,
    val trailer: String,
    val runtime: Int,
    val awards: String,
    val country: String,
    val language: String,
    val boxOffice: String,
    val production: String,
    val website: String
) {
    val actorsText get() = actors.joinToString(",")
    val genreText get() = genre.joinToString(",")
}

fun MovieDTO.toDomainModel(): Movie {
    return Movie(
        id = this.id ?: 0,
        title = this.title.orEmpty(),
        year = this.year ?: 0,
        genre = this.genre.orEmpty(),
        rating = this.rating ?: 0.0,
        director = this.director.orEmpty(),
        actors = this.actors.orEmpty(),
        plot = this.plot.orEmpty(),
        poster = this.poster.orEmpty(),
        trailer = this.trailer.orEmpty(),
        runtime = this.runtime ?: 0,
        awards = this.awards.orEmpty(),
        country = this.country.orEmpty(),
        language = this.language.orEmpty(),
        boxOffice = this.boxOffice.orEmpty(),
        production = this.production.orEmpty(),
        website = this.website.orEmpty()
    )
}