package com.example.aidify.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Assessment
import androidx.compose.material.icons.rounded.Assistant
import androidx.compose.material.icons.rounded.ReportProblem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.aidify.R
import com.example.aidify.viewmodels.SummaryViewModel

@Composable
fun SummaryContent(viewModel: SummaryViewModel) {
    val config = LocalConfiguration.current

    val listHeightFactor =
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) 0.69f else 0.91f

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp)
            .fillMaxHeight(listHeightFactor)
    ) {
        items(1) {
            TextSection(
                title = stringResource(R.string.feedback),
                titleIcon = Icons.Rounded.Assistant,
                body = viewModel.getFeedback()
            )
            Spacer(modifier = Modifier.height(25.dp))
            TextSection(
                title = stringResource(R.string.diagnosis),
                titleIcon = Icons.Rounded.Assessment,
                body = viewModel.getDiagnosis()
            )
            Spacer(modifier = Modifier.height(25.dp))
            TextSection(
                title = stringResource(R.string.risk_of_abuse),
                titleIcon = Icons.Rounded.ReportProblem,
                body = viewModel.getRiskOfAbuse()
            )
        }
    }
}
