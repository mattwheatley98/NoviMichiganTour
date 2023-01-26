package com.example.novimichigantour.presentation

import androidx.lifecycle.ViewModel
import com.example.novimichigantour.domain.model.Entry
import com.example.novimichigantour.domain.model.SelectionType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NoviViewModel : ViewModel() {
    private val _noviUiState = MutableStateFlow(NoviUiState())
    val noviUiState = _noviUiState.asStateFlow()

    //Maybe combine these functions to draw from the same collection?

    fun updateCurrentCardSelection(entry: Entry) {
        _noviUiState.update { it.copy(currentCardSelection = entry.entryRoute) }
    }

    fun updateCurrentTabSelection(selectionType: SelectionType) {
        _noviUiState.update { it.copy(currentTabSelection = selectionType) }
    }

    fun addSavedEntry(entry: Entry) {
        _noviUiState.value.savedRecommendations.add(entry)
    }

    fun removeSavedEntry(entry: Entry) {
        _noviUiState.value.savedRecommendations.remove(entry)
    }

    fun resetAllEntries() {
        _noviUiState.value.savedRecommendations.clear()
    }

    fun updateParksCheckbox(
        currentBoolean: Boolean
    ) {
        _noviUiState.update {
            it.copy(
                parksCheckbox = !currentBoolean
            )
        }
    }

    fun updateShoppingCheckbox(
        currentBoolean: Boolean
    ) {
        _noviUiState.update {
            it.copy(
                shoppingCheckbox = !currentBoolean
            )
        }
    }

    fun updateRestaurantsCheckbox(currentBoolean: Boolean) {
        _noviUiState.update { it.copy(restaurantsCheckbox = !currentBoolean) }
    }

    fun updateThingsToDoCheckbox(
        currentBoolean: Boolean
    ) {
        _noviUiState.update {
            it.copy(
                thingsToDoCheckbox = !currentBoolean
            )
        }
    }

    fun updateNearbyAttractionsCheckbox(
        currentBoolean: Boolean
    ) {
        _noviUiState.update {
            it.copy(
                nearbyAttractionsCheckbox = !currentBoolean
            )
        }
    }

    fun updateDetroitCheckbox(
        currentBoolean: Boolean
    ) {
        _noviUiState.update {
            it.copy(
                detroitCheckbox = !currentBoolean
            )
        }
    }

    fun updateAnnArborCheckbox(
        currentBoolean: Boolean
    ) {
        _noviUiState.update {
            it.copy(
                annArborCheckbox = !currentBoolean
            )
        }
    }

    fun updateMichiganVacationsCheckbox(
        currentBoolean: Boolean
    ) {
        _noviUiState.update {
            it.copy(
                michiganVacationsCheckbox = !currentBoolean
            )
        }
    }

    fun updateSavedCheckbox(
        currentBoolean: Boolean
    ) {
        _noviUiState.update {
            it.copy(
                savedCheckbox = !currentBoolean
            )
        }
    }
}