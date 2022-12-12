package com.example.novimichigantour.ui

import androidx.compose.runtime.Composable
import com.example.novimichigantour.data.Recommendations.recommendationsShopping
import com.example.novimichigantour.model.Entry
import com.example.novimichigantour.model.SelectionType
import com.example.novimichigantour.ui.utils.NoviMichiganTourNavigationType

@Composable
fun ShoppingScreen(
    onCardClicked: ((Entry) -> Unit),
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
fun NoviTownCenterScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsShopping[0],
        navigationType,
        noviUiState,
        onTabPressed
    )
}

@Composable
fun OneWorldMarketScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsShopping[1],
        navigationType,
        noviUiState,
        onTabPressed
    )
}

@Composable
fun TwelveMileCrossingScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsShopping[2],
        navigationType,
        noviUiState,
        onTabPressed
    )
}

@Composable
fun TwelveOaksMallScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsShopping[3],
        navigationType,
        noviUiState,
        onTabPressed
    )
}

@Composable
fun WestMarketSquareScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsShopping[4],
        navigationType,
        noviUiState,
        onTabPressed
    )
}

@Composable
fun WestOaksShoppingCenterScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsShopping[5],
        navigationType,
        noviUiState,
        onTabPressed
    )
}