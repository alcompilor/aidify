package com.example.aidify.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aidify.R
import com.example.aidify.models.Route
import com.example.aidify.ui.components.LanguageSpinner
import com.example.aidify.ui.components.NextScreenBtn
import com.example.aidify.ui.components.ScreenTitle
import com.example.aidify.ui.theme.aidifyTheme

@Composable
fun WelcomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp) // Adding horizontal padding for better alignment
    ) {
        // LanguageSpinner positioned in the top-right corner
        LanguageSpinner(modifier = Modifier.align(Alignment.TopEnd))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Screen title using the ScreenTitle component
            ScreenTitle(
                title = stringResource(id = R.string.app_name), // Aidify
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Updated Subheadline with shorter text
            Text(
                text = stringResource(id = R.string.welcome_subheadline), // Shortened subheadline text
                style = aidifyTheme.typography.paragraph.copy(fontWeight = FontWeight.Medium), // Make the text bolder
                color = aidifyTheme.colors.secondaryText, // Use secondary text color from aidifyTheme
                modifier = Modifier.padding(vertical = 16.dp) // Add space around the subheadline
            )

            Spacer(modifier = Modifier.height(20.dp))

            // "Get Started" Button using NextScreenBtn with aidifyTheme colors and typography
            NextScreenBtn(
                text = stringResource(id = R.string.get_started), // Use the "get_started" string resource
                isEnabled = true,
                navController = navController,
                route = Route.OpenQuestions // Navigate to the next route
            )
        }
    }
}
