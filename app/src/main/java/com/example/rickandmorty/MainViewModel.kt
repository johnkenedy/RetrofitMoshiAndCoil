package com.example.rickandmorty

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.network.ApiClient
import com.example.rickandmorty.network.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: Repository = Repository(ApiClient.apiService)
) : ViewModel() {

    private var _charactersLiveData = MutableLiveData<ScreenState<List<Character>?>>()
    val characterLiveData: LiveData<ScreenState<List<Character>?>>
        get() = _charactersLiveData

    init {
        fetchCharacter()
    }

    private fun fetchCharacter() {
        _charactersLiveData.postValue(ScreenState.Loading(null))
        // IO - network calls, databases.
        // Main - Update the UI.
        // Default - CPU intense tasks.
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val client = repository.getCharacters("1")
                _charactersLiveData.postValue(ScreenState.Success(client.result))
            } catch (e: Exception) {
                _charactersLiveData.postValue(ScreenState.Error(e.message.toString(), null))
            }
        }
    }
}