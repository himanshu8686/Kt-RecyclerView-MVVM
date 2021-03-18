package com.recyclerviewmvvm.repositories

import com.recyclerviewmvvm.SafeApiRequest
import com.recyclerviewmvvm.network.MoviesApi

/**
 * Project Name :RecyclerViewMvvm
 * Created By :Himanshu sharma on 27-02-2021
 * Package : com.recyclerviewmvvm.repositories
 */
class MoviesRepository(
    private val api: MoviesApi
) :SafeApiRequest(){

    /**
     *  This function will return the List of movies to the view model
     */
    suspend fun getMoviesFromRepo() = apiRequest {
        api.getMoviesFromApi()
    }
}