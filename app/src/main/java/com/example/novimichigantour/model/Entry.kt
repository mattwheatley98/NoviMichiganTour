package com.example.novimichigantour.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Entry(
    @DrawableRes val image: Int,
    @StringRes val text: Int
)
