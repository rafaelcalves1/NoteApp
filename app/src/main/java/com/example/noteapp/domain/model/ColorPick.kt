package com.example.noteapp.domain.model

import com.example.noteapp.R
import com.example.noteapp.domain.model.ColorBackground.*


data class ColorPick(
    val color: ColorBackground,
    val isEnabled: Boolean = false
) {
    fun setBackgroundColorRes(): Int {
        return when (color) {
            BLUE -> {
                R.color.blue
            }
            YELLOW -> {
                R.color.yellow
            }
            ORANGE -> {
                R.color.orange
            }
            PINK -> {
                R.color.pink
            }
            VIOLET -> {
                R.color.violet
            }
        }
    }

    fun setBackgroundRes(): Int{
        return when (color) {
            BLUE -> {
                R.drawable.background_view_border_blue
            }
            YELLOW -> {
                R.drawable.background_view_border_yellow
            }
            ORANGE -> {
                R.drawable.background_view_border_orange
            }
            PINK -> {
                R.drawable.background_view_border_pink
            }
            VIOLET -> {
                R.drawable.background_view_border_violet
            }
        }
    }
}