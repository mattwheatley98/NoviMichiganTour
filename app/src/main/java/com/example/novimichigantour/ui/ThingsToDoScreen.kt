package com.example.novimichigantour.ui

import androidx.compose.runtime.Composable
import com.example.novimichigantour.data.Recommendations.recommendationsThingsToDo

@Composable
fun ThingsToDoScreen(onCardClicked: () -> Unit) {
    BaseScreen(collection = recommendationsThingsToDo, onCardClicked)
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

