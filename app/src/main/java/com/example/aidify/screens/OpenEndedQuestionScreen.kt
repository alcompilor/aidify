package com.example.aidify.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.aidify.models.Route
import com.example.aidify.viewmodels.OpenEndedViewModel

@Composable
fun OpenEndedQuestionScreen(viewModel: OpenEndedViewModel = hiltViewModel(), navController: NavController) {
    // Observe the enabled state of the Next button from the ViewModel
    val nextButtonEnabled by remember { derivedStateOf { viewModel.nextScreenBtnEnabled } }

    // Observe the answer input state
    var answer by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Question prompt 1
        Text(
            text = "Describe How your problem look like:",
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // Text input field
        OutlinedTextField(
            value = answer,
            onValueChange = {
                answer = it
                viewModel.updateAnswer(it) // Update ViewModel state
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            label = { Text("Enter your response here") }
        )

        // Next button
        Button(
            onClick = { navController.navigate(Route.Uncope) }, // Navigate to Uncope screen
            enabled = nextButtonEnabled,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .height(50.dp)
        ) {
            Text("Next", fontSize = 16.sp)
        }

        // Progress bar
        LinearProgressIndicator(
            progress = 0.3f,
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .padding(top = 16.dp)
        )
    }
}
