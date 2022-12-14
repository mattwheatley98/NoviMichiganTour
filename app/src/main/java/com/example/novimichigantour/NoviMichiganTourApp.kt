package com.example.novimichigantour

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
import com.example.novimichigantour.data.Recommendations
import com.example.novimichigantour.data.Saved.savedRecommendations
import com.example.novimichigantour.model.Entry
import com.example.novimichigantour.model.SelectionType
import com.example.novimichigantour.ui.*
import com.example.novimichigantour.ui.utils.NoviMichiganTourNavigationType

enum class NoviMichiganTourScreen(@StringRes val title: Int) {
    Home(R.string.app_name),
    Parks(R.string.parks),
    Shopping(R.string.shopping),
    Restaurants(R.string.restaurants),
    ThingsToDo(R.string.things_to_do),
    NearbyAttractions(R.string.nearby_attractions),
    Detroit(R.string.detroit),
    AnnArbor(R.string.ann_arbor),
    MichiganVacations(R.string.michigan_vacations),

    BoscoFields(R.string.bosco_fields),
    FuerstPark(R.string.fuerst_park),
    ItcCorridorTrail(R.string.itc_corridor_trail),
    PavilionShorePark(R.string.pavilion_shore_park),
    RotaryPark(R.string.rotary_park),
    WildlifeWoodsPark(R.string.wildlife_woods_park),

    NoviTownCenter(R.string.novi_town_center),
    OneWorldMarket(R.string.one_world_market),
    TwelveMileCrossing(R.string.twelve_mile_crossing),
    TwelveOaksMall(R.string.twelve_oaks_mall),
    WestMarketSquare(R.string.west_market_square),
    WestOaksShoppingCenter(R.string.west_oaks_shopping_center),

    ChoppedOlive(R.string.chopped_olive),
    Fumi(R.string.fumi),
    KuraSushi(R.string.kura_sushi),
    NagomiJapaneseRestaurant(R.string.nagomi_japanese_restaurant),
    OSushi(R.string.o_sushi),
    SedonaTaphouse(R.string.sedona_taphouse),
    TheBreakfastClub(R.string.the_breakfast_club),

    JapaneseFestival(R.string.japanese_festival),
    LinksOfNovi(R.string.links_of_novi),
    MichiganStateFair(R.string.michigan_state_fair),
    NoviAthleticClub(R.string.novi_athletic_club),
    SparcArena(R.string.sparc_arena),

    DowntownBrighton(R.string.downtown_brighton),
    DowntownNorthville(R.string.downtown_northville),
    DowntownPlymouth(R.string.downtown_plymouth),
    HinesPark(R.string.hines_park),
    KensingtonMetropark(R.string.kensington_metropark),
    MayburyPark(R.string.maybury_park),
    SomersetCollection(R.string.somerset_collection),

    BelleIslePark(R.string.belle_isle_park),
    DetroitInstituteOfArts(R.string.detroit_institute_of_arts),
    DetroitRiverfront(R.string.detroit_riverfront),
    EasternMarket(R.string.eastern_market),
    MotownMuseum(R.string.motown_museum),
    TheGuardianBuilding(R.string.the_guardian_building),

    AnnArborHandsOnMuseum(R.string.ann_arbor_hands_on_museum),
    HudsonMillsMetropark(R.string.hudson_mills_metropark),
    Kerrytown(R.string.kerrytown),
    MainStreet(R.string.main_street),
    MichiganTheater(R.string.michigan_theater),
    UniversityOfMichigan(R.string.university_of_michigan),

    Holland(R.string.holland),
    IsleRoyaleNationalPark(R.string.isle_royale_national_park),
    MackinacIsland(R.string.mackinac_island),
    Marquette(R.string.marquette),
    Munising(R.string.munising),
    TraverseCity(R.string.traverse_city),

    Tour(R.string.tour),
    Saved(R.string.saved),
    Map(R.string.map),
    Extras(R.string.extras)
}

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
            //Definitely not the best fix, but it'll do for now
            //Reason why it "does not work" is because you are forced to press the home tab from other tabs which takes you back to the home page
            //Yeah, this is just a band aid fix... the phone's back button causes the same issue from before
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
    val currentScreen = NoviMichiganTourScreen.valueOf(
        backStackEntry?.destination?.route ?: NoviMichiganTourScreen.Home.name
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
                    navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        val noviUiState by viewModel.noviUiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = NoviMichiganTourScreen.Home.name,
            modifier = Modifier.padding(innerPadding)
        ) {

            //If you have time, start doing dynamic layouts

            composable(route = NoviMichiganTourScreen.Home.name) {
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
            composable(route = NoviMichiganTourScreen.Saved.name) {
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
                    saved = savedRecommendations
                )
            }
            composable(route = NoviMichiganTourScreen.Map.name) {
                    MapScreen(
                        navigationType = navigationType,
                        noviUiState = noviUiState,
                        onTabPressed = { selectionType: SelectionType ->
                            viewModel.updateCurrentTabSelection(selectionType = selectionType)
                            navController.navigate(selectionType.toString())
                        },
                        resetSelections = {viewModel.resetMapCheckbox()},
                        parksState = {viewModel.updateParksCheckbox(noviUiState.parksCheckbox)},
                        shoppingState = {viewModel.updateShoppingCheckbox(noviUiState.shoppingCheckbox)},
                        restaurantsState = {viewModel.updateRestaurantsCheckbox(noviUiState.restaurantsCheckbox)},
                        thingsToDoState = {viewModel.updateThingsToDoCheckbox(noviUiState.thingsToDoCheckbox)},
                        nearbyAttractionsState = {viewModel.updateNearbyAttractionsCheckbox(noviUiState.nearbyAttractionsCheckbox)},
                        detroitState = {viewModel.updateDetroitCheckbox(noviUiState.detroitCheckbox)},
                        annArborState = {viewModel.updateAnnArborCheckbox(noviUiState.annArborCheckbox)},
                        michiganVacationsState = {viewModel.updateMichiganVacationsCheckbox(noviUiState.michiganVacationsCheckbox)}
                    )
            }
            composable(route = NoviMichiganTourScreen.Extras.name) {
                ExtrasScreen(
                    navigationType = navigationType,
                    noviUiState = noviUiState,
                    onTabPressed = { selectionType: SelectionType ->
                        viewModel.updateCurrentTabSelection(selectionType = selectionType)
                        navController.navigate(selectionType.toString())
                    }
                )
            }



            //Parks
            composable(route = NoviMichiganTourScreen.Parks.name) {
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
            for (entry in Recommendations.recommendationsParks){
                composable(route = entry.entryRoute){
                    RecommendedPlaceScreen(
                        entry = entry,
                        navigationType = navigationType,
                        noviUiState = noviUiState,
                        onTabPressed = { selectionType: SelectionType ->
                            viewModel.updateCurrentTabSelection(selectionType = selectionType)
                            navController.navigate(selectionType.toString())
                        },
                        save = { entry: Entry ->
                            savedRecommendations.add(entry)
                        }
                    )
                }
            }
            //Shopping
            composable(route = NoviMichiganTourScreen.Shopping.name) {
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
            for (entry in Recommendations.recommendationsShopping){
                composable(route = entry.entryRoute){
                    RecommendedPlaceScreen(
                        entry = entry,
                        navigationType = navigationType,
                        noviUiState = noviUiState,
                        onTabPressed = { selectionType: SelectionType ->
                            viewModel.updateCurrentTabSelection(selectionType = selectionType)
                            navController.navigate(selectionType.toString())
                        },
                        save = { }
                    )
                }
            }
            //Restaurants
            composable(route = NoviMichiganTourScreen.Restaurants.name) {
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
            for (entry in Recommendations.recommendationsRestaurants){
                composable(route = entry.entryRoute){
                    RecommendedPlaceScreen(
                        entry = entry,
                        navigationType = navigationType,
                        noviUiState = noviUiState,
                        onTabPressed = { selectionType: SelectionType ->
                            viewModel.updateCurrentTabSelection(selectionType = selectionType)
                            navController.navigate(selectionType.toString())
                        },
                        save = { }
                    )
                }
            }
            //Things To Do
            composable(route = NoviMichiganTourScreen.ThingsToDo.name) {
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
            for (entry in Recommendations.recommendationsThingsToDo){
                composable(route = entry.entryRoute){
                    RecommendedPlaceScreen(
                        entry = entry,
                        navigationType = navigationType,
                        noviUiState = noviUiState,
                        onTabPressed = { selectionType: SelectionType ->
                            viewModel.updateCurrentTabSelection(selectionType = selectionType)
                            navController.navigate(selectionType.toString())
                        },
                        save = { }
                    )
                }
            }
            //Nearby Attractions
            composable(route = NoviMichiganTourScreen.NearbyAttractions.name) {
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
            for (entry in Recommendations.recommendationsNearbyAttractions){
                composable(route = entry.entryRoute){
                    RecommendedPlaceScreen(
                        entry = entry,
                        navigationType = navigationType,
                        noviUiState = noviUiState,
                        onTabPressed = { selectionType: SelectionType ->
                            viewModel.updateCurrentTabSelection(selectionType = selectionType)
                            navController.navigate(selectionType.toString())
                        },
                        save = { }
                    )
                }
            }
            //Detroit
            composable(route = NoviMichiganTourScreen.Detroit.name) {
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
            for (entry in Recommendations.recommendationsDetroit){
                composable(route = entry.entryRoute){
                    RecommendedPlaceScreen(
                        entry = entry,
                        navigationType = navigationType,
                        noviUiState = noviUiState,
                        onTabPressed = { selectionType: SelectionType ->
                            viewModel.updateCurrentTabSelection(selectionType = selectionType)
                            navController.navigate(selectionType.toString())
                        },
                        save = { }
                    )
                }
            }
            //Ann Arbor
            composable(route = NoviMichiganTourScreen.AnnArbor.name) {
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
            for (entry in Recommendations.recommendationsAnnArbor){
                composable(route = entry.entryRoute){
                    RecommendedPlaceScreen(
                        entry = entry,
                        navigationType = navigationType,
                        noviUiState = noviUiState,
                        onTabPressed = { selectionType: SelectionType ->
                            viewModel.updateCurrentTabSelection(selectionType = selectionType)
                            navController.navigate(selectionType.toString())
                        },
                        save = { }
                    )
                }
            }
            //Michigan Vacations
            composable(route = NoviMichiganTourScreen.MichiganVacations.name) {
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
            for (entry in Recommendations.recommendationsMichiganVacations){
                composable(route = entry.entryRoute){
                    RecommendedPlaceScreen(
                        entry = entry,
                        navigationType = navigationType,
                        noviUiState = noviUiState,
                        onTabPressed = { selectionType: SelectionType ->
                            viewModel.updateCurrentTabSelection(selectionType = selectionType)
                            navController.navigate(selectionType.toString())
                        },
                        save = { }
                    )
                }
            }
        }
    }
}