package com.example.composetask.data.repo

import com.example.composetask.data.api.ApiInterface
import com.example.composetask.data.network.NetworkResponse
import com.example.composetask.data.network.model.MovieDTO
import com.example.composetask.domain.model.Movie
import com.example.composetask.domain.model.toDomainModel
import com.example.composetask.domain.repo.DataRepo
import javax.inject.Inject

class DataRepoImpl @Inject constructor(
    private val apiInterface: ApiInterface
) : DataRepo {

    override suspend fun getMovies(): NetworkResponse<List<Movie>> {
        val response = try {
            apiInterface.getMovies()
        } catch (e: Exception) {
            return NetworkResponse.Error("An unknown error occured: ${e.localizedMessage}")
        }

        return NetworkResponse.Success(response.map { it.toDomainModel() })
    }
}