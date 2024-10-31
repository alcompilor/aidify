package com.example.aidify.utilities

import android.content.Context
import android.content.res.Configuration
import java.util.Locale

fun Context.saveLanguagePreference(languageCode: String) {
    val sharedPreferences = getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)
    sharedPreferences.edit().putString("language_code", languageCode).apply()
}

fun Context.getSavedLanguageCode(): String? {
    val sharedPreferences = getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)
    return sharedPreferences.getString("language_code", null)
}

fun Context.updateLocale(languageCode: String) {
    val locale = Locale(languageCode)
    Locale.setDefault(locale)
    val config = Configuration(resources.configuration)
    config.setLocale(locale)
    resources.updateConfiguration(config, resources.displayMetrics)
}
