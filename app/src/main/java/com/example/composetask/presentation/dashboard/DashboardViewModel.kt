package com.example.composetask.presentation.dashboard

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composetask.data.network.NetworkResponse
import com.example.composetask.domain.repo.DataRepo
import com.example.composetask.domain.usecase.GreetingsUseCase
import com.example.composetask.navigation.NavRoute
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    greetingsUseCase: GreetingsUseCase,
    private val gson: Gson,
    private val dataRepo: DataRepo
) : ViewModel() {

    private var _uiState = MutableStateFlow(DashboardUiState())
    var uiState = _uiState.asStateFlow()

    private val _uiEvent = Channel<DashboardIntent>()

    private val _channel = Channel<EventsToView>()
    val channel = _channel.receiveAsFlow()

    init {
        val email = savedStateHandle.get<String>(NavRoute.Dashboard.email).orEmpty()
        _uiState.update {
            it.copy(
                email = email,
                greetings = greetingsUseCase()
            )
        }

        getMovies()
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            _uiEvent.consumeAsFlow().collectLatest { event ->
                when (event) {
                    is DashboardIntent.OnCardClick -> {
                        val json = gson.toJson(uiState.value.movies[event.position]).replace("/", "$$$")
                        _channel.send(EventsToView.NavigateToDetailsScreen(json))
                    }
                }
            }
        }
    }

    fun onIntent(intent: DashboardIntent) {
        viewModelScope.launch {
            _uiEvent.send(intent)
        }
    }

    private fun getMovies() {
        viewModelScope.launch {
            _uiState.update { it.copy(showLoader = true) }

            when (val response = dataRepo.getMovies()) {
                is NetworkResponse.Error -> {
                    _uiState.update { it.copy(showLoader = false) }
                }

                is NetworkResponse.Success -> {
                    _uiState.update {
                        it.copy(
                            showLoader = false,
                            movies = response.data ?: emptyList()
                        )
                    }
                }
            }
        }
    }

    sealed class EventsToView {
        data class NavigateToDetailsScreen(val details: String): EventsToView()
    }

}