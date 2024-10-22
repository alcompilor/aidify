package com.example.aidify.ui.theme

import androidx.compose.ui.graphics.Color
import com.example.aidify.models.CustomColorScheme

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
val secondaryDarkText = Color(0xFF8696AC)

/* Background Colors */
val backgroundLight = Color(0xFFF5FAFD)
val backgroundDark = Color(0xFF323742)

/* Accent Colors */
val accent1 = Color(0xFFFFC1A1)
val accent2 = Color(0xFFC1E1C5)
val accent3 = Color(0xFFFFDE71)


// Function to generate light color scheme
fun lightColorScheme(): CustomColorScheme {
    return CustomColorScheme(
        primary100 = primaryLight100,
        primary200 = primaryLight200,
        primary300 = primaryLight300,
        primary400 = primaryLight400,
        primary500 = primaryLight500,
        primaryText = primaryLightText,
        secondaryText = secondaryLightText,
        background = backgroundLight,
        accent1 = accent1,
        accent2 = accent2,
        accent3 = accent3
    )
}

// Function to generate dark color scheme
fun darkColorScheme(): CustomColorScheme {
    return CustomColorScheme(
        primary100 = primaryDark100,
        primary200 = primaryDark200,
        primary300 = primaryDark300,
        primary400 = primaryDark400,
        primary500 = primaryDark500,
        primaryText = primaryDarkText,
        secondaryText = secondaryDarkText,
        background = backgroundDark,
        accent1 = accent1,
        accent2 = accent2,
        accent3 = accent3
    )
}
