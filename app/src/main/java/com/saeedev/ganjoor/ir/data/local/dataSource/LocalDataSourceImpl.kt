package com.saeedev.ganjoor.ir.data.local.dataSource

import com.saeedev.ganjoor.ir.data.local.AppDataBase
import com.saeedev.ganjoor.ir.data.local.entity.PoetEntity
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val db: AppDataBase
) : LocalDataSource {

    override suspend fun getAllPoets(): List<PoetEntity> {
        return db.poetDao().getAllPoets()
    }

    override suspend fun upsertPoets(poets: List<PoetEntity>) {
        db.poetDao().upsertPoet(poets)
    }
}