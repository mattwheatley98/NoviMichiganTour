package com.example.novimichigantour.ui

import androidx.compose.runtime.Composable
import com.example.novimichigantour.data.Recommendations.recommendationsThingsToDo
import com.example.novimichigantour.data.SelectionType
import com.example.novimichigantour.model.Entry
import com.example.novimichigantour.ui.utils.NoviMichiganTourNavigationType

@Composable
fun ThingsToDoScreen(
    onCardClicked: ((Entry) -> Unit),
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: (SelectionType) -> Unit
) {
    BaseScreen(
        collection = recommendationsThingsToDo,
        onCardClicked = onCardClicked,
        navigationType = navigationType,
        noviUiState = noviUiState,
        onTabPressed = onTabPressed
    )
}

@Composable
fun JapaneseFestivalScreen() {
    RecommendedPlaceScreen(entry = recommendationsThingsToDo[0])
}

@Composable
fun LinksOfNoviScreen() {
    RecommendedPlaceScreen(entry = recommendationsThingsToDo[1])
}

@Composable
fun MichiganStateFairScreen() {
    RecommendedPlaceScreen(entry = recommendationsThingsToDo[2])
}

@Composable
fun NoviAthleticClubScreen() {
    RecommendedPlaceScreen(entry = recommendationsThingsToDo[3])
}

@Composable
fun SparcArenaScreen() {
    RecommendedPlaceScreen(entry = recommendationsThingsToDo[4])
}

