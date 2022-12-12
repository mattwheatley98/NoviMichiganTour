package com.example.novimichigantour.ui

import androidx.lifecycle.ViewModel
import com.example.novimichigantour.model.Entry
import com.example.novimichigantour.model.SelectionType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NoviViewModel: ViewModel() {
    private val _noviUiState = MutableStateFlow(NoviUiState())
    val noviUiState = _noviUiState.asStateFlow()


    //Maybe combine these functions to draw from the same collection?

    fun updateCurrentCardSelection(entry: Entry){
        _noviUiState.update {
            it.copy(
                currentCardSelection = entry.entryRoute
            )
        }
    }

    fun updateCurrentTabSelection(selectionType: SelectionType){
        _noviUiState.update {
            it.copy(
                currentTabSelection = selectionType
            )
        }
    }

    fun backStackEntryNavigation(){

    }

}