package com.saeedev.ganjoor.ir.data.repository

import com.saeedev.ganjoor.ir.common.Result
import com.saeedev.ganjoor.ir.common.onSuccess
import com.saeedev.ganjoor.ir.common.safeApi
import com.saeedev.ganjoor.ir.data.local.dataSource.LocalDataSource
import com.saeedev.ganjoor.ir.data.local.entity.PoetEntity
import com.saeedev.ganjoor.ir.data.network.dataSource.NetworkDataSource
import com.saeedev.ganjoor.ir.data.network.dto.PoetDto
import com.saeedev.ganjoor.ir.domain.model.Poet
import com.saeedev.ganjoor.ir.domain.repository.PoetRepository
import okio.IOException
import javax.inject.Inject

class PoetRepositoryImpl @Inject constructor(
    private val api: NetworkDataSource,
    private val db: LocalDataSource
) : PoetRepository {

    override suspend fun getAllPoets(): Result<List<Poet>> {
        val poetsList = db.getAllPoets()
        if (poetsList.isEmpty()) {
            if (!fetchDataFromApi()) {
                return Result.Error(IOException())
            }
        }
        return Result.Success(db.getAllPoets().map(PoetEntity::toDomainModel))
    }

    override suspend fun fetchDataFromApi(): Boolean {
        safeApi(
            response = { api.getPoets() }
        ).onSuccess {
            db.upsertPoets(it.map(PoetDto::toEntity))
            return true
        }
        return false
    }
}