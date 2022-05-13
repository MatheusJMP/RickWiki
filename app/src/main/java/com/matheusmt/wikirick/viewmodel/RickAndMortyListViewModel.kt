package com.matheusmt.wikirick.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matheusmt.wikirick.BuildConfig
import com.matheusmt.wikirick.data.model.*
import com.matheusmt.wikirick.repository.RickAndMortyListService
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class RickAndMortyListViewModel(
    private val repository: RickAndMortyListService
) : ViewModel(),
    CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext = Dispatchers.Main + job
    private var pathNextList = ""

    private val listCharacterState = MutableLiveData<List<Results>>()
    val listCharacter: LiveData<List<Results>> get() = listCharacterState

    private val listCharacterNextPageState = MutableLiveData<List<Results>>()
    val listCharacterNextPage: LiveData<List<Results>> get() = listCharacterNextPageState

    private var actualPage = 1

    fun getList() {
        launch {
            val result = withContext(Dispatchers.IO) {
                repository.getListCharacter()
            }

            when (result) {
                is CustomResponse.Success -> {
                    listCharacterState.value = result.data.results
                    actualPage++
                    Log.i("Lista", result.data.toString())
                }
                is CustomResponse.Error -> {
                }
            }
        }
    }

    fun getNextPage() {
        launch {
            val result = withContext(Dispatchers.IO) {
                repository.getNextPage(actualPage.toString())
            }

            when (result) {
                is CustomResponse.Success -> {
                    listCharacterNextPageState.value = result.data.results
                    actualPage++
                    Log.i("Lista", result.data.toString())
                    Log.i("count", actualPage.toString())
                }
                is CustomResponse.Error -> {
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}