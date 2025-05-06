package com.saeedev.ganjoor.ir.data.local.dataSource

import com.saeedev.ganjoor.ir.data.local.AppDataBase
import com.saeedev.ganjoor.ir.data.local.entity.PoetEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val db: AppDataBase
) : LocalDataSource {

    override fun getAllPoets(): Flow<List<PoetEntity>> {
        return db.poetDao().getAllPoets()
    }

    override suspend fun upsertPoets(poets : List<PoetEntity>) {
        db.poetDao().upsertPoet(poets)
    }
}