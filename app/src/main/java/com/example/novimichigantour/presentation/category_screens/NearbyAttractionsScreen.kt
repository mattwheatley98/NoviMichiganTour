package com.example.novimichigantour.presentation.category_screens

import androidx.compose.runtime.Composable
import com.example.novimichigantour.data.Recommendations.recommendationsNearbyAttractions
import com.example.novimichigantour.domain.model.Entry
import com.example.novimichigantour.presentation.NoviUiState
import com.example.novimichigantour.presentation.utils.NoviMichiganTourNavigationType
import com.example.novimichigantour.presentation.utils.SelectionType

@Composable
fun NearbyAttractionsScreen(
    onCardClicked: ((Entry) -> Unit),
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: (SelectionType) -> Unit
) {
    BaseScreen(
        collection = recommendationsNearbyAttractions,
        onCardClicked = onCardClicked,
        navigationType = navigationType,
        noviUiState = noviUiState,
        onTabPressed = onTabPressed
    )
}



