package com.example.novimichigantour.ui

import androidx.lifecycle.ViewModel
import com.example.novimichigantour.NoviMichiganTourScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NoviViewModel: ViewModel() {
    private val _noviUiState = MutableStateFlow(NoviUiState())
    val noviUiState = _noviUiState.asStateFlow()

    fun updateSelection(
         selectionTest: NoviMichiganTourScreen
    ){
        _noviUiState.update { currentState ->
            currentState.copy(
                selection = selectionTest
            )
        }
    }
}