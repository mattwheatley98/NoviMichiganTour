package com.example.novimichigantour.ui

import androidx.compose.runtime.Composable
import com.example.novimichigantour.data.Categories.categoryData

@Composable
fun CategoriesScreen(onCardClicked: () -> Unit) {
    BaseScreen(
        collection = categoryData, onCardClicked)
}



