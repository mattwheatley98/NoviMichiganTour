package com.example.novimichigantour.presentation.category_screens

import androidx.compose.runtime.Composable
import com.example.novimichigantour.data.Recommendations.recommendationsParks
import com.example.novimichigantour.domain.model.Entry
import com.example.novimichigantour.presentation.NoviUiState
import com.example.novimichigantour.presentation.utils.NoviMichiganTourNavigationType
import com.example.novimichigantour.presentation.utils.SelectionType

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


