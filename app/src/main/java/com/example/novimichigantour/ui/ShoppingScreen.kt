package com.example.novimichigantour.ui

import androidx.compose.runtime.Composable
import com.example.novimichigantour.data.Recommendations.recommendationsShopping
import com.example.novimichigantour.data.SelectionType
import com.example.novimichigantour.ui.utils.NoviMichiganTourNavigationType

@Composable
fun ShoppingScreen(
    onCardClicked: () -> Unit,
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: (SelectionType) -> Unit
) {
    BaseScreen(
        collection = recommendationsShopping,
        onCardClicked = onCardClicked,
        navigationType = navigationType,
        noviUiState = noviUiState,
        onTabPressed = onTabPressed
    )
}

@Composable
fun NoviTownCenterScreen() {
    RecommendedPlaceScreen(entry = recommendationsShopping[0])
}

@Composable
fun OneWorldMarketScreen() {
    RecommendedPlaceScreen(entry = recommendationsShopping[1])
}

@Composable
fun TwelveMileCrossingScreen() {
    RecommendedPlaceScreen(entry = recommendationsShopping[2])
}

@Composable
fun TwelveOaksMallScreen() {
    RecommendedPlaceScreen(entry = recommendationsShopping[3])
}

@Composable
fun WestMarketSquareScreen() {
    RecommendedPlaceScreen(entry = recommendationsShopping[4])
}

@Composable
fun WestOaksShoppingCenterScreen() {
    RecommendedPlaceScreen(entry = recommendationsShopping[5])
}