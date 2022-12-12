package com.example.novimichigantour.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Star
import com.example.novimichigantour.R
import com.example.novimichigantour.model.SelectionType
import com.example.novimichigantour.ui.NavigationItemContent

object NavigationItemContent {
    val navigationItemContentList = listOf(
        NavigationItemContent(
            SelectionType.Home,
            icon = Icons.Default.Home,
            R.string.home
        ),
        NavigationItemContent(
            SelectionType.Saved,
            icon = Icons.Default.Favorite,
            R.string.saved
        ),
        NavigationItemContent(
            SelectionType.Map,
            icon = Icons.Default.Place,
            R.string.map
        ),
        NavigationItemContent(
            SelectionType.Extras,
            icon = Icons.Default.Star,
            R.string.extras
        )
    )
}