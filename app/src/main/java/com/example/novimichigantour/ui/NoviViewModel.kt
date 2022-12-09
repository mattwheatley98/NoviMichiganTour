package com.example.novimichigantour.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class NoviViewModel: ViewModel() {
    private val _noviUiState = MutableStateFlow(NoviUiState())
    val noviUiState = _noviUiState.asStateFlow()

}