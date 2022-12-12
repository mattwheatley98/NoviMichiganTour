package com.example.novimichigantour.ui

import androidx.lifecycle.ViewModel
import com.example.novimichigantour.data.SelectionType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NoviViewModel: ViewModel() {
    private val _noviUiState = MutableStateFlow(NoviUiState())
    val noviUiState = _noviUiState.asStateFlow()

    fun updateCurrentTabSelection(selectionType: SelectionType){
        _noviUiState.update {
            it.copy(
                currentTabSelection = selectionType
            )
        }
    }

    fun resetCurrentSelection(){
        _noviUiState.update {
            it.copy(
                currentTabSelection = SelectionType.Home
            )
        }
    }

}