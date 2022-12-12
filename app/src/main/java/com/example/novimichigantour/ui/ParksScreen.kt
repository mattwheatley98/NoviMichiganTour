package com.example.novimichigantour.ui

import androidx.compose.runtime.Composable
import com.example.novimichigantour.data.Recommendations.recommendationsParks
import com.example.novimichigantour.data.SelectionType
import com.example.novimichigantour.ui.utils.NoviMichiganTourNavigationType

@Composable
fun ParksScreen(
    onCardClicked: () -> Unit,
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
fun BoscoFieldsScreen() {
    RecommendedPlaceScreen(entry = recommendationsParks[0])
}

@Composable
fun FuerstParkScreen() {
    RecommendedPlaceScreen(entry = recommendationsParks[1])
}

@Composable
fun ItcCorridorTrailScreen() {
    RecommendedPlaceScreen(entry = recommendationsParks[2])
}

@Composable
fun PavilionShoreParkScreen() {
    RecommendedPlaceScreen(entry = recommendationsParks[3])
}

@Composable
fun RotaryParkScreen() {
    RecommendedPlaceScreen(entry = recommendationsParks[4])
}

@Composable
fun WildlifeWoodsParkScreen() {
    RecommendedPlaceScreen(entry = recommendationsParks[5])
}

