package com.example.novimichigantour.ui

import androidx.compose.runtime.Composable
import com.example.novimichigantour.data.Recommendations.recommendationsShopping

@Composable
fun ShoppingScreen(onCardClicked: () -> Unit) {
    BaseScreen(collection = recommendationsShopping, onCardClicked)
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