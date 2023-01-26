package com.example.novimichigantour.domain.model

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val selectionType: SelectionType,
    val icon: ImageVector,
    val text: Int
)