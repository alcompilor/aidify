package com.example.aidify.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocalLibrary
import androidx.compose.material.icons.outlined.Start
import androidx.compose.material.icons.rounded.Category
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aidify.R
import com.example.aidify.models.Route
import com.example.aidify.ui.components.LanguageSpinner
import com.example.aidify.ui.components.NextScreenBtn
import com.example.aidify.ui.components.ScreenTitle
import com.example.aidify.ui.theme.aidifyTheme
import com.example.aidify.utilities.saveLanguagePreference
import com.example.aidify.utilities.updateLocale
import com.example.aidify.viewmodels.WelcomeViewModel

@Composable
fun WelcomeScreen(viewmodel: WelcomeViewModel, navController: NavController) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp)
    ) {
        LanguageSpinner(
            dropdownExpansionState = viewmodel.dropdownExpanded,
            updateDropdownExpansionState = viewmodel::updateDropdownExpansion,
            onLanguageChange = { newLanguageCode ->
                context.updateLocale(newLanguageCode)
                context.saveLanguagePreference(newLanguageCode)
            },
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
                title = stringResource(R.string.app_name),
                icon = Icons.Rounded.Category
            )
            Spacer(modifier = Modifier.padding(3.dp))
            Text(
                text = stringResource(R.string.welcome_headline),
                style = aidifyTheme.typography.subheadline,
                textAlign = TextAlign.Center,
                color = aidifyTheme.colors.secondaryText
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = stringResource(R.string.welcome_subheadline),
                style = aidifyTheme.typography.paragraph,
                color = aidifyTheme.colors.secondaryText,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.padding(20.dp))

            NextScreenBtn(
                text = stringResource(id = R.string.get_started),
                isEnabled = true,
                navController = navController,
                route = Route.OpenQuestions,
                icon = Icons.Outlined.Start
            )

            Spacer(modifier = Modifier.padding(10.dp))

            NextScreenBtn(
                text = stringResource(id = R.string.educational_library),
                isEnabled = true,
                navController = navController,
                route = Route.EducationLibrary,
                icon = Icons.Outlined.LocalLibrary,
            )
        }
    }
}
