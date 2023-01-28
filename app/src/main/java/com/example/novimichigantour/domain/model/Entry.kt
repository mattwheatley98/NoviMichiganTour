package com.example.novimichigantour.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.novimichigantour.R
import com.google.android.gms.maps.model.LatLng

data class Entry(
    val entryRoute: String,
    @DrawableRes val image: Int = R.drawable.bosco_fields,
    @StringRes val title: Int = R.string.placeholder_text,
    val googleMapsUrl: String = "https://www.google.com/maps",
    val location: LatLng = LatLng(42.475556473172155, -83.4875781403792),
    )
