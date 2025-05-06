package com.saeedev.ganjoor.ir.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.saeedev.ganjoor.ir.data.local.entity.PoetEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PoetDao {

    @Query(" SELECT * FROM  poet")
    fun getAllPoets(): Flow<List<PoetEntity>>

    @Upsert
    suspend fun upsertPoet(list: List<PoetEntity>)
}