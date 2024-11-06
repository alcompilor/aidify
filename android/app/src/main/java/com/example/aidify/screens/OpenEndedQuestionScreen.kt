package com.example.aidify.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PsychologyAlt
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aidify.R
import com.example.aidify.models.Question
import com.example.aidify.models.Route
import com.example.aidify.ui.components.NextScreenBtn
import com.example.aidify.ui.components.OpenQuestion
import com.example.aidify.ui.components.PrevScreenBtn
import com.example.aidify.ui.components.ScreenTitle
import com.example.aidify.viewmodels.OpenEndedViewModel

@Composable
fun OpenEndedQuestionScreen(viewModel: OpenEndedViewModel, navController: NavController) {
    val config = LocalConfiguration.current
    val listHeightFactor =
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) 0.69f else 0.90f

    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier
            .fillMaxSize()
    ) {
        ScreenTitle(
            title = stringResource(R.string.openquestions_screen_title),
            icon = Icons.Rounded.PsychologyAlt
        )

        LazyColumn(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxHeight(listHeightFactor)
        ) {
            items(1) {
                OpenQuestion(
                    question = stringResource(R.string.openquestion_q1),
                    response = viewModel.getAnswer(Question.Q1) ?: "",
                    placeholderText = stringResource(R.string.openquestion_q1_placeholder),
                    onValueChange = { input ->
                        viewModel.updateAnswer(Question.Q1, input)
                    }
                )

                Spacer(modifier = Modifier.height(30.dp))

                OpenQuestion(
                    question = stringResource(R.string.openquestion_q2),
                    response = viewModel.getAnswer(Question.Q2) ?: "",
                    placeholderText = stringResource(R.string.openquestion_q2_placeholder),
                    onValueChange = { input ->
                        viewModel.updateAnswer(Question.Q2, input)
                    }
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            PrevScreenBtn(
                text = stringResource(R.string.back_button),
                isEnabled = true,
                navController = navController,
            )

            NextScreenBtn(
                text = stringResource(R.string.checkup_btn),
                isEnabled = viewModel.nextScreenBtnEnabled,
                navController = navController,
                route = Route.UNCOPE
            )
        }
    }
}
