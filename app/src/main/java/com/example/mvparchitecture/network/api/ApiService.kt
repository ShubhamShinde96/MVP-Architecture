package com.example.mvparchitecture.network.api

import com.example.mvparchitecture.network.model.University
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/search")
    suspend fun getUniversity(
        @Query("country") country: String
    ): Response<List<University>>

}