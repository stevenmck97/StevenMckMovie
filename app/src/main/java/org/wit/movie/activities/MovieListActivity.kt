package org.wit.movie.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import kotlinx.android.synthetic.main.activity_movie_list.*
import kotlinx.android.synthetic.main.card_movie.view.*
import org.jetbrains.anko.startActivityForResult
import org.wit.movie.R
import org.wit.movie.main.MainApp
import org.wit.movie.models.MovieModel

class MovieListActivity : AppCompatActivity(){

    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)
        app = application as MainApp

        //layout and populate for display
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = MovieAdapter(app.movies)

        //enable action bar and set title
        toolbarMain.title = title
        setSupportActionBar(toolbarMain)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

//    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        when (item?.itemId) {
//        R.id.item_add -> startActivityForResult<MovieActivity>(0,0)
//        }
//        return super.onOptionsItemSelected(item)
    //   }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.item_add -> startActivityForResult<MovieActivity>(0)
        }
        return super.onOptionsItemSelected(item)
    }

}

class MovieAdapter constructor(private var movies: List<MovieModel>) :
    RecyclerView.Adapter<MovieAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        return MainHolder(LayoutInflater.from(parent?.context).inflate(R.layout.card_movie, parent, false))
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val movie = movies[holder.adapterPosition]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = movies.size

    class MainHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(movie: MovieModel) {
            itemView.movieTitle.text = movie.title
            itemView.description.text = movie.description
        }
    }
}