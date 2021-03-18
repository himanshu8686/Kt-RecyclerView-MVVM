package com.recyclerviewmvvm.adapters

import android.view.View
import com.recyclerviewmvvm.models.responseModels.Movie

/**
 * Project Name :RecyclerViewMvvm
 * Created By :Himanshu sharma on 27-02-2021
 * Package : com.recyclerviewmvvm.adapters
 */
interface MoviesRecyclerViewClickListener
{
    fun onItemClick(view: View,movie: Movie)
}