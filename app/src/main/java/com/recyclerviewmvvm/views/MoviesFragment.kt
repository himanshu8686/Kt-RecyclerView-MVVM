package com.recyclerviewmvvm.views
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.recyclerviewmvvm.R
import com.recyclerviewmvvm.adapters.MoviesAdapter
import com.recyclerviewmvvm.adapters.MoviesRecyclerViewClickListener
import com.recyclerviewmvvm.models.responseModels.Movie

import com.recyclerviewmvvm.network.MoviesApi
import com.recyclerviewmvvm.repositories.MoviesRepository
import com.recyclerviewmvvm.viewModelFactory.MoviesViewModelFactory
import com.recyclerviewmvvm.viewmodels.MoviesViewModel
import kotlinx.android.synthetic.main.movies_fragment.*

class MoviesFragment : Fragment(),MoviesRecyclerViewClickListener {

    private lateinit var moviesViewModel: MoviesViewModel
    private lateinit var moviesViewModelFactory: MoviesViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movies_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = MoviesApi()
        val moviesRepository= MoviesRepository(api)
        moviesViewModelFactory = MoviesViewModelFactory(moviesRepository)
        moviesViewModel = ViewModelProvider(this,moviesViewModelFactory).get(MoviesViewModel::class.java)
//
        moviesViewModel.getMoviesFromViewModel()
        moviesViewModel.movies.observe(viewLifecycleOwner, Observer {
            movies ->
            rv_movies.also {
                it.layoutManager=LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = MoviesAdapter(requireContext(),movies,this)
            }
        })


    }

    public fun GetClick(position:Int){
        Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show()
    }

    override fun onItemClick(view: View, movie: Movie) {
        when(view.id){
            R.id.layout_like -> {
                Toast.makeText(requireContext(), "layout like clicked"+movie.like_percent, Toast.LENGTH_SHORT).show()
            }
        }
    }

}