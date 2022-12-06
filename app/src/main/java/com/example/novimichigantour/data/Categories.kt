package com.example.novimichigantour.data

import com.example.novimichigantour.R
import com.example.novimichigantour.model.Entry

object Categories {
    val categoryData = listOf<Entry>(
        Entry(
            R.drawable.parks,
            R.string.parks
        ),
        Entry(
            R.drawable.shopping,
            R.string.shopping
        ),
        Entry(
            R.drawable.restaurants,
            R.string.restaurants
        ),
        Entry(
            R.drawable.things_to_do,
            R.string.things_to_do
        ),
        Entry(
            R.drawable.nearby_attractions,
            R.string.nearby_attractions
        ),

        Entry(
            R.drawable.detroit,
            R.string.detroit
        ),
        Entry(
            R.drawable.ann_arbor,
            R.string.ann_arbor
        ),
        Entry(
            R.drawable.michigan_vacations,
            R.string.michigan_vacations
        )
    )
}