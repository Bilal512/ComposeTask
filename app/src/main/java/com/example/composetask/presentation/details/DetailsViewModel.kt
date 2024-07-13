package com.example.composetask.presentation.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.composetask.domain.model.Movie
import com.example.composetask.navigation.NavRoute
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    gson: Gson
): ViewModel() {

    private var _uiState = MutableStateFlow(DetailUiState())
    var uiState = _uiState.asStateFlow()

    init {
        savedStateHandle.get<String>(NavRoute.Details.obj)?.let { json ->
            gson.fromJson(json, Movie::class.java)
        }?.let { movie ->
            _uiState.update { it.copy(movie = movie) }
        }

    }

}