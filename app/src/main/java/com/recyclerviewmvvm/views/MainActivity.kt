package com.recyclerviewmvvm.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.recyclerviewmvvm.R
import com.recyclerviewmvvm.adapters.MoviesAdapter
import com.recyclerviewmvvm.network.MoviesApi
import com.recyclerviewmvvm.repositories.MoviesRepository
import com.recyclerviewmvvm.viewModelFactory.MoviesViewModelFactory
import com.recyclerviewmvvm.viewmodels.MoviesViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val repository = MoviesRepository(MoviesApi())
//
//        GlobalScope.launch(Dispatchers.Main){
//            val listOfMovies = repository.getMoviesFromRepo()
//            Toast.makeText(this@MainActivity, ""+listOfMovies?.size, Toast.LENGTH_SHORT).show()
//        }


    }
}