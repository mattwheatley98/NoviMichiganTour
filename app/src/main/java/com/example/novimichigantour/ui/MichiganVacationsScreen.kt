package com.example.novimichigantour.ui

import androidx.compose.runtime.Composable
import com.example.novimichigantour.data.Recommendations.recommendationsMichiganVacations
import com.example.novimichigantour.model.Entry
import com.example.novimichigantour.model.SelectionType
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
fun HollandScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsMichiganVacations[0],
        navigationType,
        noviUiState,
        onTabPressed
    )
}

@Composable
fun IsleRoyaleNationalParkScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsMichiganVacations[1],
        navigationType,
        noviUiState,
        onTabPressed
    )
}

@Composable
fun MackinacIslandScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsMichiganVacations[2],
        navigationType,
        noviUiState,
        onTabPressed
    )
}

@Composable
fun MarquetteScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsMichiganVacations[3],
        navigationType,
        noviUiState,
        onTabPressed
    )
}

@Composable
fun MunisingScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsMichiganVacations[4],
        navigationType,
        noviUiState,
        onTabPressed
    )
}

@Composable
fun TraverseCityScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsMichiganVacations[5],
        navigationType,
        noviUiState,
        onTabPressed
    )
}