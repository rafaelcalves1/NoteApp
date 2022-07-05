package com.example.noteapp.presenter.activity

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.noteapp.R
import com.example.noteapp.databinding.ActivityAddNoteBinding
import com.example.noteapp.presenter.util.changeColorBackground
import kotlinx.coroutines.launch

class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.apply {
            addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        }
        binding.addNoteColorOrange.isEnabled = false
        addListenners()
    }

    private fun addListenners() {
        binding.addNoteColorOrange.setOnClickListener {
            configBtn(it)
            binding.root.changeColorBackground(R.color.orange)
        }
        binding.addNoteColorYellow.setOnClickListener {
            configBtn(it)
            binding.root.changeColorBackground(R.color.yellow)
        }
        binding.addNoteColorViolet.setOnClickListener {
            configBtn(it)
            binding.root.changeColorBackground(R.color.violet)
        }
        binding.addNoteColorBlue.setOnClickListener {
            configBtn(it)
            binding.root.changeColorBackground(R.color.blue)
        }
        binding.addNoteColorPink.setOnClickListener {
            configBtn(it)
            binding.root.changeColorBackground(R.color.pink)
        }
    }

    private fun configBtn(view: View) {
        view.isEnabled = false
        val listButton = listOf(
            binding.addNoteColorOrange,
            binding.addNoteColorYellow,
            binding.addNoteColorViolet,
            binding.addNoteColorBlue,
            binding.addNoteColorPink
        )
        lifecycleScope.launch {
            listButton.forEach {
                if (it != view) {
                    it.isEnabled = true
                }
            }
        }
    }
}