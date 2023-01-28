package com.example.novimichigantour.presentation

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.novimichigantour.R
import com.example.novimichigantour.data.Recommendations
import com.example.novimichigantour.presentation.bottom_bar_screens.HomeScreen
import com.example.novimichigantour.presentation.bottom_bar_screens.MapScreen
import com.example.novimichigantour.presentation.bottom_bar_screens.SavedScreen
import com.example.novimichigantour.presentation.category_screens.*
import com.example.novimichigantour.presentation.utils.NoviMichiganTourScreens
import com.example.novimichigantour.ui.utils.NoviMichiganTourNavigationType

@Composable
fun NoviMichiganAppBar(
    @StringRes currentScreenTitle: Int,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
) {
    TopAppBar(
        title = { Text(text = stringResource(currentScreenTitle)) },
        backgroundColor = MaterialTheme.colors.primary,
        navigationIcon = {
            if (canNavigateBack && currentScreenTitle != R.string.saved && currentScreenTitle != R.string.map && currentScreenTitle != R.string.app_name) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@Composable
fun NoviMichiganTourApp(
    windowSize: WindowWidthSizeClass,
) {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = NoviMichiganTourScreens.valueOf(
        backStackEntry?.destination?.route ?: NoviMichiganTourScreens.Home.name
    )
    val viewModel: NoviViewModel = viewModel()
    val navigationType: NoviMichiganTourNavigationType

    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            navigationType = NoviMichiganTourNavigationType.BOTTOM_NAVIGATION
        }
        WindowWidthSizeClass.Medium -> {
            navigationType = NoviMichiganTourNavigationType.NAVIGATION_RAIL
        }
        WindowWidthSizeClass.Expanded -> {
            navigationType = NoviMichiganTourNavigationType.PERMANENT_NAVIGATION_DRAWER
        }
        else -> {
            navigationType = NoviMichiganTourNavigationType.BOTTOM_NAVIGATION
        }
    }

    Scaffold(
        topBar = {
            NoviMichiganAppBar(
                currentScreenTitle = currentScreen.title,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        val noviUiState by viewModel.noviUiState.collectAsState()
        val savedRecommendations = viewModel.savedRecommendations

        NavHost(
            navController = navController,
            startDestination = NoviMichiganTourScreens.Home.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = NoviMichiganTourScreens.Home.name) {
                HomeScreen(
                    onCardClicked = { navController.navigate(it.entryRoute) },
                    navigationType = navigationType,
                    onTabPressed = { navController.navigate(it.toString()) },
                    noviUiState = noviUiState,
                    viewModel = viewModel
                )
            }
            composable(route = NoviMichiganTourScreens.Saved.name) {
                SavedScreen(
                    navigationType = navigationType,
                    noviUiState = noviUiState,
                    onTabPressed = { navController.navigate(it.toString()) },
                    onCardClicked = { navController.navigate(it.entryRoute) },
                    savedCollection = savedRecommendations,
                    resetCollection = { viewModel.resetAllEntries() },
                    viewModel = viewModel
                )
            }
            composable(route = NoviMichiganTourScreens.Map.name) {
                MapScreen(
                    navigationType = navigationType,
                    noviUiState = noviUiState,
                    onTabPressed = { navController.navigate(it.toString()) },
                    parksState = { viewModel.updateParksCheckbox(noviUiState.parksCheckbox) },
                    shoppingState = { viewModel.updateShoppingCheckbox(noviUiState.shoppingCheckbox) },
                    restaurantsState = { viewModel.updateRestaurantsCheckbox(noviUiState.restaurantsCheckbox) },
                    thingsToDoState = { viewModel.updateThingsToDoCheckbox(noviUiState.thingsToDoCheckbox) },
                    nearbyAttractionsState = { viewModel.updateNearbyAttractionsCheckbox(noviUiState.nearbyAttractionsCheckbox) },
                    detroitState = { viewModel.updateDetroitCheckbox(noviUiState.detroitCheckbox) },
                    annArborState = { viewModel.updateAnnArborCheckbox(noviUiState.annArborCheckbox) },
                    michiganVacationsState = { viewModel.updateMichiganVacationsCheckbox(noviUiState.michiganVacationsCheckbox) },
                    savedState = {viewModel.updateSavedCheckbox(noviUiState.savedCheckbox)},
                    viewModel = viewModel
                )
            }
            //Parks
            composable(route = NoviMichiganTourScreens.Parks.name) {
                ParksScreen(
                    onCardClicked = { navController.navigate(it.entryRoute) },
                    navigationType = navigationType,
                    onTabPressed = { navController.navigate(it.toString()) },
                    noviUiState = noviUiState
                )
            }
            for (entry in Recommendations.recommendationsParks) {
                composable(route = entry.entryRoute) {
                    RecommendedPlaceScreen(
                        entry = entry,
                        navigationType = navigationType,
                        noviUiState = noviUiState,
                        onTabPressed = { navController.navigate(it.toString()) },
                        save = { viewModel.addSavedEntry(it) },
                        remove = { viewModel.removeSavedEntry(it) },
                        viewModel = viewModel
                    )
                }
            }
            //Shopping
            composable(route = NoviMichiganTourScreens.Shopping.name) {
                ShoppingScreen(
                    onCardClicked = { navController.navigate(it.entryRoute) },
                    navigationType = navigationType,
                    onTabPressed = { navController.navigate(it.toString()) },
                    noviUiState = noviUiState
                )
            }
            for (entry in Recommendations.recommendationsShopping) {
                composable(route = entry.entryRoute) {
                    RecommendedPlaceScreen(
                        entry = entry,
                        navigationType = navigationType,
                        noviUiState = noviUiState,
                        onTabPressed = { navController.navigate(it.toString()) },
                        save = { viewModel.addSavedEntry(it) },
                        remove = { viewModel.removeSavedEntry(it) },
                        viewModel = viewModel
                    )
                }
            }
            //Restaurants
            composable(route = NoviMichiganTourScreens.Restaurants.name) {
                RestaurantsScreen(
                    onCardClicked = { navController.navigate(it.entryRoute) },
                    navigationType = navigationType,
                    onTabPressed = { navController.navigate(it.toString()) },
                    noviUiState = noviUiState
                )
            }
            for (entry in Recommendations.recommendationsRestaurants) {
                composable(route = entry.entryRoute) {
                    RecommendedPlaceScreen(
                        entry = entry,
                        navigationType = navigationType,
                        noviUiState = noviUiState,
                        onTabPressed = { navController.navigate(it.toString()) },
                        save = { viewModel.addSavedEntry(it) },
                        remove = { viewModel.removeSavedEntry(it) },
                        viewModel = viewModel
                    )
                }
            }
            //Things To Do
            composable(route = NoviMichiganTourScreens.ThingsToDo.name) {
                ThingsToDoScreen(
                    onCardClicked = { navController.navigate(it.entryRoute) },
                    navigationType = navigationType,
                    onTabPressed = { navController.navigate(it.toString()) },
                    noviUiState = noviUiState
                )
            }
            for (entry in Recommendations.recommendationsThingsToDo) {
                composable(route = entry.entryRoute) {
                    RecommendedPlaceScreen(
                        entry = entry,
                        navigationType = navigationType,
                        noviUiState = noviUiState,
                        onTabPressed = { navController.navigate(it.toString()) },
                        save = { viewModel.addSavedEntry(it) },
                        remove = { viewModel.removeSavedEntry(it) },
                        viewModel = viewModel
                    )
                }
            }
            //Nearby Attractions
            composable(route = NoviMichiganTourScreens.NearbyAttractions.name) {
                NearbyAttractionsScreen(
                    onCardClicked = { navController.navigate(it.entryRoute) },
                    navigationType = navigationType,
                    onTabPressed = { navController.navigate(it.toString()) },
                    noviUiState = noviUiState
                )
            }
            for (entry in Recommendations.recommendationsNearbyAttractions) {
                composable(route = entry.entryRoute) {
                    RecommendedPlaceScreen(
                        entry = entry,
                        navigationType = navigationType,
                        noviUiState = noviUiState,
                        onTabPressed = { navController.navigate(it.toString()) },
                        save = { viewModel.addSavedEntry(it) },
                        remove = { viewModel.removeSavedEntry(it) },
                        viewModel = viewModel
                    )
                }
            }
            //Detroit
            composable(route = NoviMichiganTourScreens.Detroit.name) {
                DetroitScreen(
                    onCardClicked = { navController.navigate(it.entryRoute) },
                    navigationType = navigationType,
                    onTabPressed = { navController.navigate(it.toString()) },
                    noviUiState = noviUiState
                )
            }
            for (entry in Recommendations.recommendationsDetroit) {
                composable(route = entry.entryRoute) {
                    RecommendedPlaceScreen(
                        entry = entry,
                        navigationType = navigationType,
                        noviUiState = noviUiState,
                        onTabPressed = { navController.navigate(it.toString()) },
                        save = { viewModel.addSavedEntry(it) },
                        remove = { viewModel.removeSavedEntry(it) },
                        viewModel = viewModel
                    )
                }
            }
            //Ann Arbor
            composable(route = NoviMichiganTourScreens.AnnArbor.name) {
                AnnArborScreen(
                    onCardClicked = { navController.navigate(it.entryRoute) },
                    navigationType = navigationType,
                    onTabPressed = { navController.navigate(it.toString()) },
                    noviUiState = noviUiState
                )
            }
            for (entry in Recommendations.recommendationsAnnArbor) {
                composable(route = entry.entryRoute) {
                    RecommendedPlaceScreen(
                        entry = entry,
                        navigationType = navigationType,
                        noviUiState = noviUiState,
                        onTabPressed = { navController.navigate(it.toString()) },
                        save = { viewModel.addSavedEntry(it) },
                        remove = { viewModel.removeSavedEntry(it) },
                        viewModel = viewModel
                    )
                }
            }
            //Michigan Vacations
            composable(route = NoviMichiganTourScreens.MichiganVacations.name) {
                MichiganVacationsScreen(
                    onCardClicked = { navController.navigate(it.entryRoute) },
                    navigationType = navigationType,
                    onTabPressed = { navController.navigate(it.toString()) },
                    noviUiState = noviUiState
                )
            }
            for (entry in Recommendations.recommendationsMichiganVacations) {
                composable(route = entry.entryRoute) {
                    RecommendedPlaceScreen(
                        entry = entry,
                        navigationType = navigationType,
                        noviUiState = noviUiState,
                        onTabPressed = { navController.navigate(it.toString()) },
                        save = { viewModel.addSavedEntry(it) },
                        remove = { viewModel.removeSavedEntry(it) },
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}