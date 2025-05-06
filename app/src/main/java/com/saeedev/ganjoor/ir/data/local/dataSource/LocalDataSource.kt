package com.saeedev.ganjoor.ir.data.local.dataSource

import com.saeedev.ganjoor.ir.data.local.entity.PoetEntity

interface LocalDataSource {

    suspend fun getAllPoets(): List<PoetEntity>

    suspend fun upsertPoets(poets: List<PoetEntity>)
}