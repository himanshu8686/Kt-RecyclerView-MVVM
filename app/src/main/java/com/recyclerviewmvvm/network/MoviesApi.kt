package com.recyclerviewmvvm.network

import com.recyclerviewmvvm.models.responseModels.Movie
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Project Name :RecyclerViewMvvm
 * Created By :Himanshu sharma on 27-02-2021
 * Package : com.recyclerviewmvvm
 */

interface MoviesApi {

    companion object{
        const val BaseUrl:String = "https://api.simplifiedcoding.in/course-apis/recyclerview/"
        // MoviesApi() is equivalent to invoke function
        operator fun invoke() : MoviesApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BaseUrl)
                .build()
                .create(MoviesApi::class.java)
        }
    }
    
    @GET("movies")
    suspend fun getMoviesFromApi():Response<List<Movie>>
}