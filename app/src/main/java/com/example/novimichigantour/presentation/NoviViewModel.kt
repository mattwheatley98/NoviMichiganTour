package com.example.novimichigantour.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.novimichigantour.domain.model.Entry
import com.example.novimichigantour.presentation.utils.SelectionType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NoviViewModel : ViewModel() {
    private val _noviUiState = MutableStateFlow(NoviUiState())
    val noviUiState = _noviUiState.asStateFlow()

    private val _savedRecommendations =
        mutableStateListOf<Entry>() //Must use mutableStateList to make the mutable list observable
    val savedRecommendations: List<Entry> = _savedRecommendations

    fun updateSelectedTab(selectionType: SelectionType) {
        _noviUiState.value.currentTabSelection = selectionType
    }

    fun addSavedEntry(entry: Entry) {
        _noviUiState.value.savedRecommendations.add(entry)
        _savedRecommendations.add(entry)
    }

    fun removeSavedEntry(entry: Entry) {
        _savedRecommendations.remove(entry)
    }

    fun resetAllEntries() {
        _savedRecommendations.clear()
    }

    fun updateParksCheckbox(currentBoolean: Boolean) {
        _noviUiState.update { it.copy(parksCheckbox = !currentBoolean) }
    }

    fun updateShoppingCheckbox(currentBoolean: Boolean) {
        _noviUiState.update { it.copy(shoppingCheckbox = !currentBoolean) }
    }

    fun updateRestaurantsCheckbox(currentBoolean: Boolean) {
        _noviUiState.update { it.copy(restaurantsCheckbox = !currentBoolean) }
    }

    fun updateThingsToDoCheckbox(currentBoolean: Boolean) {
        _noviUiState.update { it.copy(thingsToDoCheckbox = !currentBoolean) }
    }

    fun updateNearbyAttractionsCheckbox(currentBoolean: Boolean) {
        _noviUiState.update { it.copy(nearbyAttractionsCheckbox = !currentBoolean) }
    }

    fun updateDetroitCheckbox(currentBoolean: Boolean) {
        _noviUiState.update { it.copy(detroitCheckbox = !currentBoolean) }
    }

    fun updateAnnArborCheckbox(currentBoolean: Boolean) {
        _noviUiState.update { it.copy(annArborCheckbox = !currentBoolean) }
    }

    fun updateMichiganVacationsCheckbox(currentBoolean: Boolean) {
        _noviUiState.update { it.copy(michiganVacationsCheckbox = !currentBoolean) }
    }

    fun updateSavedCheckbox(currentBoolean: Boolean) {
        _noviUiState.update { it.copy(savedCheckbox = !currentBoolean) }
    }
}