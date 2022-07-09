package com.example.noteapp.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.noteapp.databinding.ItemColorPickBinding
import com.example.noteapp.domain.model.ColorPick
import com.example.noteapp.presenter.viewholder.ItemColorPickViewHolder

class ItemColorPickAdapter(
    private val listenner: (ColorPick) -> Unit
) : ListAdapter<ColorPick, ItemColorPickViewHolder>(
    object : DiffUtil.ItemCallback<ColorPick>() {
        override fun areItemsTheSame(oldItem: ColorPick, newItem: ColorPick): Boolean {
            return true
        }

        override fun areContentsTheSame(oldItem: ColorPick, newItem: ColorPick): Boolean {
            return oldItem == newItem
        }
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemColorPickViewHolder {
        val binding = ItemColorPickBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ItemColorPickViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ItemColorPickViewHolder, position: Int) {
        holder.bindItem(currentList[position], listenner)
    }
}