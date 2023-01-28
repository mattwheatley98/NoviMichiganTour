package com.example.novimichigantour.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import com.example.novimichigantour.R
import com.example.novimichigantour.domain.model.NavigationItem
import com.example.novimichigantour.presentation.utils.SelectionType

object NavigationItemData {
    val navigationItemDataList = listOf(
        NavigationItem(
            SelectionType.Home,
            icon = Icons.Default.Home,
            R.string.home
        ),
        NavigationItem(
            SelectionType.Saved,
            icon = Icons.Default.Favorite,
            R.string.saved
        ),
        NavigationItem(
            SelectionType.Map,
            icon = Icons.Default.Place,
            R.string.map
        ),
    )
}