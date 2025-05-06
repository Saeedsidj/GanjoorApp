package com.saeedev.ganjoor.ir.data.network.dataSource

import com.saeedev.ganjoor.ir.data.network.PoetsApi
import com.saeedev.ganjoor.ir.data.network.dto.PoetDto
import retrofit2.Response
import javax.inject.Inject

class NetworkDataSourceImpl @Inject constructor(
    private val api: PoetsApi
) : NetworkDataSource {

    override suspend fun getPoets(): Response<List<PoetDto>> {
        return api.getPoetsList()
    }

}