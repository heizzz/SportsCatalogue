package com.example.core.data.source.remote.network

import com.example.core.data.source.remote.response.ListSportResponse
import retrofit2.http.GET

interface ApiService {
    @GET(".")
    suspend fun getList(): ListSportResponse
}
