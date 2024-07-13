package com.example.composetask.data.api

import com.example.composetask.data.network.model.MovieDTO
import retrofit2.Response
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface ApiInterface {

    @GET("todos")
    suspend fun getUserData(): Response<String>

    @GET("api/v1/movies")
    suspend fun getMovies(): List<MovieDTO>
}