package com.saeedev.ganjoor.ir.presentation.poetsList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saeedev.ganjoor.ir.common.onFailure
import com.saeedev.ganjoor.ir.common.onSuccess
import com.saeedev.ganjoor.ir.domain.model.Poet
import com.saeedev.ganjoor.ir.domain.useCase.GetVideosListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PoetsListViewModel @Inject constructor(
    private val getAllPoetsUseCase: GetVideosListUseCase,
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    init {
        initialUiState()
    }

    fun initialUiState() {
        viewModelScope.launch {
            getAllPoetsUseCase()
                .onSuccess { poetsList ->
                    _uiState.value = UiState.Success(poetsList)
                }.onFailure {
                    _uiState.value = UiState.Failure
                }
        }
    }

}

sealed class UiState {
    data class Success(
        val poetsList: List<Poet>
    ) : UiState()

    object Loading : UiState()

    object Failure : UiState()
}