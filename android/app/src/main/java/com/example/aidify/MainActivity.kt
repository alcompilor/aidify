package com.example.aidify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.aidify.ui.theme.AidifyThemeProvider
import com.example.aidify.ui.theme.aidifyTheme
import com.example.aidify.utilities.getSavedLanguageCode
import com.example.aidify.utilities.updateLocale


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val savedLanguageCode = getSavedLanguageCode() ?: "en"
        updateLocale(savedLanguageCode)

        enableEdgeToEdge()
        setContent {
            AidifyThemeProvider {
                Scaffold(
                    containerColor = aidifyTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    val navController = rememberNavController()
                    Navigator(
                        navController,
                        Modifier
                            .padding(innerPadding)
                            .padding(20.dp)
                    )
                }
            }
        }
    }
}