package com.example.aidify.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aidify.R
import com.example.aidify.models.Route
import com.example.aidify.viewmodels.SummaryViewModel
import androidx.compose.foundation.lazy.LazyColumn



@Composable
fun SummaryScreen(viewModel: SummaryViewModel, navController: NavController, padding: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Assignment,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = stringResource(R.string.summary_screen_title),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(32.dp))


        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = stringResource(R.string.feedback),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
                Text(
                    text = viewModel.getFeedback() ?: stringResource(R.string.no_data),
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }
            item {
                Text(
                    text = stringResource(R.string.diagnosis),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
                Text(
                    text = viewModel.getDiagnosis() ?: stringResource(R.string.no_data),
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }
            item {
                Text(
                    text = stringResource(R.string.risk_of_abuse),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
                Text(
                    text = viewModel.getRiskOfAbuse() ?: stringResource(R.string.no_data),
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }
        }

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

            Button(
                onClick = {
                    navController.navigate(Route.RecommendedResources.name)
                },
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text(text = stringResource(R.string.next_button))
            }
        }
    }
}

