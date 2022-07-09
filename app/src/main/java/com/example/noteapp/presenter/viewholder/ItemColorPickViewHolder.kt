package com.example.noteapp.presenter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.domain.model.ColorPick

class ItemColorPickViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val colorItem = view.rootView

    fun bindItem(color: ColorPick, listenner: (ColorPick) -> Unit) {
        colorItem.setBackgroundResource(color.setBackgroundRes())
        colorItem.setOnClickListener {
            listenner(color.copy(isEnabled = color.isEnabled.not()))
        }
    }
}