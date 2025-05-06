package com.saeedev.ganjoor.ir.data.network.dto

import com.saeedev.ganjoor.ir.data.local.entity.PoetEntity

data class PoetDto(
    val id: Int,
    val imageUrl: String,
    val name: String,
) {
    fun toEntity() = PoetEntity(
        id = id,
        name = name,
        imgUrl = imageUrl
    )
}