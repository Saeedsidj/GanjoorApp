package com.saeedev.ganjoor.ir.data.network.dataSource

import com.saeedev.ganjoor.ir.data.network.PoetsApi
import com.saeedev.ganjoor.ir.data.network.dto.PoetDto
import javax.inject.Inject

class NetworkDataSourceImpl @Inject constructor(
    private val api: PoetsApi
) : NetworkDataSource {

    override suspend fun getPoets(): List<PoetDto> {
        return api.getPoetsList()
    }

}