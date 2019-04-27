package org.wit.movie.main

import android.app.Application
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.wit.movie.models.MovieModel

class MainApp : Application(), AnkoLogger {

    val movies = ArrayList<MovieModel>()

    override fun onCreate() {
        super.onCreate()
        info("Movie started")
        movies.add(MovieModel("One", "About one..."))
        movies.add(MovieModel("Two", "About two..."))
        movies.add(MovieModel("Three", "About three..."))
    }
}