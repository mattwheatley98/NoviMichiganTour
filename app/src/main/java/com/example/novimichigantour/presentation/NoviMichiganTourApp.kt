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
import com.example.novimichigantour.domain.model.Entry
import com.example.novimichigantour.domain.model.SelectionType
import com.example.novimichigantour.presentation.bottom_bar_screens.HomeScreen
import com.example.novimichigantour.presentation.utils.NoviMichiganTourScreens
import com.example.novimichigantour.ui.utils.NoviMichiganTourNavigationType

@Composable
fun NoviMichiganAppBar(
    @StringRes currentScreenTitle: Int,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    onTabPressed: (SelectionType) -> Unit
) {
    TopAppBar(
        title = { Text(text = stringResource(currentScreenTitle)) },
        backgroundColor = MaterialTheme.colors.primary,
        navigationIcon = {
            if (canNavigateBack && currentScreenTitle != R.string.saved && currentScreenTitle != R.string.map && currentScreenTitle != R.string.extras && currentScreenTitle != R.string.app_name) {
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
                onTabPressed = { selectionType: SelectionType ->
                    viewModel.updateCurrentTabSelection(selectionType = selectionType)
                },
                navigateUp = {
                    navController.navigateUp()
                }
            )
        }
    ) { innerPadding ->
        val noviUiState by viewModel.noviUiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = NoviMichiganTourScreens.Home.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = NoviMichiganTourScreens.Home.name) {
                HomeScreen(
                    onCardClicked = { entry: Entry ->
                        viewModel.updateCurrentCardSelection(entry = entry)
                        navController.navigate(entry.entryRoute)
                    },
                    navigationType = navigationType,
                    onTabPressed = { selectionType: SelectionType ->
                        viewModel.updateCurrentTabSelection(selectionType = selectionType)
                        navController.navigate(selectionType.toString())
                    },
                    noviUiState = noviUiState
                )
            }
            composable(route = NoviMichiganTourScreens.Saved.name) {
                SavedScreen(
                    navigationType = navigationType,
                    noviUiState = noviUiState,
                    onTabPressed = { selectionType: SelectionType ->
                        viewModel.updateCurrentTabSelection(selectionType = selectionType)
                        navController.navigate(selectionType.toString())
                    },
                    onCardClicked = { entry: Entry ->
                        viewModel.updateCurrentCardSelection(entry = entry)
                        navController.navigate(entry.entryRoute)
                    },
                    savedCollection = noviUiState.savedRecommendations,
                    resetCollection = { viewModel.resetAllEntries(); navController.navigate(NoviMichiganTourScreens.Saved.name) } //The navigation is for Recomposing the screen to reflect the changes... should use noviUiState
                )
            }
            composable(route = NoviMichiganTourScreens.Map.name) {
                MapScreen(
                    navigationType = navigationType,
                    noviUiState = noviUiState,
                    onTabPressed = { selectionType: SelectionType ->
                        viewModel.updateCurrentTabSelection(selectionType = selectionType)
                        navController.navigate(selectionType.toString())
                    },
                    parksState = { viewModel.updateParksCheckbox(noviUiState.parksCheckbox) },
                    shoppingState = { viewModel.updateShoppingCheckbox(noviUiState.shoppingCheckbox) },
                    restaurantsState = { viewModel.updateRestaurantsCheckbox(noviUiState.restaurantsCheckbox) },
                    thingsToDoState = { viewModel.updateThingsToDoCheckbox(noviUiState.thingsToDoCheckbox) },
                    nearbyAttractionsState = { viewModel.updateNearbyAttractionsCheckbox(noviUiState.nearbyAttractionsCheckbox) },
                    detroitState = { viewModel.updateDetroitCheckbox(noviUiState.detroitCheckbox) },
                    annArborState = { viewModel.updateAnnArborCheckbox(noviUiState.annArborCheckbox) },
                    michiganVacationsState = { viewModel.updateMichiganVacationsCheckbox(noviUiState.michiganVacationsCheckbox) },
                    savedState = {viewModel.updateSavedCheckbox(noviUiState.savedCheckbox)}
                )
            }


            //Parks
            composable(route = NoviMichiganTourScreens.Parks.name) {
                ParksScreen(
                    onCardClicked = { entry: Entry ->
                        viewModel.updateCurrentCardSelection(entry = entry)
                        navController.navigate(entry.entryRoute)
                    },
                    navigationType = navigationType,
                    onTabPressed = { selectionType: SelectionType ->
                        viewModel.updateCurrentTabSelection(selectionType = selectionType)
                        navController.navigate(selectionType.toString())
                    },
                    noviUiState = noviUiState
                )
            }
            for (entry in Recommendations.recommendationsParks) {
                composable(route = entry.entryRoute) {
                    RecommendedPlaceScreen(
                        entry = entry,
                        navigationType = navigationType,
                        noviUiState = noviUiState,
                        onTabPressed = { selectionType: SelectionType ->
                            viewModel.updateCurrentTabSelection(selectionType = selectionType)
                            navController.navigate(selectionType.toString())
                        },
                        save = { entry: Entry ->
                            viewModel.addSavedEntry(entry)
                            navController.navigate(entry.entryRoute)
                        },
                        remove = {entry: Entry ->
                            viewModel.removeSavedEntry(entry)
                            navController.navigate(entry.entryRoute)
                        }
                    )
                }
            }
            //Shopping
            composable(route = NoviMichiganTourScreens.Shopping.name) {
                ShoppingScreen(
                    onCardClicked = { entry: Entry ->
                        viewModel.updateCurrentCardSelection(entry = entry)
                        navController.navigate(entry.entryRoute)
                    },
                    navigationType = navigationType,
                    onTabPressed = { selectionType: SelectionType ->
                        viewModel.updateCurrentTabSelection(selectionType = selectionType)
                        navController.navigate(selectionType.toString())
                    },
                    noviUiState = noviUiState
                )
            }
            for (entry in Recommendations.recommendationsShopping) {
                composable(route = entry.entryRoute) {
                    RecommendedPlaceScreen(
                        entry = entry,
                        navigationType = navigationType,
                        noviUiState = noviUiState,
                        onTabPressed = { selectionType: SelectionType ->
                            viewModel.updateCurrentTabSelection(selectionType = selectionType)
                            navController.navigate(selectionType.toString())
                        },
                        save = { entry: Entry ->
                            viewModel.addSavedEntry(entry)
                            navController.navigate(entry.entryRoute)
                        },
                        remove = {entry: Entry ->
                            viewModel.removeSavedEntry(entry)
                            navController.navigate(entry.entryRoute)
                        }
                    )
                }
            }
            //Restaurants
            composable(route = NoviMichiganTourScreens.Restaurants.name) {
                RestaurantsScreen(
                    onCardClicked = { entry: Entry ->
                        viewModel.updateCurrentCardSelection(entry = entry)
                        navController.navigate(entry.entryRoute)
                    },
                    navigationType = navigationType,
                    onTabPressed = { selectionType: SelectionType ->
                        viewModel.updateCurrentTabSelection(selectionType = selectionType)
                        navController.navigate(selectionType.toString())
                    },
                    noviUiState = noviUiState
                )
            }
            for (entry in Recommendations.recommendationsRestaurants) {
                composable(route = entry.entryRoute) {
                    RecommendedPlaceScreen(
                        entry = entry,
                        navigationType = navigationType,
                        noviUiState = noviUiState,
                        onTabPressed = { selectionType: SelectionType ->
                            viewModel.updateCurrentTabSelection(selectionType = selectionType)
                            navController.navigate(selectionType.toString())
                        },
                        save = { entry: Entry ->
                            viewModel.addSavedEntry(entry)
                            navController.navigate(entry.entryRoute)
                        },
                        remove = {entry: Entry ->
                            viewModel.removeSavedEntry(entry)
                            navController.navigate(entry.entryRoute)
                        }
                    )
                }
            }
            //Things To Do
            composable(route = NoviMichiganTourScreens.ThingsToDo.name) {
                ThingsToDoScreen(
                    onCardClicked = { entry: Entry ->
                        viewModel.updateCurrentCardSelection(entry = entry)
                        navController.navigate(entry.entryRoute)
                    },
                    navigationType = navigationType,
                    onTabPressed = { selectionType: SelectionType ->
                        viewModel.updateCurrentTabSelection(selectionType = selectionType)
                        navController.navigate(selectionType.toString())
                    },
                    noviUiState = noviUiState
                )
            }
            for (entry in Recommendations.recommendationsThingsToDo) {
                composable(route = entry.entryRoute) {
                    RecommendedPlaceScreen(
                        entry = entry,
                        navigationType = navigationType,
                        noviUiState = noviUiState,
                        onTabPressed = { selectionType: SelectionType ->
                            viewModel.updateCurrentTabSelection(selectionType = selectionType)
                            navController.navigate(selectionType.toString())
                        },
                        save = { entry: Entry ->
                            viewModel.addSavedEntry(entry)
                            navController.navigate(entry.entryRoute)
                        },
                        remove = {entry: Entry ->
                            viewModel.removeSavedEntry(entry)
                            navController.navigate(entry.entryRoute)
                        }
                    )
                }
            }
            //Nearby Attractions
            composable(route = NoviMichiganTourScreens.NearbyAttractions.name) {
                NearbyAttractionsScreen(
                    onCardClicked = { entry: Entry ->
                        viewModel.updateCurrentCardSelection(entry = entry)
                        navController.navigate(entry.entryRoute)
                    },
                    navigationType = navigationType,
                    onTabPressed = { selectionType: SelectionType ->
                        viewModel.updateCurrentTabSelection(selectionType = selectionType)
                        navController.navigate(selectionType.toString())
                    },
                    noviUiState = noviUiState
                )
            }
            for (entry in Recommendations.recommendationsNearbyAttractions) {
                composable(route = entry.entryRoute) {
                    RecommendedPlaceScreen(
                        entry = entry,
                        navigationType = navigationType,
                        noviUiState = noviUiState,
                        onTabPressed = { selectionType: SelectionType ->
                            viewModel.updateCurrentTabSelection(selectionType = selectionType)
                            navController.navigate(selectionType.toString())
                        },
                        save = { entry: Entry ->
                            viewModel.addSavedEntry(entry)
                            navController.navigate(entry.entryRoute)
                        },
                        remove = {entry: Entry ->
                            viewModel.removeSavedEntry(entry)
                            navController.navigate(entry.entryRoute)
                        }
                    )
                }
            }
            //Detroit
            composable(route = NoviMichiganTourScreens.Detroit.name) {
                DetroitScreen(
                    onCardClicked = { entry: Entry ->
                        viewModel.updateCurrentCardSelection(entry = entry)
                        navController.navigate(entry.entryRoute)
                    },
                    navigationType = navigationType,
                    onTabPressed = { selectionType: SelectionType ->
                        viewModel.updateCurrentTabSelection(selectionType = selectionType)
                        navController.navigate(selectionType.toString())
                    },
                    noviUiState = noviUiState
                )
            }
            for (entry in Recommendations.recommendationsDetroit) {
                composable(route = entry.entryRoute) {
                    RecommendedPlaceScreen(
                        entry = entry,
                        navigationType = navigationType,
                        noviUiState = noviUiState,
                        onTabPressed = { selectionType: SelectionType ->
                            viewModel.updateCurrentTabSelection(selectionType = selectionType)
                            navController.navigate(selectionType.toString())
                        },
                        save = { entry: Entry ->
                            viewModel.addSavedEntry(entry)
                            navController.navigate(entry.entryRoute)
                        },
                        remove = {entry: Entry ->
                            viewModel.removeSavedEntry(entry)
                            navController.navigate(entry.entryRoute)
                        }
                    )
                }
            }
            //Ann Arbor
            composable(route = NoviMichiganTourScreens.AnnArbor.name) {
                AnnArborScreen(
                    onCardClicked = { entry: Entry ->
                        viewModel.updateCurrentCardSelection(entry = entry)
                        navController.navigate(entry.entryRoute)
                    },
                    navigationType = navigationType,
                    onTabPressed = { selectionType: SelectionType ->
                        viewModel.updateCurrentTabSelection(selectionType = selectionType)
                        navController.navigate(selectionType.toString())
                    },
                    noviUiState = noviUiState
                )
            }
            for (entry in Recommendations.recommendationsAnnArbor) {
                composable(route = entry.entryRoute) {
                    RecommendedPlaceScreen(
                        entry = entry,
                        navigationType = navigationType,
                        noviUiState = noviUiState,
                        onTabPressed = { selectionType: SelectionType ->
                            viewModel.updateCurrentTabSelection(selectionType = selectionType)
                            navController.navigate(selectionType.toString())
                        },
                        save = { entry: Entry ->
                            viewModel.addSavedEntry(entry)
                            navController.navigate(entry.entryRoute)
                        },
                        remove = {entry: Entry ->
                            viewModel.removeSavedEntry(entry)
                            navController.navigate(entry.entryRoute)
                        }
                    )
                }
            }
            //Michigan Vacations
            composable(route = NoviMichiganTourScreens.MichiganVacations.name) {
                MichiganVacationsScreen(
                    onCardClicked = { entry: Entry ->
                        viewModel.updateCurrentCardSelection(entry = entry)
                        navController.navigate(entry.entryRoute)
                    },
                    navigationType = navigationType,
                    onTabPressed = { selectionType: SelectionType ->
                        viewModel.updateCurrentTabSelection(selectionType = selectionType)
                        navController.navigate(selectionType.toString())
                    },
                    noviUiState = noviUiState
                )
            }
            for (entry in Recommendations.recommendationsMichiganVacations) {
                composable(route = entry.entryRoute) {
                    RecommendedPlaceScreen(
                        entry = entry,
                        navigationType = navigationType,
                        noviUiState = noviUiState,
                        onTabPressed = { selectionType: SelectionType ->
                            viewModel.updateCurrentTabSelection(selectionType = selectionType)
                            navController.navigate(selectionType.toString())
                        },
                        save = { entry: Entry ->
                            viewModel.addSavedEntry(entry)
                            navController.navigate(entry.entryRoute)
                        },
                        remove = {entry: Entry ->
                            viewModel.removeSavedEntry(entry)
                            navController.navigate(entry.entryRoute)
                        }
                    )
                }
            }
        }
    }
}