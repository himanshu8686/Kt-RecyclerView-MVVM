package com.recyclerviewmvvm.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.recyclerviewmvvm.repositories.MoviesRepository
import com.recyclerviewmvvm.viewmodels.MoviesViewModel

/**
 * Project Name :RecyclerViewMvvm
 * Created By :Himanshu sharma on 27-02-2021
 * Package : com.recyclerviewmvvm.viewModelFactory
 */

@Suppress("UNCHECKED_CAST")
class MoviesViewModelFactory(
    private val moviesRepository: MoviesRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesViewModel(moviesRepository) as T
    }
}