package com.example.novimichigantour.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.novimichigantour.data.Categories.categoryData
import com.example.novimichigantour.ui.theme.NoviMichiganTourTheme

@Composable
fun CategoriesScreen(
    onCardClicked: () -> Unit,
) {
    BaseScreen(
        collection = categoryData, onCardClicked)
}



