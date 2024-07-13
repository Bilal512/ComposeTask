package com.example.composetask.presentation.dashboard

import com.example.composetask.domain.model.GridItem
import com.example.composetask.domain.model.Movie

data class DashboardUiState(
    val showLoader: Boolean = false,
    val email: String = "dummy@email.com",
    val greetings: String = "Good Morning",
    val movies: List<Movie> = emptyList(),
    val gridItems: List<GridItem> = listOf(
        GridItem("asdfasdf"),
        GridItem("erfsc"),
        GridItem("wefds"),
        GridItem("nvmcwoe"),
    )
)
