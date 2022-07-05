package com.example.noteapp.presenter.util

import android.view.View
import androidx.annotation.ColorRes
import com.example.noteapp.R

fun View.changeColorBackground(@ColorRes color : Int){
    this.setBackgroundColor(resources.getColor(color, null))
}