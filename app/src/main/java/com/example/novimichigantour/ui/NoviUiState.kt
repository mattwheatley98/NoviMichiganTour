package com.example.novimichigantour.ui

import com.example.novimichigantour.data.SelectionType

data class NoviUiState(
    var currentId: String = "",
    val currentCardSelection: String = "",
    val currentTabSelection: SelectionType = SelectionType.Home
)