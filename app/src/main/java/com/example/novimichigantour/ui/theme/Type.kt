package com.example.novimichigantour.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.novimichigantour.R

val Sriracha = FontFamily(
    Font(R.font.sriracha_regular),
)

val Montserrat = FontFamily(
    Font(R.font.montserrat_regular),
    Font(R.font.montserrat_bold)
)

val Typography = Typography(

    body1 = TextStyle(
            fontFamily = Sriracha,
            fontWeight = FontWeight.Normal,
            fontSize = 25.sp
        ),

    )