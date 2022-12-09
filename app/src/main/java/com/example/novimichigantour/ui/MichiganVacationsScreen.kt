package com.example.novimichigantour.ui

import androidx.compose.runtime.Composable
import com.example.novimichigantour.data.Recommendations.recommendationsMichiganVacations

@Composable
fun MichiganVacationsScreen(onCardClicked: () -> Unit) {
    BaseScreen(collection = recommendationsMichiganVacations, onCardClicked)
}

@Composable
fun HollandScreen() {
    RecommendedPlaceScreen(entry = recommendationsMichiganVacations[0])
}

@Composable
fun IsleRoyaleNationalParkScreen() {
    RecommendedPlaceScreen(entry = recommendationsMichiganVacations[1])
}

@Composable
fun MackinacIslandScreen() {
    RecommendedPlaceScreen(entry = recommendationsMichiganVacations[2])
}

@Composable
fun MarquetteScreen() {
    RecommendedPlaceScreen(entry = recommendationsMichiganVacations[3])
}

@Composable
fun MunisingScreen() {
    RecommendedPlaceScreen(entry = recommendationsMichiganVacations[4])
}

@Composable
fun TraverseCityScreen() {
    RecommendedPlaceScreen(entry = recommendationsMichiganVacations[5])
}