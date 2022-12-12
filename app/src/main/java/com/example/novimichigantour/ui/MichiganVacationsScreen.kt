package com.example.novimichigantour.ui

import androidx.compose.runtime.Composable
import com.example.novimichigantour.data.Recommendations.recommendationsMichiganVacations
import com.example.novimichigantour.data.SelectionType
import com.example.novimichigantour.model.Entry
import com.example.novimichigantour.ui.utils.NoviMichiganTourNavigationType

@Composable
fun MichiganVacationsScreen(
    onCardClicked: ((Entry) -> Unit),
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: (SelectionType) -> Unit
) {
    BaseScreen(
        collection = recommendationsMichiganVacations,
        onCardClicked = onCardClicked,
        navigationType = navigationType,
        noviUiState = noviUiState,
        onTabPressed = onTabPressed
    )
}

@Composable
fun HollandScreen() {
    RecommendedPlaceScreen(entry = recommendationsMichiganVacations[0])
}

@Composable
fun IsleRoyaleNationalParkScreen() {
    RecommendedPlaceScreen(entry = recommendationsMichiganVacations[1])
}

@Composable
fun MackinacIslandScreen() {
    RecommendedPlaceScreen(entry = recommendationsMichiganVacations[2])
}

@Composable
fun MarquetteScreen() {
    RecommendedPlaceScreen(entry = recommendationsMichiganVacations[3])
}

@Composable
fun MunisingScreen() {
    RecommendedPlaceScreen(entry = recommendationsMichiganVacations[4])
}

@Composable
fun TraverseCityScreen() {
    RecommendedPlaceScreen(entry = recommendationsMichiganVacations[5])
}