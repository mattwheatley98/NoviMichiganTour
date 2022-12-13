package com.example.novimichigantour.data

import com.example.novimichigantour.R
import com.example.novimichigantour.model.Entry
import com.google.android.gms.maps.model.LatLng

object Recommendations {
    val recommendationsParks = listOf<Entry>(
        Entry(
            "BoscoFields",
            R.drawable.bosco_fields,
            R.string.bosco_fields,
            location = LatLng(42.477995740538375, -83.51755546965676)
        ),
        Entry(
            "FuerstPark",
            R.drawable.fuerst_park,
            R.string.fuerst_park,
            location = LatLng(42.46524165090556, -83.49327743832589)
        ),
        Entry(
            "ItcCorridorTrail",
            R.drawable.itc_corridor_trail,
            R.string.itc_corridor_trail,
            location = LatLng(42.43732318907327, -83.54923333928406)
        ),
        Entry(
            "PavilionShorePark",
            R.drawable.pavilion_shore_park,
            R.string.pavilion_shore_park,
            location = LatLng(42.51081858155433, -83.47640914748996)

        ),
        Entry(
            "RotaryPark",
            R.drawable.rotary_park,
            R.string.rotary_park,
            location = LatLng(42.449513898104875, -83.4664192101664)
        ),
        Entry(
            "WildlifeWoodsPark",
            R.drawable.wildlife_woods_park,
            R.string.wildlife_woods_park,
            location = LatLng(42.48423921424371, -83.52957841000931)
        )
    )

    val recommendationsShopping = listOf<Entry>(
        Entry(
            "NoviTownCenter",
            R.drawable.novi_town_center,
            R.string.novi_town_center,
            location = LatLng(42.48265138416665, -83.47211003422515)
        ),
        Entry(
            "OneWorldMarket",
            R.drawable.one_world_market,
            R.string.one_world_market,
            location = LatLng(42.47828409691766, -83.46735252029345)
        ),
        Entry(
            "TwelveMileCrossing",
            R.drawable.twelve_mile_crossing,
            R.string.twelve_mile_crossing,
            location = LatLng(42.49075434626514, -83.48362246442133)
        ),
        Entry(
            "TwelveOaksMall",
            R.drawable.twelve_oaks_mall,
            R.string.twelve_oaks_mall,
            location = LatLng(42.49265630481158, -83.47074248770231)
        ),
        Entry(
            "WestMarketSquare",
            R.drawable.west_market_square_shopping_center,
            R.string.west_market_square,
            location = LatLng(42.49313615666519, -83.52046511496694)
        ),
        Entry(
            "WestOaksShoppingCenter",
            R.drawable.west_oaks_shopping_center,
            R.string.west_oaks_shopping_center,
            location = LatLng(42.4939158524146, -83.47941124331295)
        )
    )

    val recommendationsRestaurants = listOf<Entry>(
        Entry(
            "ChoppedOlive",
            R.drawable.chopped_olive,
            R.string.chopped_olive,
            location = LatLng(42.490640570627775, -83.51676258387617)
        ),
        Entry(
            "Fumi",
            R.drawable.fumi,
            R.string.fumi,
            location = LatLng(42.467896780600825, -83.4760863584168)
        ),
        //Started clicking on the marker directly
        Entry(
            "KuraSushi",
            R.drawable.kura_sushi,
            R.string.kura_sushi,
            location = LatLng(42.48450957987158, -83.47627706367264)
        ),
        Entry(
            "NagomiJapaneseRestaurant",
            R.drawable.nagomi_japanese_restaurant,
            R.string.nagomi_japanese_restaurant,
            location = LatLng(42.47724255072325, -83.47467656794026)
        ),
        Entry(
            "OSushi",
            R.drawable.o_sushi,
            R.string.o_sushi,
            location = LatLng(42.466718036248075, -83.45693599448482)
        ),
        Entry(
            "SedonaTaphouse",
            R.drawable.sedona_taphouse,
            R.string.sedona_taphouse,
            location = LatLng(42.491232155940075, -83.47030580025577)
        ),
        //Refactor to not have "The"
        Entry(
            "TheBreakfastClub",
            R.drawable.the_breakfast_club,
            R.string.the_breakfast_club,
            location = LatLng(42.4674012717903, -83.47594508462423)
        )
    )

    val recommendationsThingsToDo = listOf<Entry>(
        Entry(
            "JapaneseFestival",
            R.drawable.japanese_festival,
            R.string.japanese_festival,
            location = LatLng(42.46312178795753, -83.49231699975749)
        ),
        Entry(
            "LinksOfNovi",
            R.drawable.links_of_novi,
            R.string.links_of_novi,
            location = LatLng(42.462909280284975, -83.54366260953968)
        ),
        Entry(
            "MichiganStateFair",
            R.drawable.michigan_state_fair,
            R.string.michigan_state_fair,
            location = LatLng(42.48872010439582, -83.50273687035073)
        ),
        Entry(
            "NoviAthleticClub",
            R.drawable.novi_athletic_club,
            R.string.novi_athletic_club,
            location = LatLng(42.4617205583397, -83.46919290031396)
        ),
        Entry(
            "SparcArena",
            R.drawable.sparc_arena,
            R.string.sparc_arena,
            location = LatLng(42.45168084231876, -83.46486602944357)
        )
    )

    val recommendationsNearbyAttractions = listOf<Entry>(
        Entry(
            "DowntownBrighton",
            R.drawable.downtown_brighton,
            R.string.downtown_brighton,
            location = LatLng(42.529364625506105, -83.78042785837015)
        ),
        Entry(
            "DowntownNorthville",
            R.drawable.downtown_northville,
            R.string.downtown_northville,
            location = LatLng(42.43107650974676, -83.48323738184168)
        ),
        Entry(
            "DowntownPlymouth",
            R.drawable.downtown_plymouth,
            R.string.downtown_plymouth,
            location = LatLng(42.36978379674894, -83.46941365144089)
        ),
        Entry(
            "HinesPark",
            R.drawable.hines_park,
            R.string.hines_park,
            location = LatLng(42.42288606950604, -83.48254041393686)
        ),
        Entry(
            "KensingtonMetropark",
            R.drawable.kensington_metro_park,
            R.string.kensington_metropark,
            location = LatLng(42.54113559584593, -83.63744603328288)
        ),
        Entry(
            "MayburyPark",
            R.drawable.maybury_park,
            R.string.maybury_park,
            location = LatLng(42.43527855858436, -83.53399242916169)
        ),
        Entry(
            "SomersetCollection",
            R.drawable.somerset_collection,
            R.string.somerset_collection,
            location = LatLng(42.559789853207626, -83.18389680087212)
        )
    )

    val recommendationsDetroit = listOf<Entry>(
        //Refactor to remove "Park"
        Entry(
            "BelleIslePark",
            R.drawable.belle_isle_park,
            R.string.belle_isle_park,
            location = LatLng(42.34336472018873, -82.97438397164977)
        ),
        Entry(
            "DetroitInstituteOfArts",
            R.drawable.detroit_institute_of_arts,
            R.string.detroit_institute_of_arts,
            location = LatLng(42.35936340278686, -83.06451172971148)
        ),
        //Refactor to DetroitRiverwalk
        Entry(
            "DetroitRiverfront",
            R.drawable.detroit_riverfront,
            R.string.detroit_riverfront,
            location = LatLng(42.334029797002835, -83.02424127898495)
        ),
        Entry(
            "EasternMarket",
            R.drawable.eastern_market,
            R.string.eastern_market,
            location = LatLng(42.34906560316966, -83.0418983997244)
        ),
        Entry(
            "MotownMuseum",
            R.drawable.motown_museum,
            R.string.motown_museum,
            location = LatLng(42.36417930566513, -83.0884868287329)
        ),
        Entry(
            "TheGuardianBuilding",
            R.drawable.the_guardian_building,
            R.string.the_guardian_building,
            location = LatLng(42.32963699022581, -83.0461369288899)
        )
    )

    val recommendationsAnnArbor = listOf<Entry>(
        Entry(
            "AnnArborHandsOnMuseum",
            R.drawable.ann_arbor_hands_on_museum,
            R.string.ann_arbor_hands_on_museum,
            location = LatLng(42.282004058184775, -83.74649937146002)
        ),
        Entry(
            "HudsonMillsMetropark",
            R.drawable.hudson_mills_metropark,
            R.string.hudson_mills_metropark,
            location = LatLng(42.386430314507905, -83.90832085657789)
        ),
        Entry(
            "Kerrytown",
            R.drawable.kerrytown,
            R.string.kerrytown,
            location = LatLng(42.28343232791848, -83.74635813886933)
        ),
        //Specify the coordinates better... where exactly is "Main Street"?
        Entry(
            "MainStreet",
            R.drawable.main_street,
            R.string.main_street,
            location = LatLng(42.27872152616462, -83.74868112778144)
        ),
        Entry(
            "MichiganTheater",
            R.drawable.michigan_theater,
            R.string.michigan_theater,
            location = LatLng(42.27954114651321, -83.74177006601958)
        ),
        Entry(
            "UniversityOfMichigan",
            R.drawable.university_of_michigan,
            R.string.university_of_michigan,
            location = LatLng(42.27817015415796, -83.73825141251517)
        )
    )

    val recommendationsMichiganVacations = listOf<Entry>(
        Entry(
            "Holland",
            R.drawable.holland,
            R.string.holland,
            location = LatLng(42.789510826518175, -86.10922487252215)
        ),
        Entry(
            "IsleRoyaleNationalPark",
            R.drawable.isle_royale_national_park,
            R.string.isle_royale_national_park,
            location = LatLng(48.012256039033666, -88.9083369347119)
        ),
        Entry(
            "MackinacIsland",
            R.drawable.mackinac_island,
            R.string.mackinac_island,
            location = LatLng(45.870133328214344, -84.62800853658662)
        ),
        Entry(
            "Marquette",
            R.drawable.marquette,
            R.string.marquette,
            location = LatLng(46.54336899174402, -87.39579044436807)
        ),
        Entry(
            "Munising",
            R.drawable.munising,
            R.string.munising,
            location = LatLng(46.412153684210764, -86.64812211099301)
        ),
        Entry(
            "TraverseCity",
            R.drawable.traverse_city,
            R.string.traverse_city,
            location = LatLng(44.76382642091356, -85.62100947721916)
        )
    )
}