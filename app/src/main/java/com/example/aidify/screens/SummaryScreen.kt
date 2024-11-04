package com.example.aidify.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assignment
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
import com.example.aidify.ui.components.PrevScreenBtn
import com.example.aidify.ui.components.ScreenTitle
import com.example.aidify.ui.theme.aidifyTheme
import com.example.aidify.viewmodels.SummaryViewModel

@Composable
fun SummaryScreen(viewModel: SummaryViewModel, navController: NavController, padding: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {

            Spacer(modifier = Modifier.width(8.dp))
            ScreenTitle(
                title = stringResource(R.string.summary_screen_title),
                icon = Icons.Filled.Assignment
            )

        }

        Text(
            text = stringResource(R.string.summary_description),
            style = aidifyTheme.typography.paragraph,
            color = aidifyTheme.colors.secondaryText,
            modifier = Modifier.padding(16.dp)
        )


        androidx.compose.material3.Button(
            onClick = {
                viewModel.generatePdf(navController.context)
            }
        ) {
            Text(text = stringResource(R.string.download_pdf))
       }


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PrevScreenBtn(
                text = stringResource(R.string.back_button),
                isEnabled = true,
                navController = navController
            )

            NextScreenBtn(
                text = stringResource(R.string.next_button),
                isEnabled = true,
                navController = navController,
                route = Route.RecommendedResources
            )
        }
    }
}
