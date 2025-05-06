package com.saeedev.ganjoor.ir.data.network.dataSource

import com.saeedev.ganjoor.ir.data.network.dto.PoetDto

interface NetworkDataSource {

    suspend fun getPoets() : List<PoetDto>

}