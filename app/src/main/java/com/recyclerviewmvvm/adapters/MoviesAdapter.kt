package com.recyclerviewmvvm.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.recyclerviewmvvm.R
import com.recyclerviewmvvm.databinding.RecyclerviewMovieBinding
import com.recyclerviewmvvm.models.responseModels.Movie
import com.recyclerviewmvvm.views.MoviesFragment

/**
 * Project Name :RecyclerViewMvvm
 * Created By :Himanshu sharma on 27-02-2021
 * Package : com.recyclerviewmvvm.adapters
 */

lateinit var _context:Context
class MoviesAdapter(
    context: Context,
    private val movies: List<Movie>,
    private val listener: MoviesRecyclerViewClickListener
) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    init {
        _context=context
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : MoviesViewHolder{
        return  MoviesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_movie,
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.recyclerviewMovieBinding.movie = movies[position]

        holder.recyclerviewMovieBinding.buttonBook.setOnClickListener {
            Toast.makeText(it.context, "index from adapter" + position, Toast.LENGTH_SHORT).show()
        }

        // using listener for callback
        holder.recyclerviewMovieBinding.layoutLike.setOnClickListener {
            listener.onItemClick(holder.recyclerviewMovieBinding.layoutLike,movies[position])
        }

    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class MoviesViewHolder(
        val recyclerviewMovieBinding: RecyclerviewMovieBinding
    ):RecyclerView.ViewHolder(recyclerviewMovieBinding.root)

}