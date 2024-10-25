package com.example.aidify.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aidify.R
import com.example.aidify.models.Route
import com.example.aidify.ui.components.LanguageSpinner
import com.example.aidify.ui.components.NextScreenBtn
import com.example.aidify.ui.theme.aidifyTheme

@Composable
fun WelcomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LanguageSpinner(modifier = Modifier.align(Alignment.TopEnd))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = stringResource(id = R.string.app_name), // Aidify
                style = aidifyTheme.typography.headline,
                color = aidifyTheme.colors.primaryText
            )

            Spacer(modifier = Modifier.height(20.dp))

            NextScreenBtn(
                text = stringResource(id = R.string.get_started),
                isEnabled = true,
                navController = navController,
                route = Route.OpenQuestions
            )
        }
    }
}
