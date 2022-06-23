package com.example.noteapp.presenter.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.noteapp.databinding.ActivityMainBinding
import com.example.noteapp.presenter.viewmodel.NotasViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var viewModel: NotasViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configListenners()
        configObservers()
        viewModel.getNotes()
    }

    private fun configObservers() {
        viewModel.listNotas.observe(this) {
            println(it)
        }
    }

    private fun configListenners(){
        configClickFab()
        configClickMenu()
    }

    private fun configClickMenu() {
        binding.mainActivityImgTitulo.setOnClickListener {
            binding.mainActivityLayoutChips.visibility =
                if (binding.mainActivityLayoutChips.visibility == View.GONE) View.VISIBLE else View.GONE
        }
    }

    private fun configClickFab() {
        binding.mainFabButton.setOnClickListener {
            Intent(this, AddNoteActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}