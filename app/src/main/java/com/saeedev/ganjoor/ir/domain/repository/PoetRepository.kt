package com.saeedev.ganjoor.ir.domain.repository

import com.saeedev.ganjoor.ir.domain.model.Poet
import kotlinx.coroutines.flow.Flow

interface PoetRepository {

   suspend fun getAllPoets(): Flow<List<Poet>>
}