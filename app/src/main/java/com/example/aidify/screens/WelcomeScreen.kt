package com.example.aidify.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocalLibrary
import androidx.compose.material.icons.outlined.Start
import androidx.compose.material.icons.rounded.Category
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aidify.R
import com.example.aidify.models.Route
import com.example.aidify.ui.components.LanguageSpinner
import com.example.aidify.ui.components.Logo
import com.example.aidify.ui.components.NextScreenBtn
import com.example.aidify.ui.components.ScreenTitle
import com.example.aidify.ui.theme.aidifyTheme
import com.example.aidify.utilities.saveLanguagePreference
import com.example.aidify.utilities.updateLocale
import com.example.aidify.viewmodels.WelcomeViewModel

@Composable
fun WelcomeScreen(viewmodel: WelcomeViewModel, navController: NavController) {
    val context = LocalContext.current

    LazyColumn(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp)
    ) {
        items(1) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Logo(
                    text = stringResource(R.string.app_name),
                    image = R.drawable.logo_lotusmodellen,
                    width = 122.2.dp,
                    height = 65.dp,
                    spacer = 2.5.dp
                )
                Spacer(modifier = Modifier.padding(6.dp))
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
                    route = Route.Summary,
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

    Box(
        modifier = Modifier
            .fillMaxWidth()
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
    }
}
