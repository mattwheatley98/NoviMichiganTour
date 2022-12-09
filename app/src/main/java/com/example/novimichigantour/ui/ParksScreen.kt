package com.example.novimichigantour.ui

import androidx.compose.runtime.Composable
import com.example.novimichigantour.data.Recommendations.recommendationsParks

@Composable
fun ParksScreen(onCardClicked: () -> Unit) {
    BaseScreen(collection = recommendationsParks, onCardClicked)
}

@Composable
fun BoscoFieldsScreen() {
    RecommendedPlaceScreen(entry = recommendationsParks[0])
}

@Composable
fun FuerstParkScreen() {
    RecommendedPlaceScreen(entry = recommendationsParks[1])
}

@Composable
fun ItcCorridorTrailScreen() {
    RecommendedPlaceScreen(entry = recommendationsParks[2])
}

@Composable
fun PavilionShoreParkScreen() {
    RecommendedPlaceScreen(entry = recommendationsParks[3])
}

@Composable
fun RotaryParkScreen() {
    RecommendedPlaceScreen(entry = recommendationsParks[4])
}

@Composable
fun WildlifeWoodsParkScreen() {
    RecommendedPlaceScreen(entry = recommendationsParks[5])
}

