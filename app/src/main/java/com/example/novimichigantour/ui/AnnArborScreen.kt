package com.example.novimichigantour.ui

import androidx.compose.runtime.Composable
import com.example.novimichigantour.data.Recommendations.recommendationsAnnArbor

@Composable
fun AnnArborScreen(onCardClicked: () -> Unit) {
    BaseScreen(collection = recommendationsAnnArbor, onCardClicked)
}

@Composable
fun AnnArborHandsOnMuseumScreen() {
    RecommendedPlaceScreen(entry = recommendationsAnnArbor[0])
}

@Composable
fun HudsonMillsMetroparkScreen() {
    RecommendedPlaceScreen(entry = recommendationsAnnArbor[1])
}

@Composable
fun KerrytownScreen() {
    RecommendedPlaceScreen(entry = recommendationsAnnArbor[2])
}

@Composable
fun MainStreetScreen() {
    RecommendedPlaceScreen(entry = recommendationsAnnArbor[3])
}

@Composable
fun MichiganTheaterScreen() {
    RecommendedPlaceScreen(entry = recommendationsAnnArbor[4])
}

@Composable
fun UniversityOfMichiganScreen() {
    RecommendedPlaceScreen(entry = recommendationsAnnArbor[5])
}

