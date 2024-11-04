package com.example.aidify.ui.theme

import androidx.compose.ui.graphics.Color
import com.example.aidify.models.CustomColorScheme

/* Base Colors */
val softWhite = Color(0xFFF9F9F9)
val slateBlack = Color(0xFF1C1C1C)

/* Primary Colors (Light Mode) */
val primaryLight100 = Color(0xFFD2E4F2)
val primaryLight200 = Color(0xFFBBD5EC)
val primaryLight300 = Color(0xFFA3C6E6)
val primaryLight400 = Color(0xFF8FB8DD)
val primaryLight500 = Color(0xFF7BAAD3)

/* Primary Colors (Dark Mode) */
val primaryDark100 = Color(0xFF3C4A61)
val primaryDark200 = Color(0xFF34425A)
val primaryDark300 = Color(0xFF2C3A52)
val primaryDark400 = Color(0xFF26354D)
val primaryDark500 = Color(0xFF1F3048)

/* Text Colors (Light Mode) */
val primaryLightText = Color(0xFF202F3D)
val secondaryLightText = Color(0xFF46627A)

/* Text Colors (Dark Mode) */
val primaryDarkText = Color(0xFFC0CAD6)
val secondaryDarkText = Color(0xFF97a5b8)

/* Background Colors */
val backgroundLight = Color(0xFFeef6fc)
val backgroundDark = Color(0xFF1b222e)

/* Accent Colors */
val accent1Light = Color(0xFFb4ddc5)
val accent1Dark = Color(0xFF439263)

val accent2Light = Color(0xFFffe694)
val accent2Dark = Color(0xFFd68b00)

val accent3Light = Color(0xFFeaa9b3)
val accent3Dark = Color(0xFFad2b3f)

val accent4Light = Color(0xFF7BAAD3)
val accent4Dark = Color(0xFF4e6d9e)

/* Disabled Color */
val disabledLight = Color(0xFFdcdedf)
val disabledDark = Color(0xFF737a7c)

// Function to generate light color scheme
fun lightColorScheme(): CustomColorScheme {
    return CustomColorScheme(
        white = softWhite,
        black = slateBlack,
        primary100 = primaryLight100,
        primary200 = primaryLight200,
        primary300 = primaryLight300,
        primary400 = primaryLight400,
        primary500 = primaryLight500,
        primaryText = primaryLightText,
        secondaryText = secondaryLightText,
        background = backgroundLight,
        accent1 = accent1Light,
        accent2 = accent2Light,
        accent3 = accent3Light,
        accent4 = accent4Light,
        disabled = disabledLight
    )
}

// Function to generate dark color scheme
fun darkColorScheme(): CustomColorScheme {
    return CustomColorScheme(
        white = softWhite,
        black = slateBlack,
        primary100 = primaryDark100,
        primary200 = primaryDark200,
        primary300 = primaryDark300,
        primary400 = primaryDark400,
        primary500 = primaryDark500,
        primaryText = primaryDarkText,
        secondaryText = secondaryDarkText,
        background = backgroundDark,
        accent1 = accent1Dark,
        accent2 = accent2Dark,
        accent3 = accent3Dark,
        accent4 = accent4Dark,
        disabled = disabledDark
    )
}
