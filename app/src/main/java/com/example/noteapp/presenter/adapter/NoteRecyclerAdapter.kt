package com.example.noteapp.presenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageButton
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.arch.toolkit.delegate.viewProvider
import com.example.noteapp.R
import com.example.noteapp.databinding.ItemNotaBinding
import com.example.noteapp.domain.model.ColorBackground
import com.example.noteapp.domain.model.ColorBackground.*
import com.example.noteapp.domain.model.Nota

class NoteRecyclerAdapter(
    private val listenner: (Nota) -> Unit
) : ListAdapter<Nota, NoteViewHolder>(
    object : DiffUtil.ItemCallback<Nota>(){
        override fun areItemsTheSame(oldItem: Nota, newItem: Nota): Boolean {
            return oldItem.idNota == newItem.idNota
        }

        override fun areContentsTheSame(oldItem: Nota, newItem: Nota): Boolean {
            return oldItem == newItem
        }
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
       val binding =  ItemNotaBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return NoteViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(currentList[position], listenner)
    }

}

class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val itemTitle by viewProvider<TextView>(R.id.item_note_title)
    private val itemBody by viewProvider<TextView>(R.id.item_note_body)
    private val itemDelete by viewProvider<AppCompatImageButton>(R.id.item_note_delete)

    fun bind(note: Nota, listenner: (Nota) -> Unit) {
        itemTitle.text = note.titulo.capitalize()
        itemBody.text = note.descricao.capitalize()
        itemDelete.setOnClickListener {
            listenner(note)
        }

        itemView.setBackgroundResource(setBackgroundColor(note.colorNota))
    }

    private fun setBackgroundColor(colorID: Int): Int{
       return when(colorID){
            BLUE.ordinal -> {
                R.color.blue
            }
            ORANGE.ordinal -> {
                R.color.orange
            }
            YELLOW.ordinal -> {
                R.color.yellow
            }
            PINK.ordinal -> {
                R.color.pink
            }
            VIOLET.ordinal -> {
                R.color.violet
            }
           else -> {
               R.color.yellow
           }
        }
    }

}