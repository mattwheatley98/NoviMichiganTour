package com.example.novimichigantour.ui

import androidx.compose.runtime.Composable
import com.example.novimichigantour.data.Recommendations.recommendationsNearbyAttractions
import com.example.novimichigantour.model.Entry
import com.example.novimichigantour.model.SelectionType
import com.example.novimichigantour.ui.utils.NoviMichiganTourNavigationType

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

@Composable
fun DowntownBrightonScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsNearbyAttractions[0],
        navigationType,
        noviUiState,
        onTabPressed
    )
}

@Composable
fun DowntownNorthvilleScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsNearbyAttractions[1],
        navigationType,
        noviUiState,
        onTabPressed
    )
}

@Composable
fun DowntownPlymouthScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsNearbyAttractions[2],
        navigationType,
        noviUiState,
        onTabPressed
    )
}

@Composable
fun HinesParkScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsNearbyAttractions[3],
        navigationType,
        noviUiState,
        onTabPressed
    )
}

@Composable
fun KensingtonMetroparkScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsNearbyAttractions[4],
        navigationType,
        noviUiState,
        onTabPressed
    )
}

@Composable
fun MayburyParkScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsNearbyAttractions[5],
        navigationType,
        noviUiState,
        onTabPressed
    )
}

@Composable
fun SomersetCollectionScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsNearbyAttractions[6],
        navigationType,
        noviUiState,
        onTabPressed
    )
}



