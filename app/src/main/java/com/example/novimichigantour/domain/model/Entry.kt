package com.example.novimichigantour.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.novimichigantour.R
import com.google.android.gms.maps.model.LatLng

data class Entry(
    val entryRoute: String,
    @DrawableRes val image: Int = R.drawable.marquette,
    @StringRes val text: Int = R.string.placeholder_text,
    @StringRes val description: Int = R.string.placeholder_text,
    val location: LatLng = LatLng(42.475556473172155, -83.4875781403792),
    )
