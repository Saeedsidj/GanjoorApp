package com.saeedev.ganjoor.ir.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.saeedev.ganjoor.ir.data.local.entity.PoetEntity

@Dao
interface PoetDao {

    @Query(" SELECT * FROM  poet")
    suspend fun getAllPoets(): List<PoetEntity>

    @Upsert
    suspend fun upsertPoet(list: List<PoetEntity>)
}