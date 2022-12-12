package com.example.novimichigantour.ui

import androidx.compose.runtime.Composable
import com.example.novimichigantour.data.Recommendations.recommendationsNearbyAttractions
import com.example.novimichigantour.data.SelectionType
import com.example.novimichigantour.ui.utils.NoviMichiganTourNavigationType

@Composable
fun NearbyAttractionsScreen(
    onCardClicked: () -> Unit,
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
fun DowntownBrightonScreen() {
    RecommendedPlaceScreen(entry = recommendationsNearbyAttractions[0])
}

@Composable
fun DowntownNorthvilleScreen() {
    RecommendedPlaceScreen(entry = recommendationsNearbyAttractions[1])
}

@Composable
fun DowntownPlymouthScreen() {
    RecommendedPlaceScreen(entry = recommendationsNearbyAttractions[2])
}

@Composable
fun HinesParkScreen() {
    RecommendedPlaceScreen(entry = recommendationsNearbyAttractions[3])
}

@Composable
fun KensingtonMetroparkScreen() {
    RecommendedPlaceScreen(entry = recommendationsNearbyAttractions[4])
}

@Composable
fun MayburyParkScreen() {
    RecommendedPlaceScreen(entry = recommendationsNearbyAttractions[5])
}

@Composable
fun SomersetCollectionScreen() {
    RecommendedPlaceScreen(entry = recommendationsNearbyAttractions[6])
}



