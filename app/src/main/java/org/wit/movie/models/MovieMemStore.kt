package org.wit.movie.models

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

abstract class MovieMemStore : MovieStore, AnkoLogger {

    val movies = ArrayList<MovieModel>()

    override fun findAll(): List<MovieModel> {
        return movies
    }

    override fun create(movie: MovieModel) {
        movie.id = getId()
        movies.add(movie)
        logAll()
    }

   override fun update(movie: MovieModel) {
        var foundMovie: MovieModel? = movies.find { p -> p.id == movie.id }
        if (foundMovie != null) {
            foundMovie.title = movie.title
            foundMovie.description = movie.description
            foundMovie.image = movie.image
            foundMovie.lat = movie.lat
            foundMovie.lng = movie.lng
            foundMovie.zoom = movie.zoom
            logAll();
        }
    }


    fun logAll() {
        movies.forEach { info("${it}") }
    }
}
