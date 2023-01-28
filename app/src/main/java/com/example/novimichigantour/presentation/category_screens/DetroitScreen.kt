package com.example.novimichigantour.presentation.category_screens

import androidx.compose.runtime.Composable
import com.example.novimichigantour.data.Recommendations.recommendationsDetroit
import com.example.novimichigantour.domain.model.Entry
import com.example.novimichigantour.presentation.NoviUiState
import com.example.novimichigantour.presentation.utils.SelectionType
import com.example.novimichigantour.ui.utils.NoviMichiganTourNavigationType

@Composable
fun DetroitScreen(
    onCardClicked: ((Entry) -> Unit),
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: (SelectionType) -> Unit
) {
    BaseScreen(
        collection = recommendationsDetroit,
        onCardClicked = onCardClicked,
        navigationType = navigationType,
        noviUiState = noviUiState,
        onTabPressed = onTabPressed
    )
}



