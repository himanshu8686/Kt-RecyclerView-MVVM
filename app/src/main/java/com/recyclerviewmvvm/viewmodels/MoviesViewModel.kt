package com.recyclerviewmvvm.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.recyclerviewmvvm.coroutines.Coroutines
import com.recyclerviewmvvm.models.responseModels.Movie
import com.recyclerviewmvvm.repositories.MoviesRepository
import kotlinx.coroutines.Job

class MoviesViewModel(
    private val moviesRepository: MoviesRepository
) : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()
    private lateinit var job :Job

    /**
     *  This getter is made because we don't want to expose mutable list to the ui
     */
    val movies : LiveData<List<Movie>>
        get() {
            return _movies
        }

    fun getMoviesFromViewModel(){
        job = Coroutines.ioThenMain(
            {moviesRepository.getMoviesFromRepo()},
            {_movies.value=it}
        )

    }

    /**
     *  To clear the Job
     */
    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}