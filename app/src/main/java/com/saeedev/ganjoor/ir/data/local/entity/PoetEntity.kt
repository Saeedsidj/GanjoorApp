package com.saeedev.ganjoor.ir.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.saeedev.ganjoor.ir.domain.model.Poet

@Entity(tableName = "poet")
class PoetEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val imgUrl: String
) {
    fun toDomainModel() = Poet(
        name = name,
        imgUrl = imgUrl
    )
}