package com.example.novimichigantour.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.novimichigantour.R

data class Entry(
    val entryRoute: String,
    @DrawableRes val image: Int,
    @StringRes val text: Int,
    @StringRes val description: Int = R.string.placeholder_text

    )
