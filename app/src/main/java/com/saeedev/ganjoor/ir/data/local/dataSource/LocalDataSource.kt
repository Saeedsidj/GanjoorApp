package com.saeedev.ganjoor.ir.data.local.dataSource

import com.saeedev.ganjoor.ir.data.local.entity.PoetEntity
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun getAllPoets(): Flow<List<PoetEntity>>

    suspend fun upsertPoets(poets : List<PoetEntity>)
}