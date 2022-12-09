package com.example.novimichigantour.ui

import androidx.compose.runtime.Composable
import com.example.novimichigantour.data.Recommendations.recommendationsDetroit

@Composable
fun DetroitScreen(onCardClicked: () -> Unit) {
    BaseScreen(collection = recommendationsDetroit, onCardClicked)
}

@Composable
fun BelleIsleParkScreen() {
    RecommendedPlaceScreen(entry = recommendationsDetroit[0])
}

@Composable
fun DetroitInstituteOfArtsScreen() {
    RecommendedPlaceScreen(entry = recommendationsDetroit[1])
}

@Composable
fun DetroitRiverfrontScreen() {
    RecommendedPlaceScreen(entry = recommendationsDetroit[2])
}

@Composable
fun EasternMarketScreen() {
    RecommendedPlaceScreen(entry = recommendationsDetroit[3])
}

@Composable
fun MotownMuseumScreen() {
    RecommendedPlaceScreen(entry = recommendationsDetroit[4])
}

@Composable
fun TheGuardianBuildingScreen() {
    RecommendedPlaceScreen(entry = recommendationsDetroit[5])
}


