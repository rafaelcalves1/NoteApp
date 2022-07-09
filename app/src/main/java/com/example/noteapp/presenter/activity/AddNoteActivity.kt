package com.example.noteapp.presenter.activity

import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapp.databinding.ActivityAddNoteBinding
import com.example.noteapp.domain.model.ColorBackground
import com.example.noteapp.domain.model.ColorBackground.*
import com.example.noteapp.domain.model.ColorPick
import com.example.noteapp.domain.model.Nota
import com.example.noteapp.presenter.adapter.ItemColorPickAdapter
import com.example.noteapp.presenter.viewmodel.AddNotesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteBinding

    private val listColor = listOf(
        ColorPick(BLUE, false),
        ColorPick(ORANGE, false),
        ColorPick(PINK, false),
        ColorPick(YELLOW, false),
        ColorPick(VIOLET, false)
    )

    private val viewModel: AddNotesViewModel by viewModel()
    private var colorNote: ColorBackground = BLUE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.apply {
            addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        }
        addObservers()
        addListenners()
        configRecycler()
    }

    private fun addListenners() {
        binding.addNoteSaveNote.setOnClickListener {
            viewModel.addNotes(
                Nota(
                    titulo = binding.addNoteInputTitle.text.toString(),
                    descricao = binding.addNoteInputBody.text.toString(),
                    datacriacao = System.currentTimeMillis(),
                    colorNota = colorNote.ordinal
                )
            )
        }
    }

    private fun configRecycler() {
        binding.addNoteRecyclerColors.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = ItemColorPickAdapter(::setOnColorPick).apply {
                submitList(listColor)
            }
        }
    }

    private fun setOnColorPick(colorPick: ColorPick) {
        if (colorPick.isEnabled) {
            colorNote = colorPick.color
            binding.root.setBackgroundResource(colorPick.setBackgroundColorRes())
        }
    }

    private fun addObservers() {
        viewModel.addNoteSuccess.observe(this) {
            it?.let {
                this.finish()
            }
        }

        viewModel.error.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

}