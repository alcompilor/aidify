package com.example.aidify.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aidify.R
import com.example.aidify.models.Route
import com.example.aidify.ui.components.NextScreenBtn
import com.example.aidify.ui.components.PrevScreenBtn
import com.example.aidify.viewmodels.PilViewModel
import androidx.compose.runtime.*
import com.example.aidify.ui.components.OpenQuestion

@Composable
fun PilScreen(viewModel: PilViewModel, navController: NavController) {
    val buttonEnabled by viewModel.isSummarizeButtonEnabled.collectAsState()
    var response by remember { mutableStateOf("") }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 12.dp)
    ) {
        PrevScreenBtn(
            text = stringResource(R.string.back_button),
            isEnabled = true,
            navController = navController
        )
        NextScreenBtn(
            text = stringResource(R.string.summarize_button),
            isEnabled = buttonEnabled,
            navController = navController,
            route = Route.Summary,
            onTrigger = { viewModel.sendSummary(response) }
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OpenQuestion(
            question = stringResource(R.string.pil_question),
            response = response,
            placeholderText = stringResource(R.string.pil_response_placeholder),
            onValueChange = { input ->
                response = input
                viewModel.enableSummarizeButton(input)
            },
        )
    }
}