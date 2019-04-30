package org.wit.movie.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_movie.*
import kotlinx.android.synthetic.main.activity_movie_list.*
import kotlinx.android.synthetic.main.card_movie.*
import org.jetbrains.anko.*
import org.wit.movie.R
import org.wit.movie.main.MainApp
import org.wit.movie.models.Location
import org.wit.movie.models.MovieModel
import org.wit.movie.org.wit.movie.helpers.readImage
import org.wit.movie.org.wit.movie.helpers.readImageFromPath
import org.wit.movie.org.wit.movie.helpers.showImagePicker

class MovieActivity : AppCompatActivity(), AnkoLogger {

    var movie = MovieModel()
    lateinit var app: MainApp
    var edit = false
    val IMAGE_REQUEST = 1
    val LOCATION_REQUEST = 2
    var location = Location(52.245696, -7.139102, 15f)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        app = application as MainApp

        if (intent.hasExtra("movie_edit"))
        {
            edit = true
            movie = intent.extras.getParcelable<MovieModel>("movie_edit")
            movieTitle.setText(movie.title)
            movieDescription.setText(movie.description)
            btnAdd.setText(R.string.save_movie)
            movieImage.setImageBitmap(readImageFromPath(this, movie.image))
            if (movie.image != null) {
                chooseImage.setText(R.string.change_movie_image)
            }
        }

        btnAdd.setOnClickListener() {
            movie.title = movieTitle.text.toString()
            movie.description = movieDescription.text.toString()
            if (movie.title.isEmpty()) {
                toast(R.string.enter_movie_title)
            } else {
                if (edit) {
                    app.movies.update(movie.copy())
                } else {
                    app.movies.create(movie.copy())
                }
            }
            info("add Button Pressed: $movieTitle")
            setResult(AppCompatActivity.RESULT_OK)
            finish()
        }

        //Add action bar and set title
        toolbarAdd.title = title
        setSupportActionBar(toolbarAdd)

        chooseImage.setOnClickListener {
            info ("Select image")
        }

        chooseImage.setOnClickListener {
            showImagePicker(this, IMAGE_REQUEST)
        }

        movieLocation.setOnClickListener {
            info ("Set Location Pressed")
        }

        movieLocation.setOnClickListener {
            startActivityForResult(intentFor<MapsActivity>().putExtra("location", location), LOCATION_REQUEST)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_movie, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.item_cancel-> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            IMAGE_REQUEST -> {
                if (data != null) {
                    movie.image = data.getData().toString()
                    movieImage.setImageBitmap(readImage(this, resultCode, data))
                    chooseImage.setText(R.string.change_movie_image)
                }
            }
            LOCATION_REQUEST -> {
                if (data != null) {
                    location = data.extras.getParcelable<Location>("location")
                }
            }
        }
    }
}
