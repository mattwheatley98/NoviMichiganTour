package com.example.novimichigantour.ui

import com.example.novimichigantour.model.Entry
import com.example.novimichigantour.model.SelectionType

data class NoviUiState(
    val currentCardSelection: String = "",
    val currentTabSelection: SelectionType = SelectionType.Home,
    val parksCheckbox: Boolean = false,
    val shoppingCheckbox: Boolean = false,
    val restaurantsCheckbox: Boolean = false,
    val thingsToDoCheckbox: Boolean = false,
    val nearbyAttractionsCheckbox: Boolean = false,
    val detroitCheckbox: Boolean = false,
    val annArborCheckbox: Boolean = false,
    val michiganVacationsCheckbox: Boolean = false,
    val savedCheckbox: Boolean = false,
    val savedRecommendations: MutableList<Entry> = mutableListOf(

    )
)