package com.example.novimichigantour.data

import com.example.novimichigantour.R
import com.example.novimichigantour.domain.model.Entry
import com.example.novimichigantour.presentation.utils.NoviMichiganTourScreens
import com.google.android.gms.maps.model.LatLng

object Recommendations {
    val recommendationsParks = listOf( //For some reason, when the googleMapsUrl parameter is an Integer, providing a string ID will not work. Hardcoding a string URL because of this.
        Entry(
            NoviMichiganTourScreens.BoscoFields.name,
            R.drawable.bosco_fields,
            R.string.bosco_fields,
            "https://www.google.com/maps/place/Bosco+Fields/@42.477885,-83.5196798,17z/data=!3m1!4b1!4m5!3m4!1s0x8824a9aba4a36c57:0xbad46fd710e0b9fe!8m2!3d42.477885!4d-83.5174911",
            location = LatLng(42.477995740538375, -83.51755546965676)
        ),
        Entry(
            NoviMichiganTourScreens.FuerstPark.name,
            R.drawable.fuerst_park,
            R.string.fuerst_park,
            "https://www.google.com/maps/place/Fuerst+Park/@42.4652029,-83.4954588,17z/data=!3m1!4b1!4m5!3m4!1s0x8824aec765688ab7:0x33e41fe74fb70a5c!8m2!3d42.4652029!4d-83.4932701",
            location = LatLng(42.46524165090556, -83.49327743832589)
        ),
        Entry(
            NoviMichiganTourScreens.ItcCorridorTrail.name,
            R.drawable.itc_corridor_trail,
            R.string.itc_corridor_trail,
            "https://www.google.com/maps/place/ITC+Corridor+Regional+Tr,+Novi,+MI/@42.4526569,-83.5375536,17z/data=!3m1!4b1!4m5!3m4!1s0x8824abcd5ad9ba83:0x4aa3c4e63af9fbc2!8m2!3d42.452657!4d-83.5333264",
            location = LatLng(42.43732318907327, -83.54923333928406)
        ),
        Entry(
            NoviMichiganTourScreens.PavilionShorePark.name,
            R.drawable.pavilion_shore_park,
            R.string.pavilion_shore_park,
            "https://www.google.com/maps/place/Pavilion+Shore+Park/@42.5107098,-83.4785923,17z/data=!3m1!4b1!4m5!3m4!1s0x8824af6fc13628c3:0xc0f93c7dfe6213d2!8m2!3d42.5107098!4d-83.4764036",
            location = LatLng(42.51081858155433, -83.47640914748996)

        ),
        Entry(
            NoviMichiganTourScreens.RotaryPark.name,
            R.drawable.rotary_park,
            R.string.rotary_park,
            "https://www.google.com/maps/place/Rotary+Park/@42.4494444,-83.4685776,17z/data=!3m1!4b1!4m5!3m4!1s0x8824ae80db06deef:0x807587fd9986ab2b!8m2!3d42.4494444!4d-83.4663889",
            location = LatLng(42.449513898104875, -83.4664192101664)
        ),
        Entry(
            NoviMichiganTourScreens.WildlifeWoodsPark.name,
            R.drawable.wildlife_woods_park,
            R.string.wildlife_woods_park,
            "https://www.google.com/maps/place/Wildlife+Woods+Park/@42.4840731,-83.5317242,17z/data=!3m1!4b1!4m5!3m4!1s0x8824a91d928a46ed:0x4f617d0edf947b6d!8m2!3d42.4840731!4d-83.5295355",
            location = LatLng(42.48423921424371, -83.52957841000931)
        )
    )

    val recommendationsShopping = listOf(
        Entry(
            NoviMichiganTourScreens.NoviTownCenter.name,
            R.drawable.novi_town_center,
            R.string.novi_town_center,
            "https://www.google.com/maps/place/Novi+Town+Center/@42.4824488,-83.4742764,17z/data=!3m1!4b1!4m5!3m4!1s0x8824af02efbcc417:0x5d05237f8eddcff6!8m2!3d42.4824488!4d-83.4720877",
            location = LatLng(42.48265138416665, -83.47211003422515)
        ),
        Entry(
            NoviMichiganTourScreens.OneWorldMarket.name,
            R.drawable.one_world_market,
            R.string.one_world_market,
            "https://www.google.com/maps/place/One+World+Market/@42.4782207,-83.46953,17z/data=!3m2!4b1!5s0x8824aefeda180325:0x49cdec6fb5b9a727!4m5!3m4!1s0x8824aefed3de8e47:0x703051f15ffc32e3!8m2!3d42.4782207!4d-83.4673413",
            location = LatLng(42.47828409691766, -83.46735252029345)
        ),
        Entry(
            NoviMichiganTourScreens.TwelveMileCrossing.name,
            R.drawable.twelve_mile_crossing,
            R.string.twelve_mile_crossing,
            "https://www.google.com/maps/place/Twelve+Mile+Crossing+at+Fountain+Walk/@42.4906252,-83.485784,17z/data=!3m1!4b1!4m5!3m4!1s0x8824af17cf7648bb:0x4f1665e6f3076aa9!8m2!3d42.4906252!4d-83.4835953",
            location = LatLng(42.49075434626514, -83.48362246442133)
        ),
        Entry(
            NoviMichiganTourScreens.TwelveOaksMall.name,
            R.drawable.twelve_oaks_mall,
            R.string.twelve_oaks_mall,
            "https://www.google.com/maps/place/Twelve+Oaks+Mall/@42.4922478,-83.4741114,17z/data=!3m2!4b1!5s0x8824af062e75f297:0x663c92cccfec03eb!4m5!3m4!1s0x8824af11caeeead7:0x3809750435fcd04b!8m2!3d42.4922478!4d-83.4719227",
            location = LatLng(42.49265630481158, -83.47074248770231)
        ),
        Entry(
            NoviMichiganTourScreens.WestMarketSquare.name,
            R.drawable.west_market_square_shopping_center,
            R.string.west_market_square,
            "https://www.google.com/maps/place/West+Market+Square+Shopping+Center/@42.4929359,-83.5226412,17z/data=!3m1!4b1!4m5!3m4!1s0x8824a8da4f17ddd1:0xd096d1b967d8b62!8m2!3d42.4929359!4d-83.5204525",
            location = LatLng(42.49313615666519, -83.52046511496694)
        ),
        Entry(
            NoviMichiganTourScreens.WestOaksShoppingCenter.name,
            R.drawable.west_oaks_shopping_center,
            R.string.west_oaks_shopping_center,
            "https://www.google.com/maps/place/West+Oaks+I+and+II+Shopping+Center/@42.4938169,-83.4840891,17z/data=!4m5!3m4!1s0x8824af07a6e6dde3:0x514a590b605396b5!8m2!3d42.493813!4d-83.4798619",
            location = LatLng(42.4939158524146, -83.47941124331295)
        )
    )

    val recommendationsRestaurants = listOf(
        Entry(
            NoviMichiganTourScreens.ChoppedOlive.name,
            R.drawable.chopped_olive,
            R.string.chopped_olive,
            "https://www.google.com/maps/place/Chopped+Olive+Modern+Mediterranean-+A+Fast+Casual+Restaurant/@42.4906573,-83.5190207,17z/data=!3m1!4b1!4m5!3m4!1s0x8824a8d0b58b5861:0x62b94e74c95a5038!8m2!3d42.4906378!4d-83.5167615",
            location = LatLng(42.490640570627775, -83.51676258387617)
        ),
        Entry(
            NoviMichiganTourScreens.Fumi.name,
            R.drawable.fumi,
            R.string.fumi,
            "https://www.google.com/maps/place/Fumi+Japanese+Restaurant/@42.4679029,-83.4782155,17z/data=!3m1!4b1!4m5!3m4!1s0x8824aeedf4ffef1d:0xd0c5dfcc3743e572!8m2!3d42.4678971!4d-83.4760856",
            location = LatLng(42.467896780600825, -83.4760863584168)
        ),
        Entry(
            NoviMichiganTourScreens.KuraSushi.name,
            R.drawable.kura_sushi,
            R.string.kura_sushi,
            "https://www.google.com/maps/place/Kura+Revolving+Sushi+Bar/@42.4845126,-83.478463,17z/data=!3m1!4b1!4m5!3m4!1s0x8824afe12e8ec555:0xd57a8caf1a737ecd!8m2!3d42.4845087!4d-83.4762743",
            location = LatLng(42.48450957987158, -83.47627706367264)
        ),
        Entry(
            NoviMichiganTourScreens.NagomiJapaneseRestaurant.name,
            R.drawable.nagomi_japanese_restaurant,
            R.string.nagomi_japanese_restaurant,
            "https://www.google.com/maps/place/Nagomi+Japanese+Restaurant/@42.4772483,-83.4767823,17z/data=!3m1!4b1!4m5!3m4!1s0x8824aee5381033b7:0xebad8bcdde886dc9!8m2!3d42.477242!4d-83.474675",
            location = LatLng(42.47724255072325, -83.47467656794026)
        ),
        Entry(
            NoviMichiganTourScreens.OSushi.name,
            R.drawable.o_sushi,
            R.string.o_sushi,
            "https://www.google.com/maps/place/O'Sushi+Novi+Korean+BBQ/@42.4666329,-83.459161,17z/data=!3m1!4b1!4m5!3m4!1s0x8824ae5c7b9b00af:0x3ff6dd9b1195e65d!8m2!3d42.4667213!4d-83.4569363",
            location = LatLng(42.466718036248075, -83.45693599448482)
        ),
        Entry(
            NoviMichiganTourScreens.SedonaTaphouse.name,
            R.drawable.sedona_taphouse,
            R.string.sedona_taphouse,
            "https://www.google.com/maps/place/Sedona+Taphouse/@42.4912283,-83.4724945,17z/data=!3m2!4b1!5s0x8824af062dd8d76f:0x663c92ccb7d197e6!4m5!3m4!1s0x8824af94b89de789:0x6095d6a1a9e35527!8m2!3d42.4912244!4d-83.4703058",
            location = LatLng(42.491232155940075, -83.47030580025577)
        ),
        Entry(
            NoviMichiganTourScreens.TheBreakfastClub.name,
            R.drawable.the_breakfast_club,
            R.string.the_breakfast_club,
            "https://www.google.com/maps/place/Breakfast+Club+of+Novi/@42.4673973,-83.4781767,17z/data=!3m1!4b1!4m5!3m4!1s0x8824af2ab6c626ef:0xe9e15ac446c2729f!8m2!3d42.4673951!4d-83.4759376",
            location = LatLng(42.4674012717903, -83.47594508462423)
        )
    )

    val recommendationsThingsToDo = listOf(
        Entry(
            NoviMichiganTourScreens.JapaneseFestival.name,
            R.drawable.japanese_festival,
            R.string.japanese_festival,
            "https://www.google.com/maps/place/Japanese+School+of+Detroit/@42.476185,-83.4995783,17z/data=!3m1!4b1!4m5!3m4!1s0x8824aed06841b85f:0xcbfc0de27432d978!8m2!3d42.4761811!4d-83.4973896",
            location = LatLng(42.46312178795753, -83.49231699975749)
        ),
        Entry(
            NoviMichiganTourScreens.LinksOfNovi.name,
            R.drawable.links_of_novi,
            R.string.links_of_novi,
            "https://www.google.com/maps/place/Links+of+Novi/@42.4627944,-83.5458835,17z/data=!3m1!4b1!4m5!3m4!1s0x8824a976ce1b5667:0x5902647f17db2e06!8m2!3d42.4629111!4d-83.543667",
            location = LatLng(42.462909280284975, -83.54366260953968)
        ),
        Entry(
            NoviMichiganTourScreens.MichiganStateFair.name,
            R.drawable.michigan_state_fair,
            R.string.michigan_state_fair,
            "https://www.google.com/maps/place/Michigan+State+Fair/@42.4897883,-83.5060075,17z/data=!3m1!4b1!4m5!3m4!1s0x8824af2bf47909b5:0x6c9d211ea1cd3dff!8m2!3d42.4897844!4d-83.5038188",
            location = LatLng(42.48872010439582, -83.50273687035073)
        ),
        Entry(
            NoviMichiganTourScreens.NoviAthleticClub.name,
            R.drawable.novi_athletic_club,
            R.string.novi_athletic_club,
            "https://www.google.com/maps/place/Novi+Athletic+Club/@42.4617245,-83.4713816,17z/data=!3m1!4b1!4m5!3m4!1s0x8824ae8b6983b387:0xf492a77efb7adc62!8m2!3d42.4617206!4d-83.4691929",
            location = LatLng(42.4617205583397, -83.46919290031396)
        ),
        Entry(
            NoviMichiganTourScreens.SparcArena.name,
            R.drawable.sparc_arena,
            R.string.sparc_arena,
            "https://www.google.com/maps/place/SPARC+Arena/@42.4516927,-83.467044,17z/data=!4m5!3m4!1s0x8824af8c0f8c2125:0x9a32ef0c3e409248!8m2!3d42.4516888!4d-83.4648553",
            location = LatLng(42.45168084231876, -83.46486602944357)
        )
    )

    val recommendationsNearbyAttractions = listOf(
        Entry(
            NoviMichiganTourScreens.DowntownBrighton.name,
            R.drawable.downtown_brighton,
            R.string.downtown_brighton,
            "https://www.google.com/maps/place/Downtown+Brighton/@42.5293619,-83.7826392,17z/data=!3m1!4b1!4m5!3m4!1s0x808fcc9868a6c89b:0xbf158267ff52330b!8m2!3d42.5293694!4d-83.7804118",
            location = LatLng(42.529364625506105, -83.78042785837015)
        ),
        Entry(
            NoviMichiganTourScreens.DowntownNorthville.name,
            R.drawable.downtown_northville,
            R.string.downtown_northville,
            "https://www.google.com/maps/place/Northville,+MI/@42.432782,-83.4841418,16z/data=!4m5!3m4!1s0x8824aba2bc557ca5:0xab04ed8f682e86db!8m2!3d42.4311464!4d-83.4832692",
            location = LatLng(42.43107650974676, -83.48323738184168)
        ),
        Entry(
            NoviMichiganTourScreens.DowntownPlymouth.name,
            R.drawable.downtown_plymouth,
            R.string.downtown_plymouth,
            "https://www.google.com/maps/place/Plymouth,+MI+48170/@42.3715069,-83.4837045,14z/data=!3m1!4b1!4m5!3m4!1s0x8824acd646ed7a09:0xfd86c793d01873f3!8m2!3d42.3714253!4d-83.4702132",
            location = LatLng(42.36978379674894, -83.46941365144089)
        ),
        Entry(
            NoviMichiganTourScreens.HinesPark.name,
            R.drawable.hines_park,
            R.string.hines_park,
            "https://www.google.com/maps/place/Hines+Park/@42.4228722,-83.4867624,17z/data=!3m1!4b1!4m5!3m4!1s0x8824ac40f0802ad9:0x979ab7864e5c2274!8m2!3d42.4228683!4d-83.4825352",
            location = LatLng(42.42288606950604, -83.48254041393686)
        ),
        Entry(
            NoviMichiganTourScreens.KensingtonMetropark.name,
            R.drawable.kensington_metro_park,
            R.string.kensington_metropark,
            "https://www.google.com/maps/place/Kensington+Metropark/@42.5411475,-83.639624,17z/data=!3m1!4b1!4m5!3m4!1s0x882359d062028f7d:0x6236a166e24c0f3c!8m2!3d42.5411436!4d-83.6374353",
            location = LatLng(42.54113559584593, -83.63744603328288)
        ),
        Entry(
            NoviMichiganTourScreens.MayburyPark.name,
            R.drawable.maybury_park,
            R.string.maybury_park,
            "https://www.google.com/maps/place/Maybury+State+Park/@42.4352825,-83.5361704,17z/data=!3m1!4b1!4m5!3m4!1s0x8824abc6818d5baf:0x69d6b46cae490c56!8m2!3d42.4352786!4d-83.5339817",
            location = LatLng(42.43527855858436, -83.53399242916169)
        ),
        Entry(
            NoviMichiganTourScreens.SomersetCollection.name,
            R.drawable.somerset_collection,
            R.string.somerset_collection,
            "https://www.google.com/maps/place/Somerset+Collection/@42.5598096,-83.1860855,17z/data=!3m1!4b1!4m5!3m4!1s0x8824c6956543ac5b:0x15df077104a47e5e!8m2!3d42.5598057!4d-83.1838968",
            location = LatLng(42.559789853207626, -83.18389680087212)
        )
    )

    val recommendationsDetroit = listOf(
        Entry(
            NoviMichiganTourScreens.BelleIslePark.name,
            R.drawable.belle_isle_park,
            R.string.belle_isle_park,
            "https://www.google.com/maps/place/Belle+Isle/@42.3424299,-82.9965721,14z/data=!3m1!4b1!4m5!3m4!1s0x8824d4b2383fbbd3:0x3da444fedb5e0199!8m2!3d42.3432541!4d-82.9743495",
            location = LatLng(42.34336472018873, -82.97438397164977)
        ),
        Entry(
            NoviMichiganTourScreens.DetroitInstituteOfArts.name,
            R.drawable.detroit_institute_of_arts,
            R.string.detroit_institute_of_arts,
            "https://www.google.com/maps/place/Detroit+Institute+of+Arts/@42.3593832,-83.0666897,17z/data=!3m2!4b1!5s0x8824d2bdb8dfcbf7:0x736b10ed45cf41c0!4m5!3m4!1s0x8824d2bdb912a53b:0x6d1f41a6007513b2!8m2!3d42.3593793!4d-83.064501",
            location = LatLng(42.35936340278686, -83.06451172971148)
        ),
        Entry(
            NoviMichiganTourScreens.DetroitRiverfront.name,
            R.drawable.detroit_riverfront,
            R.string.detroit_riverfront,
            "https://www.google.com/maps/place/Detroit+Riverfront/@42.3302792,-83.0393776,17z/data=!3m1!5s0x883b2d27e66023a5:0xe905780da7fbdfca!4m5!3m4!1s0x883b2d27ece21d77:0x14eb716aa95d4cdc!8m2!3d42.3303264!4d-83.0372697",
            location = LatLng(42.334029797002835, -83.02424127898495)
        ),
        Entry(
            NoviMichiganTourScreens.EasternMarket.name,
            R.drawable.eastern_market,
            R.string.eastern_market,
            "https://www.google.com/maps/place/Eastern+Market,+Detroit,+MI/@42.3483418,-83.0444542,16z/data=!3m1!4b1!4m5!3m4!1s0x8824d2d7340e6207:0xc2c7a04fec0e2f10!8m2!3d42.3498127!4d-83.0407979",
            location = LatLng(42.34906560316966, -83.0418983997244)
        ),
        Entry(
            NoviMichiganTourScreens.MotownMuseum.name,
            R.drawable.motown_museum,
            R.string.motown_museum,
            "https://www.google.com/maps/place/Motown+Museum/@42.3641119,-83.0905897,17z/data=!3m1!4b1!4m5!3m4!1s0x8824cd67b78417e7:0x203adac7e8d62d88!8m2!3d42.3641893!4d-83.088481",
            location = LatLng(42.36417930566513, -83.0884868287329)
        ),
        Entry(
            NoviMichiganTourScreens.TheGuardianBuilding.name,
            R.drawable.the_guardian_building,
            R.string.the_guardian_building,
            "https://www.google.com/maps/place/Guardian+Building/@42.329633,-83.0483149,17z/data=!3m2!4b1!5s0x883b2d2fa4fb6487:0x578697918b9a46f1!4m5!3m4!1s0x883b2d25442750b3:0x42b1654e937291d5!8m2!3d42.3296291!4d-83.0461262",
            location = LatLng(42.32963699022581, -83.0461369288899)
        )
    )

    val recommendationsAnnArbor = listOf(
        Entry(
            NoviMichiganTourScreens.AnnArborHandsOnMuseum.name,
            R.drawable.ann_arbor_hands_on_museum,
            R.string.ann_arbor_hands_on_museum,
            "https://www.google.com/maps/place/Ann+Arbor+Hands-On+Museum/@42.282008,-83.7486988,17z/data=!3m2!4b1!5s0x883cae3e09c6110b:0x143a510404fc8e50!4m5!3m4!1s0x883cae3dfde15383:0x49f3f678c538e26f!8m2!3d42.2820041!4d-83.7465101",
            location = LatLng(42.282004058184775, -83.74649937146002)
        ),
        Entry(
            NoviMichiganTourScreens.HudsonMillsMetropark.name,
            R.drawable.hudson_mills_metropark,
            R.string.hudson_mills_metropark,
            "https://www.google.com/maps/place/Hudson+Mills+Metropark/@42.3863196,-83.9104796,17z/data=!3m1!4b1!4m5!3m4!1s0x883cb535a930ce6b:0x7efffb35ed58e020!8m2!3d42.3863157!4d-83.9082909",
            location = LatLng(42.386430314507905, -83.90832085657789)
        ),
        Entry(
            NoviMichiganTourScreens.Kerrytown.name,
            R.drawable.kerrytown,
            R.string.kerrytown,
            "https://www.google.com/maps/place/Kerrytown,+Ann+Arbor,+MI+48104/@42.2851984,-83.7539695,16z/data=!3m1!4b1!4m5!3m4!1s0x883cae166a6a53c3:0xe02cf8add4a95d3d!8m2!3d42.2861702!4d-83.7451466",
            location = LatLng(42.28343232791848, -83.74635813886933)
        ),
        Entry(
            NoviMichiganTourScreens.MainStreet.name,
            R.drawable.main_street,
            R.string.main_street,
            "https://www.google.com/maps/place/S+Main+St,+Michigan/@42.2629958,-83.7525303,16z/data=!4m5!3m4!1s0x883cafcd3a97ffe5:0x65aa55d036492936!8m2!3d42.2620191!4d-83.7502128",
            location = LatLng(42.27872152616462, -83.74868112778144)
        ),
        Entry(
            NoviMichiganTourScreens.MichiganTheater.name,
            R.drawable.michigan_theater,
            R.string.michigan_theater,
            "https://www.google.com/maps/place/Michigan+Theater/@42.2795331,-83.7459817,17z/data=!3m1!4b1!4m5!3m4!1s0x883cae3f70f536bd:0x5fceaacaf34695ed!8m2!3d42.2795292!4d-83.7417545",
            location = LatLng(42.27954114651321, -83.74177006601958)
        ),
        Entry(
            NoviMichiganTourScreens.UniversityOfMichigan.name,
            R.drawable.university_of_michigan,
            R.string.university_of_michigan,
            "https://www.google.com/maps/place/University+of+Michigan/@42.2780475,-83.7404128,17z/data=!3m1!4b1!4m5!3m4!1s0x883cae38e7de1701:0x5ba14e5178e997e3!8m2!3d42.2780436!4d-83.7382241",
            location = LatLng(42.27817015415796, -83.73825141251517)
        )
    )

    val recommendationsMichiganVacations = listOf(
        Entry(
            NoviMichiganTourScreens.Holland.name,
            R.drawable.holland,
            R.string.holland,
            "https://www.google.com/maps/place/Holland,+MI+49423/@42.766012,-86.1420251,13z/data=!3m1!4b1!4m5!3m4!1s0x881992bea18f59f1:0x70e705a6a62359d2!8m2!3d42.7875235!4d-86.1089301",
            location = LatLng(42.789510826518175, -86.10922487252215)
        ),
        Entry(
            NoviMichiganTourScreens.IsleRoyaleNationalPark.name,
            R.drawable.isle_royale_national_park,
            R.string.isle_royale_national_park,
            "https://www.google.com/maps/place/Isle+Royale+National+Park/@48.0010637,-89.1020497,10z/data=!3m1!4b1!4m5!3m4!1s0x4d59831c6c0396a1:0xc272596221a03b5f!8m2!3d47.9958654!4d-88.9092899",
            location = LatLng(48.012256039033666, -88.9083369347119)
        ),
        Entry(
            NoviMichiganTourScreens.MackinacIsland.name,
            R.drawable.mackinac_island,
            R.string.mackinac_island,
            "https://www.google.com/maps/place/Mackinac+Island,+MI+49757/@45.8515586,-84.6377196,14z/data=!3m1!4b1!4m5!3m4!1s0x4d35f189aad9ae85:0xdfba14915cd6c1f7!8m2!3d45.8491796!4d-84.6189339",
            location = LatLng(45.870133328214344, -84.62800853658662)
        ),
        Entry(
            NoviMichiganTourScreens.Marquette.name,
            R.drawable.marquette,
            R.string.marquette,
            "https://www.google.com/maps/place/Marquette,+MI/@46.6103561,-87.5593719,12z/data=!3m1!4b1!4m5!3m4!1s0x4d51df5dc446b685:0x91364aad4c5ac71a!8m2!3d46.5436199!4d-87.3953713",
            location = LatLng(46.54336899174402, -87.39579044436807)
        ),
        Entry(
            NoviMichiganTourScreens.Munising.name,
            R.drawable.munising,
            R.string.munising,
            "https://www.google.com/maps/place/Munising,+MI+49862/@46.4287812,-86.6769527,13z/data=!3m1!4b1!4m5!3m4!1s0x4d4e89267f163487:0xa44d979d2aa6f54b!8m2!3d46.4110574!4d-86.6479361",
            location = LatLng(46.412153684210764, -86.64812211099301)
        ),
        Entry(
            NoviMichiganTourScreens.TraverseCity.name,
            R.drawable.traverse_city,
            R.string.traverse_city,
            "https://www.google.com/maps/place/Traverse+City,+MI/@44.748913,-85.6400267,13z/data=!3m1!4b1!4m5!3m4!1s0x881e32b2d7da29dd:0x47bfdc3f3f745621!8m2!3d44.7630567!4d-85.6206317",
            location = LatLng(44.76382642091356, -85.62100947721916)
        )
    )
}