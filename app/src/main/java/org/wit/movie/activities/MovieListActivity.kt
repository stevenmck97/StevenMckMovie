package org.wit.movie.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import kotlinx.android.synthetic.main.activity_movie_list.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivityForResult
import org.wit.movie.MovieAdapter
import org.wit.movie.MovieListener
import org.wit.movie.R
import org.wit.movie.main.MainApp
import org.wit.movie.models.MovieModel

class MovieListActivity : AppCompatActivity(), MovieListener {

    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)
        app = application as MainApp

        //layout and populate for display
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager   //recyclerView is a widget in activity_movie_list.xml
        loadMovies()

        //enable action bar and set title
        toolbarMain.title = title
        setSupportActionBar(toolbarMain)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.item_add -> startActivityForResult<MovieActivity>(0)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onMovieClick(movie: MovieModel) {
        startActivityForResult(intentFor<MovieActivity>().putExtra("movie_edit", movie), 0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        loadMovies()
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun loadMovies() {
        showMovies(app.movies.findAll())
    }

    fun showMovies (movies: List<MovieModel>) {
        recyclerView.adapter = MovieAdapter(movies, this)
        recyclerView.adapter?.notifyDataSetChanged()
    }

}