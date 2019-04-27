package org.wit.movie;

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.card_movie.view.*
import org.wit.movie.R
import org.wit.movie.models.MovieModel

interface MovieListener {
    fun onMovieClick(movie: MovieModel)
}

class MovieAdapter constructor(private var movies: List<MovieModel>,
                                   private val listener: MovieListener) : RecyclerView.Adapter<MovieAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        return MainHolder(LayoutInflater.from(parent?.context).inflate(R.layout.card_movie, parent, false))
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val movie = movies[holder.adapterPosition]
        holder.bind(movie, listener)
    }

    override fun getItemCount(): Int = movies.size

    class MainHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(movie: MovieModel,  listener : MovieListener) {
            itemView.movieTitleList.text= movie.title
            itemView.movieDescriptionList.text = movie.description
            itemView.setOnClickListener { listener.onMovieClick(movie) }
        }
    }
}
