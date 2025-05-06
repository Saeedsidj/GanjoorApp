package com.saeedev.ganjoor.ir.data.network.dataSource

import com.saeedev.ganjoor.ir.data.network.dto.PoetDto
import retrofit2.Response

interface NetworkDataSource {

    suspend fun getPoets() : Response<List<PoetDto>>

}