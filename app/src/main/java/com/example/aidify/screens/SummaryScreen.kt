package com.example.aidify.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material3.Button
import androidx.compose.material3.Text
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
//import com.example.aidify.ui.theme.aidifyTheme
import com.example.aidify.viewmodels.SummaryViewModel

@Composable
fun SummaryScreen(viewModel: SummaryViewModel, navController: NavController, padding: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ScreenTitle(
            title = stringResource(R.string.summary_screen_title),
            icon = Icons.Filled.Assignment
        )

        Spacer(modifier = Modifier.height(32.dp))


        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    viewModel.generatePdf(navController.context)
                },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(bottom = 16.dp)
            ) {
                Text(text = stringResource(R.string.download_pdf))
            }

            NextScreenBtn(
                text = stringResource(R.string.next_button),
                isEnabled = true,
                navController = navController,
                route = Route.RecommendedResources,
                modifier = Modifier.fillMaxWidth(0.8f)
            )
        }
    }
}

