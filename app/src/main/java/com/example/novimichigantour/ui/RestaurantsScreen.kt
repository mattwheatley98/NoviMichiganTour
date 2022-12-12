package com.example.novimichigantour.ui

import androidx.compose.runtime.Composable
import com.example.novimichigantour.data.Recommendations.recommendationsRestaurants
import com.example.novimichigantour.model.Entry
import com.example.novimichigantour.model.SelectionType
import com.example.novimichigantour.ui.utils.NoviMichiganTourNavigationType

@Composable
fun RestaurantsScreen(
    onCardClicked: ((Entry) -> Unit),
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: (SelectionType) -> Unit
) {
    BaseScreen(
        collection = recommendationsRestaurants,
        onCardClicked = onCardClicked,
        navigationType = navigationType,
        noviUiState = noviUiState,
        onTabPressed = onTabPressed
    )

}

@Composable
fun ChoppedOliveScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsRestaurants[0],
        navigationType,
        noviUiState,
        onTabPressed
    )
}

@Composable
fun FumiScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsRestaurants[1],
        navigationType,
        noviUiState,
        onTabPressed
    )
}

@Composable
fun KuraSushiScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsRestaurants[2],
        navigationType,
        noviUiState,
        onTabPressed
    )
}

@Composable
fun NagomiJapaneseRestaurantScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsRestaurants[3],
        navigationType,
        noviUiState,
        onTabPressed
    )
}

@Composable
fun OSushiScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsRestaurants[4],
        navigationType,
        noviUiState,
        onTabPressed
    )
}

@Composable
fun SedonaTaphouseScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsRestaurants[5],
        navigationType,
        noviUiState,
        onTabPressed
    )
}

@Composable
fun TheBreakfastClubScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit)
) {
    RecommendedPlaceScreen(
        entry = recommendationsRestaurants[6],
        navigationType,
        noviUiState,
        onTabPressed
    )
}