package com.example.aidify.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Insights
import androidx.compose.material.icons.rounded.Medication
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aidify.R
import com.example.aidify.models.Language
import com.example.aidify.models.Route
import com.example.aidify.ui.components.NextScreenBtn
import com.example.aidify.ui.components.OpenQuestion
import com.example.aidify.ui.components.PrevScreenBtn
import com.example.aidify.ui.components.ScreenTitle
import com.example.aidify.ui.theme.aidifyTheme
import com.example.aidify.utilities.getSavedLanguageCode
import com.example.aidify.viewmodels.StageCheckViewModel

@Composable
fun StageCheckScreen(
    viewModel: StageCheckViewModel,
    navController: NavController,
    process: suspend (lang: Language) -> Unit
) {
    val config = LocalConfiguration.current
    val mainHeightFactor =
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) 0.60f else 0.87f

    val currentLang =
        if (LocalContext.current.getSavedLanguageCode() == "sv") Language.SV else Language.EN

    val buttonEnabled by viewModel.isStageSubmitButtonEnabled.collectAsState()

    Column(modifier = Modifier.fillMaxHeight()) {
        ScreenTitle(
            title = stringResource(R.string.symptoms),
            icon = Icons.Rounded.Medication,
        )
        Spacer(modifier = Modifier.padding(7.dp))
        Text(
            text = stringResource(R.string.symptoms_screen_subheadline),
            style = aidifyTheme.typography.subheadline,
            color = aidifyTheme.colors.secondaryText
        )
        Spacer(modifier = Modifier.padding(35.dp))
        Column(
            modifier = Modifier
                .fillMaxHeight(mainHeightFactor)
        ) {
            OpenQuestion(
                question = stringResource(R.string.stagecheck_question),
                response = viewModel.state.value.symptoms ?: "",
                placeholderText = stringResource(R.string.stagecheck_response_placeholder),
                onValueChange = { input ->
                    viewModel.pushSymptoms(input)
                    viewModel.updateStageSubmitButton(input)
                },
            )
        }

        Spacer(modifier = Modifier.weight(1f))


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
                text = stringResource(R.string.assess_button),
                isEnabled = buttonEnabled,
                navController = navController,
                route = Route.LoadingAI,
                icon = Icons.Rounded.Insights,
                callback = {
                    process(currentLang)
                }
            )
        }
    }
}