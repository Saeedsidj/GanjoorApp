package com.saeedev.ganjoor.ir.presentation.poetsList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saeedev.ganjoor.ir.domain.model.Poet
import com.saeedev.ganjoor.ir.domain.useCase.GetVideosListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PoetsListViewModel @Inject constructor(
    private val getAllPoetsUseCase: GetVideosListUseCase,
) : ViewModel() {

    private val _uiState : MutableStateFlow<List<Poet>> = MutableStateFlow(emptyList())
    val uiState : StateFlow<List<Poet>> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            getAllPoetsUseCase().collectLatest { poetList ->
                _uiState.value = poetList
            }
        }
    }

}