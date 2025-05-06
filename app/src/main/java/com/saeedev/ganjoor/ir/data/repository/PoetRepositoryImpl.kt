package com.saeedev.ganjoor.ir.data.repository

import com.saeedev.ganjoor.ir.data.local.dataSource.LocalDataSource
import com.saeedev.ganjoor.ir.data.local.entity.PoetEntity
import com.saeedev.ganjoor.ir.data.network.dataSource.NetworkDataSource
import com.saeedev.ganjoor.ir.domain.model.Poet
import com.saeedev.ganjoor.ir.domain.repository.PoetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PoetRepositoryImpl @Inject constructor(
    private val api: NetworkDataSource,
    private val db: LocalDataSource
) : PoetRepository {

    override suspend fun getAllPoets(): Flow<List<Poet>> {
        val poets = api.getPoets()
        db.upsertPoets(poets.map { it.toEntity() })
        return db.getAllPoets().map { it.map(PoetEntity::toDomainModel) }
    }

}