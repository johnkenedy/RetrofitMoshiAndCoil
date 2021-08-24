package com.example.rickandmorty

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rickandmorty.adapter.MainAdapter
import com.example.rickandmorty.databinding.ActivityMainBinding
import com.example.rickandmorty.network.Character
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observer()

    }

    private fun observer() {
        viewModel.characterLiveData.observe(this, { state ->
            processCharactersResponse(state)
        })
    }

    private fun adapter(character: List<Character>?) {
        viewModel.characterLiveData.observe(this, {
            val adapter = character?.let { MainAdapter(it) }
            binding.rvCharacters.layoutManager =
                GridLayoutManager(this, 2)
            binding.rvCharacters.adapter = adapter
        })
    }

    private fun processCharactersResponse(state: ScreenState<List<Character>?>) {

        when (state) {
            is ScreenState.Loading -> {
                binding.cvProgressBar.visibility = View.VISIBLE
            }
            is ScreenState.Success -> {
                binding.cvProgressBar.visibility = View.GONE
                adapter(state.data)
            }
            is ScreenState.Error -> {
                binding.cvProgressBar.visibility = View.GONE
                val view = binding.cvProgressBar.rootView
                Snackbar.make(view, state.message!!, Snackbar.LENGTH_LONG).show()
            }
        }
    }
}