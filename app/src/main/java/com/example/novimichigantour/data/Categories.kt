package com.example.novimichigantour.data

import com.example.novimichigantour.R
import com.example.novimichigantour.domain.model.Entry
import com.example.novimichigantour.presentation.utils.NoviMichiganTourScreens

object Categories {
    val categoryData = listOf(
        //Not using the "googleMapsUrl" and "location" parameters of the Entry class
        Entry(
            NoviMichiganTourScreens.Parks.name,
            R.drawable.parks,
            R.string.parks,
        ),
        Entry(
            NoviMichiganTourScreens.Shopping.name,
            R.drawable.shopping,
            R.string.shopping
        ),
        Entry(
            NoviMichiganTourScreens.Restaurants.name,
            R.drawable.restaurants_big,
            R.string.restaurants
        ),
        Entry(
            NoviMichiganTourScreens.ThingsToDo.name,
            R.drawable.things_to_do,
            R.string.things_to_do
        ),
        Entry(
            NoviMichiganTourScreens.NearbyAttractions.name,
            R.drawable.nearby_attractions,
            R.string.nearby_attractions
        ),
        Entry(
            NoviMichiganTourScreens.Detroit.name,
            R.drawable.detroit,
            R.string.detroit
        ),
        Entry(
            NoviMichiganTourScreens.AnnArbor.name,
            R.drawable.ann_arbor,
            R.string.ann_arbor
        ),
        Entry(
            NoviMichiganTourScreens.MichiganVacations.name,
            R.drawable.michigan_vacations,
            R.string.michigan_vacations

        )
    )
}