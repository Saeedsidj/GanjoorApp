package com.saeedev.ganjoor.ir.domain.repository

import com.saeedev.ganjoor.ir.common.Result
import com.saeedev.ganjoor.ir.domain.model.Poet

interface PoetRepository {

    suspend fun getAllPoets(): Result<List<Poet>>

    suspend fun fetchDataFromApi() : Boolean
}