package com.example.novimichigantour.ui

import androidx.compose.runtime.Composable
import com.example.novimichigantour.data.Recommendations.recommendationsParks
import com.example.novimichigantour.model.Entry
import com.example.novimichigantour.model.SelectionType
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

@Composable
fun BoscoFieldsScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsParks[0],
        navigationType,
        noviUiState,
        onTabPressed
    )
}

@Composable
fun FuerstParkScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsParks[1],
        navigationType,
        noviUiState,
        onTabPressed
    )
}

@Composable
fun ItcCorridorTrailScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsParks[2],
        navigationType,
        noviUiState,
        onTabPressed
    )
}

@Composable
fun PavilionShoreParkScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsParks[3],
        navigationType,
        noviUiState,
        onTabPressed
    )
}

@Composable
fun RotaryParkScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsParks[4],
        navigationType,
        noviUiState,
        onTabPressed
    )
}

@Composable
fun WildlifeWoodsParkScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsParks[5],
        navigationType,
        noviUiState,
        onTabPressed
    )
}

