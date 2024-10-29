package com.example.aidify.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.aidify.R
import com.example.aidify.models.Route
import com.example.aidify.ui.theme.aidifyTheme

@Composable
fun ChoiceScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.choose_your_path),
            style = aidifyTheme.typography.headline,
            color = aidifyTheme.colors.primaryText,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = { navController.navigate(Route.UNCOPE.name) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = stringResource(id = R.string.addict_choice))
        }

    }
}
