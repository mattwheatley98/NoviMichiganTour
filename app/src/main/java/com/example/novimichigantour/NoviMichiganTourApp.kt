package com.example.novimichigantour

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import com.example.novimichigantour.ui.*

enum class NoviMichiganTourScreen(@StringRes val title: Int) {
    Categories(R.string.app_name),
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


}


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
            if (canNavigateBack) {
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
fun NoviMichiganTourApp() {

    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = NoviMichiganTourScreen.valueOf(
        backStackEntry?.destination?.route ?: NoviMichiganTourScreen.Categories.name
    )
    val viewModel: NoviViewModel = viewModel()

    Scaffold(
        topBar = {
            NoviMichiganAppBar(
                currentScreenTitle = currentScreen.title,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        val uiState by viewModel.noviUiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = NoviMichiganTourScreen.Categories.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = NoviMichiganTourScreen.Categories.name) {
                CategoriesScreen(
                    onCardClicked = { navController.navigate(com.example.novimichigantour.ui.route) }
                )
            }
            //Parks
            composable(route = NoviMichiganTourScreen.Parks.name) {
                ParksScreen(
                    onCardClicked = { navController.navigate(com.example.novimichigantour.ui.route) })
            }
            composable(route = NoviMichiganTourScreen.BoscoFields.name) {
                BoscoFieldsScreen()
            }
            composable(route = NoviMichiganTourScreen.FuerstPark.name) {
                FuerstParkScreen()
            }
            composable(route = NoviMichiganTourScreen.ItcCorridorTrail.name) {
                ItcCorridorTrailScreen()
            }
            composable(route = NoviMichiganTourScreen.PavilionShorePark.name) {
                PavilionShoreParkScreen()
            }
            composable(route = NoviMichiganTourScreen.RotaryPark.name) {
                RotaryParkScreen()
            }
            composable(route = NoviMichiganTourScreen.WildlifeWoodsPark.name) {
                WildlifeWoodsParkScreen()
            }
            //Shopping
            composable(route = NoviMichiganTourScreen.Shopping.name) {
                ShoppingScreen(
                    onCardClicked = { navController.navigate(com.example.novimichigantour.ui.route) })
            }
            composable(route = NoviMichiganTourScreen.NoviTownCenter.name) {
                NoviTownCenterScreen()
            }
            composable(route = NoviMichiganTourScreen.OneWorldMarket.name) {
                OneWorldMarketScreen()
            }
            composable(route = NoviMichiganTourScreen.TwelveMileCrossing.name) {
                TwelveMileCrossingScreen()
            }
            composable(route = NoviMichiganTourScreen.TwelveOaksMall.name) {
                TwelveOaksMallScreen()
            }
            composable(route = NoviMichiganTourScreen.WestMarketSquare.name) {
                WestMarketSquareScreen()
            }
            composable(route = NoviMichiganTourScreen.WestOaksShoppingCenter.name) {
                WestOaksShoppingCenterScreen()
            }
            //Restaurants
            composable(route = NoviMichiganTourScreen.Restaurants.name) {
                RestaurantsScreen(
                    onCardClicked = { navController.navigate(com.example.novimichigantour.ui.route) })
            }
            composable(route = NoviMichiganTourScreen.ChoppedOlive.name) {
                ChoppedOliveScreen()
            }
            composable(route = NoviMichiganTourScreen.Fumi.name) {
                FumiScreen()
            }
            composable(route = NoviMichiganTourScreen.KuraSushi.name) {
                KuraSushiScreen()
            }
            composable(route = NoviMichiganTourScreen.NagomiJapaneseRestaurant.name) {
                NagomiJapaneseRestaurantScreen()
            }
            composable(route = NoviMichiganTourScreen.OSushi.name) {
                OSushiScreen()
            }
            composable(route = NoviMichiganTourScreen.SedonaTaphouse.name) {
                SedonaTaphouseScreen()
            }
            composable(route = NoviMichiganTourScreen.TheBreakfastClub.name) {
                TheBreakfastClubScreen()
            }
            //Things To Do
            composable(route = NoviMichiganTourScreen.ThingsToDo.name) {
                ThingsToDoScreen(
                    onCardClicked = { navController.navigate(com.example.novimichigantour.ui.route) })
            }
            composable(route = NoviMichiganTourScreen.JapaneseFestival.name) {
                JapaneseFestivalScreen()
            }
            composable(route = NoviMichiganTourScreen.LinksOfNovi.name) {
                LinksOfNoviScreen()
            }
            composable(route = NoviMichiganTourScreen.MichiganStateFair.name) {
                MichiganStateFairScreen()
            }
            composable(route = NoviMichiganTourScreen.NoviAthleticClub.name) {
                NoviAthleticClubScreen()
            }
            composable(route = NoviMichiganTourScreen.SparcArena.name) {
                SparcArenaScreen()
            }
            //Nearby Attractions
            composable(route = NoviMichiganTourScreen.NearbyAttractions.name) {
                NearbyAttractionsScreen(
                    onCardClicked = { navController.navigate(com.example.novimichigantour.ui.route) })
            }
            composable(route = NoviMichiganTourScreen.DowntownBrighton.name) {
                DowntownBrightonScreen()
            }
            composable(route = NoviMichiganTourScreen.DowntownNorthville.name) {
                DowntownNorthvilleScreen()
            }
            composable(route = NoviMichiganTourScreen.DowntownPlymouth.name) {
                DowntownPlymouthScreen()
            }
            composable(route = NoviMichiganTourScreen.HinesPark.name) {
                HinesParkScreen()
            }
            composable(route = NoviMichiganTourScreen.KensingtonMetropark.name) {
                KensingtonMetroparkScreen()
            }
            composable(route = NoviMichiganTourScreen.MayburyPark.name) {
                MayburyParkScreen()
            }
            composable(route = NoviMichiganTourScreen.SomersetCollection.name) {
                SomersetCollectionScreen()
            }
            //Detroit
            composable(route = NoviMichiganTourScreen.Detroit.name) {
                DetroitScreen(
                    onCardClicked = { navController.navigate(com.example.novimichigantour.ui.route) })
            }
            composable(route = NoviMichiganTourScreen.BelleIslePark.name) {
                BelleIsleParkScreen()
            }
            composable(route = NoviMichiganTourScreen.DetroitInstituteOfArts.name) {
                DetroitInstituteOfArtsScreen()
            }
            composable(route = NoviMichiganTourScreen.DetroitRiverfront.name) {
                DetroitRiverfrontScreen()
            }
            composable(route = NoviMichiganTourScreen.EasternMarket.name) {
                EasternMarketScreen()
            }
            composable(route = NoviMichiganTourScreen.MotownMuseum.name) {
                MotownMuseumScreen()
            }
            composable(route = NoviMichiganTourScreen.TheGuardianBuilding.name) {
                TheGuardianBuildingScreen()
            }
            //Ann Arbor
            composable(route = NoviMichiganTourScreen.AnnArbor.name) {
                AnnArborScreen(
                    onCardClicked = { navController.navigate(com.example.novimichigantour.ui.route) })
            }
            composable(route = NoviMichiganTourScreen.AnnArborHandsOnMuseum.name) {
                AnnArborHandsOnMuseumScreen()
            }
            composable(route = NoviMichiganTourScreen.HudsonMillsMetropark.name) {
                HudsonMillsMetroparkScreen()
            }
            composable(route = NoviMichiganTourScreen.Kerrytown.name) {
                KerrytownScreen()
            }
            composable(route = NoviMichiganTourScreen.MainStreet.name) {
                MainStreetScreen()
            }
            composable(route = NoviMichiganTourScreen.MichiganTheater.name) {
                MichiganTheaterScreen()
            }
            composable(route = NoviMichiganTourScreen.UniversityOfMichigan.name) {
                UniversityOfMichiganScreen()
            }
            //Michigan Vacations
            composable(route = NoviMichiganTourScreen.MichiganVacations.name) {
                MichiganVacationsScreen(
                    onCardClicked = { navController.navigate(com.example.novimichigantour.ui.route) })
            }
            composable(route = NoviMichiganTourScreen.Holland.name) {
                HollandScreen()
            }
            composable(route = NoviMichiganTourScreen.IsleRoyaleNationalPark.name) {
                IsleRoyaleNationalParkScreen()
            }
            composable(route = NoviMichiganTourScreen.MackinacIsland.name) {
                MackinacIslandScreen()
            }
            composable(route = NoviMichiganTourScreen.Marquette.name) {
                MarquetteScreen()
            }
            composable(route = NoviMichiganTourScreen.Munising.name) {
                MunisingScreen()
            }
            composable(route = NoviMichiganTourScreen.TraverseCity.name) {
                TraverseCityScreen()
            }
        }
    }
}