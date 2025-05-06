package com.saeedev.ganjoor.ir.data.network

import com.saeedev.ganjoor.ir.data.network.dto.PoetDto
import retrofit2.http.GET
import retrofit2.http.Headers

interface PoetsApi {

    @Headers("Content-Type: application/json")
    @GET("/api/ganjoor/poets")
    suspend fun getPoetsList() : List<PoetDto>

}