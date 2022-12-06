package com.example.novimichigantour

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.novimichigantour.ui.CategoriesScreen
import com.example.novimichigantour.ui.NoviViewModel
import com.example.novimichigantour.ui.RecommendationsParks

enum class NoviMichiganTourScreen {
    Categories,
    Parks,
    Shopping,
    Restaurants,
    ThingsToDo,
    NearbyAttractions,
    Detroit,
    AnnArbor,
    MichiganVacations,

    Recommendations,
    RecommendedPlace
}


@Composable
fun NoviMichiganAppBar() {
    TopAppBar(backgroundColor = MaterialTheme.colors.primary) {

    }
}

@Composable
fun NoviMichiganTourApp() {

    val navController = rememberNavController()
    val viewModel: NoviViewModel = viewModel()

    Scaffold(topBar = { NoviMichiganAppBar() }) { innerPadding ->
        val uiState by viewModel.noviUiState.collectAsState()


        NavHost(
            navController = navController,
            startDestination = NoviMichiganTourScreen.Categories.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = NoviMichiganTourScreen.Categories.name) {
                CategoriesScreen(
                    onCardClicked = { navController.navigate(NoviMichiganTourScreen.Parks.name) }
                )
            }
            composable(route = NoviMichiganTourScreen.Parks.name) {
                RecommendationsParks(

                )
            }
        }

    }
}