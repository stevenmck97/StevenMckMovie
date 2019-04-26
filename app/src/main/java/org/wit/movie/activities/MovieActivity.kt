package org.wit.movie.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_movie.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast
import org.wit.movie.R
import org.wit.movie.models.MovieModel

class MovieActivity : AppCompatActivity(), AnkoLogger {

    var movie = MovieModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        info("Movie Activity started..")

        btnAdd.setOnClickListener() {
            movie.title = placemarkTitle.text.toString()
            if (movie.title.isNotEmpty()) {
                info("add Button Pressed: $movie")
            }
            else {
                toast ("Please Enter a title")
            }
        }
        }
        }


