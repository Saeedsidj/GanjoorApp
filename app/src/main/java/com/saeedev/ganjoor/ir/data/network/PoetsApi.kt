package com.saeedev.ganjoor.ir.data.network

import com.saeedev.ganjoor.ir.data.network.dto.PoetDto
import retrofit2.Response
import retrofit2.http.GET

interface PoetsApi {

    @GET("/api/ganjoor/poets")
    suspend fun getPoetsList(): Response<List<PoetDto>>

}