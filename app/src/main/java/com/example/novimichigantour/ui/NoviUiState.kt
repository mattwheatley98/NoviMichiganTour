package com.example.novimichigantour.ui

import com.example.novimichigantour.data.SelectionType

data class NoviUiState(
    val currentCardSelection: String = "",
    val currentTabSelection: SelectionType = SelectionType.Home
)