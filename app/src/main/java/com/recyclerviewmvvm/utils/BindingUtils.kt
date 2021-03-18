package com.recyclerviewmvvm.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Project Name :RecyclerViewMvvm
 * Created By :Himanshu sharma on 27-02-2021
 * Package : com.recyclerviewmvvm.utils
 */

@BindingAdapter("img")
fun loadImage(view : ImageView,url:String){
    Glide.with(view)
        .load(url)
        .into(view)
}