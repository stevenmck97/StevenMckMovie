package org.wit.movie.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_movie.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast
import org.wit.movie.R
import org.wit.movie.main.MainApp
import org.wit.movie.models.MovieModel

class MovieActivity : AppCompatActivity(), AnkoLogger {

    var movie = MovieModel()
    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        app = application as MainApp

        btnAdd.setOnClickListener() {
            movie.title = movieTitle.text.toString()
            movie.description = movieDescription.text.toString()
            if (movie.title.isNotEmpty()) {
                app.movies.add(movie.copy())
                info("Add Button Pressed. name: ${movie.title}")
                app.movies.forEach{info ("add button pressed: ${it}")}
                setResult(AppCompatActivity.RESULT_OK)
                finish()
            }
            else {
                toast ("Please enter a title")
            }
        }
    }
}
