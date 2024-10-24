package com.example.aidify.models

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

data class AidifyTheme(
    val colors: CustomColorScheme,
    val typography: CustomTypography
)

data class CustomColorScheme(
    val white: Color,
    val black: Color,
    val primary100: Color,
    val primary200: Color,
    val primary300: Color,
    val primary400: Color,
    val primary500: Color,
    val primaryText: Color,
    val secondaryText: Color,
    val background: Color,
    val accent1: Color,
    val accent2: Color,
    val accent3: Color,
    val disabled: Color,
)

data class CustomTypography(
    val headline: TextStyle,
    val subheadline: TextStyle,
    val section: TextStyle,
    val highlight: TextStyle,
    val input: TextStyle,
    val paragraph: TextStyle,
    val clickable: TextStyle,
    val notice: TextStyle,
    val tag: TextStyle
)
