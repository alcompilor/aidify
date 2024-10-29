package com.example.aidify.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PsychologyAlt
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aidify.R
import com.example.aidify.models.Route
import com.example.aidify.ui.components.NextScreenBtn
import com.example.aidify.ui.components.ScreenTitle

@Composable
fun ChoiceScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        ScreenTitle(
            title = stringResource(id = R.string.choose_your_path),
            modifier = Modifier.padding(top = 20.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {

            NextScreenBtn(
                text = stringResource(id = R.string.addict_choice),
                isEnabled = true,
                navController = navController,
                route = Route.UNCOPE,
                icon = Icons.Outlined.PsychologyAlt,
                modifier = Modifier.weight(1f)
            )
        }
    }
}
