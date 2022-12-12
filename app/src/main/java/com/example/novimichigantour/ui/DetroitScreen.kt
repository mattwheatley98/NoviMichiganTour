package com.example.novimichigantour.ui

import androidx.compose.runtime.Composable
import com.example.novimichigantour.data.Recommendations.recommendationsDetroit
import com.example.novimichigantour.data.SelectionType
import com.example.novimichigantour.model.Entry
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

@Composable
fun BelleIsleParkScreen() {
    RecommendedPlaceScreen(entry = recommendationsDetroit[0])
}

@Composable
fun DetroitInstituteOfArtsScreen() {
    RecommendedPlaceScreen(entry = recommendationsDetroit[1])
}

@Composable
fun DetroitRiverfrontScreen() {
    RecommendedPlaceScreen(entry = recommendationsDetroit[2])
}

@Composable
fun EasternMarketScreen() {
    RecommendedPlaceScreen(entry = recommendationsDetroit[3])
}

@Composable
fun MotownMuseumScreen() {
    RecommendedPlaceScreen(entry = recommendationsDetroit[4])
}

@Composable
fun TheGuardianBuildingScreen() {
    RecommendedPlaceScreen(entry = recommendationsDetroit[5])
}


