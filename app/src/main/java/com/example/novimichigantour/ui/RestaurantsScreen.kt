package com.example.novimichigantour.ui

import androidx.compose.runtime.Composable
import com.example.novimichigantour.data.Recommendations.recommendationsRestaurants
import com.example.novimichigantour.data.SelectionType
import com.example.novimichigantour.ui.utils.NoviMichiganTourNavigationType

@Composable
fun RestaurantsScreen(
    onCardClicked: () -> Unit,
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
fun ChoppedOliveScreen() {
    RecommendedPlaceScreen(entry = recommendationsRestaurants[0])
}

@Composable
fun FumiScreen() {
    RecommendedPlaceScreen(entry = recommendationsRestaurants[1])
}

@Composable
fun KuraSushiScreen() {
    RecommendedPlaceScreen(entry = recommendationsRestaurants[2])
}

@Composable
fun NagomiJapaneseRestaurantScreen() {
    RecommendedPlaceScreen(entry = recommendationsRestaurants[3])
}

@Composable
fun OSushiScreen() {
    RecommendedPlaceScreen(entry = recommendationsRestaurants[4])
}

@Composable
fun SedonaTaphouseScreen() {
    RecommendedPlaceScreen(entry = recommendationsRestaurants[5])
}

@Composable
fun TheBreakfastClubScreen() {
    RecommendedPlaceScreen(entry = recommendationsRestaurants[6])
}