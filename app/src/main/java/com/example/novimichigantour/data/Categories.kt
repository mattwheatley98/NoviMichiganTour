package com.example.novimichigantour.data

import com.example.novimichigantour.R
import com.example.novimichigantour.domain.model.Entry

object Categories {
    val categoryData = listOf(
        //Do not need to use the "description" or "LOCATION?" parameters of the Entry class
        Entry(
            "Parks",
            R.drawable.parks,
            R.string.parks
        ),
        Entry(
            "Shopping",
            R.drawable.shopping,
            R.string.shopping
        ),
        Entry(
            "Restaurants",
            R.drawable.restaurants_big,
            R.string.restaurants
        ),
        Entry(
            "ThingsToDo",
            R.drawable.things_to_do,
            R.string.things_to_do
        ),
        Entry(
            "NearbyAttractions",
            R.drawable.nearby_attractions,
            R.string.nearby_attractions
        ),
        Entry(
            "Detroit",
            R.drawable.detroit,
            R.string.detroit
        ),
        Entry(
            "AnnArbor",
            R.drawable.ann_arbor,
            R.string.ann_arbor
        ),
        Entry(
            "MichiganVacations",
            R.drawable.michigan_vacations,
            R.string.michigan_vacations

        )
    )
}