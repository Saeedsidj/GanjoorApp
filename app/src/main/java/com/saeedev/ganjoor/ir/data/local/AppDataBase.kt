package com.saeedev.ganjoor.ir.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.saeedev.ganjoor.ir.data.local.dao.PoetDao
import com.saeedev.ganjoor.ir.data.local.entity.PoetEntity


@Database(
    entities = [
        PoetEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun poetDao(): PoetDao
}