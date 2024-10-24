package com.example.aidify.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.aidify.R
import com.example.aidify.ui.components.LanguageSpinner

@Composable
fun WelcomeScreen(onNavigate: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // LanguageSpinner
        LanguageSpinner(modifier = Modifier.align(Alignment.TopEnd))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // App title
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(20.dp))

            // "Get Started" Button
            Button(onClick = { onNavigate() }) {
                Text(text = stringResource(id = R.string.get_started))
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}
