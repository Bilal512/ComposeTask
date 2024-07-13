package com.example.composetask.domain.repo

import com.example.composetask.data.network.NetworkResponse
import com.example.composetask.domain.model.Movie

interface DataRepo {

    suspend fun getMovies(): NetworkResponse<List<Movie>>

}