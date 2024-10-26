package com.example.aidify.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocalLibrary
import androidx.compose.material.icons.outlined.Quiz
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
            .padding(0.dp)
    ) {
        LanguageSpinner(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(6.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ScreenTitle(
                title = stringResource(id = R.string.app_name),
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .offset(x = (-10).dp)
            )

            Text(
                text = stringResource(id = R.string.welcome_subheadline),
                style = aidifyTheme.typography.paragraph.copy(
                    fontWeight = FontWeight.SemiBold
                ),
                color = aidifyTheme.colors.secondaryText,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            Spacer(modifier = Modifier.height(20.dp))

            NextScreenBtn(
                text = stringResource(id = R.string.get_started),
                isEnabled = true,
                navController = navController,
                route = Route.OpenQuestions,
                icon = Icons.Outlined.Quiz
            )

            Spacer(modifier = Modifier.height(16.dp))

            NextScreenBtn(
                text = stringResource(id = R.string.educational_library),
                isEnabled = true,
                navController = navController,
                route = Route.EducationLibrary,
                icon = Icons.Outlined.LocalLibrary
            )
        }
    }
}
