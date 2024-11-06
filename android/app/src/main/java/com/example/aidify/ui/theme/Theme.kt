package com.example.aidify.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import com.example.aidify.models.AidifyTheme

val LocalMyCustomTheme: ProvidableCompositionLocal<AidifyTheme> =
    compositionLocalOf { AidifyTheme(lightColorScheme(), Typography) }

@Composable
fun AidifyThemeProvider(
    content: @Composable () -> Unit
) {
    val colors = if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()
    val customTheme = AidifyTheme(colors, Typography)

    CompositionLocalProvider(LocalMyCustomTheme provides customTheme) {
        content()
    }
}

val aidifyTheme: AidifyTheme
    @Composable get() = LocalMyCustomTheme.current