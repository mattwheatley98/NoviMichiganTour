package com.example.novimichigantour.ui

import com.example.novimichigantour.data.SelectionType

data class NoviUiState(
    var currentId: String = "",
    val currentTabSelection: SelectionType = SelectionType.Home
)