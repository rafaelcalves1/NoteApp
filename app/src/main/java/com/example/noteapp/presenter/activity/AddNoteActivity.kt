package com.example.noteapp.presenter.activity

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.noteapp.R
import com.example.noteapp.databinding.ActivityAddNoteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNoteActivity: AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.apply {
            addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        }
        binding.addNoteColorOrange.isEnabled = false
        configColors()
    }

    private fun configColors(){
        binding.addNoteColorOrange.setOnClickListener {
            configBtn(it)
            binding.root.setBackgroundColor(resources.getColor(R.color.orange, null))
        }
        binding.addNoteColorYellow.setOnClickListener {
            configBtn(it)
            binding.root.setBackgroundColor(resources.getColor(R.color.yellow, null))
        }
        binding.addNoteColorViolet.setOnClickListener {
            configBtn(it)
            binding.root.setBackgroundColor(resources.getColor(R.color.violet, null))
        }
        binding.addNoteColorBlue.setOnClickListener {
            configBtn(it)
            binding.root.setBackgroundColor(resources.getColor(R.color.blue, null))
        }
        binding.addNoteColorPink.setOnClickListener {
            configBtn(it)
            binding.root.setBackgroundColor(resources.getColor(R.color.pink, null))
        }
    }

    private fun configBtn(view: View){
        view.isEnabled = false
        val listButton = listOf(binding.addNoteColorOrange, binding.addNoteColorYellow, binding.addNoteColorViolet, binding.addNoteColorBlue, binding.addNoteColorPink)
        listButton.forEach {
            if(it != view){
                it.isEnabled = true
            }
        }
    }
}