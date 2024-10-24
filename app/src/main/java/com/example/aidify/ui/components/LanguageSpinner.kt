package com.example.aidify.ui.components

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.aidify.R
import java.util.*

@Composable
fun LanguageSpinner(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val languages = listOf(
        stringResource(id = R.string.language_english),
        stringResource(id = R.string.language_swedish)
    )
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = modifier.wrapContentSize()
    ) {
        IconButton(onClick = {
            expanded = true
        }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_globe),
                contentDescription = stringResource(id = R.string.select_language),
                tint = Color.Unspecified
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            languages.forEach { language ->
                DropdownMenuItem(
                    text = { Text(language) },
                    onClick = {
                        when (language) {
                            context.getString(R.string.language_english) -> setLocale(context, "en")
                            context.getString(R.string.language_swedish) -> setLocale(context, "sv")
                        }
                        expanded = false
                    }
                )
            }
        }
    }
}

fun setLocale(context: Context, languageCode: String) {
    val locale = Locale(languageCode)
    Locale.setDefault(locale)

    val resources = context.resources
    val config = resources.configuration
    config.setLocale(locale)

    context.createConfigurationContext(config)

    (context as? Activity)?.let {
        it.finish()
        it.startActivity(Intent(context, context::class.java))
    }
}
