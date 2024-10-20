package com.example.aidify.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.aidify.R
import java.util.*

@Composable
fun LanguageDropdown(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    val currentLanguage = Locale.getDefault().language
    val languages = listOf("English", "Svenska")
    val languageCodes = listOf("en", "sv")
    var selectedLanguage by remember { mutableStateOf(languages[languageCodes.indexOf(currentLanguage)]) }

    Box(modifier = modifier) {
        // Globe icon button
        IconButton(onClick = { expanded = true }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_globe), // Use your globe icon here
                contentDescription = stringResource(id = R.string.select_language)
            )
        }

        // Dropdown menu for languages
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            languages.forEachIndexed { index, language ->
                DropdownMenuItem(onClick = {
                    selectedLanguage = language
                    setAppLocale(languageCodes[index])
                    expanded = false
                }) {
                    Text(text = language)
                }
            }
        }
    }
}

// Function to change the app's locale dynamically
fun setAppLocale(languageCode: String) {
    val locale = Locale(languageCode)
    Locale.setDefault(locale)
    val config = androidx.compose.ui.platform.LocalContext.current.resources.configuration
    config.setLocale(locale)
    androidx.compose.ui.platform.LocalContext.current.createConfigurationContext(config)
}
