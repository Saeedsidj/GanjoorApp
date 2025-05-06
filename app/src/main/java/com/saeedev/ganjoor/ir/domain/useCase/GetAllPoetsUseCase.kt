package com.saeedev.ganjoor.ir.domain.useCase

import com.saeedev.ganjoor.ir.domain.model.Poet
import com.saeedev.ganjoor.ir.domain.repository.PoetRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetVideosListUseCase @Inject constructor(
    private val repository: PoetRepository
) {
    suspend operator fun invoke(): Flow<List<Poet>>{
        return repository.getAllPoets()
    }
}