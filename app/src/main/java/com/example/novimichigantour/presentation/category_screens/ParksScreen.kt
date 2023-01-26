package com.example.novimichigantour.presentation

import androidx.compose.runtime.Composable
import com.example.novimichigantour.data.Recommendations.recommendationsParks
import com.example.novimichigantour.domain.model.Entry
import com.example.novimichigantour.domain.model.SelectionType
import com.example.novimichigantour.presentation.category_screens.BaseScreen
import com.example.novimichigantour.ui.utils.NoviMichiganTourNavigationType

@Composable
fun ParksScreen(
    onCardClicked: ((Entry) -> Unit),
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: (SelectionType) -> Unit
) {
    BaseScreen(
        collection = recommendationsParks,
        onCardClicked = onCardClicked,
        navigationType = navigationType,
        noviUiState = noviUiState,
        onTabPressed = onTabPressed
    )
}


