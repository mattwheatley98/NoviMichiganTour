package com.example.novimichigantour.domain.model

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.novimichigantour.presentation.utils.SelectionType

data class NavigationItem(
    val selectionType: SelectionType,
    val icon: ImageVector,
    val text: Int
)