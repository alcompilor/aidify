package com.example.aidify.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForwardIos
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aidify.R
import com.example.aidify.models.MisuseType
import com.example.aidify.models.Route
import com.example.aidify.ui.components.NextScreenBtn
import com.example.aidify.ui.components.PrevScreenBtn
import com.example.aidify.ui.theme.aidifyTheme
import com.example.aidify.viewmodels.AddictionChoiceViewModel

@Composable
fun AddictionChoiceScreen(
    navController: NavController,
    viewModel: AddictionChoiceViewModel
) {
    val selectedOption = viewModel.getMisuseType()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.addiction_choice_title),
            style = aidifyTheme.typography.headline,
            color = aidifyTheme.colors.secondaryText,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable { viewModel.setMisuseType(MisuseType.ALCOHOL) }
            ) {
                Box(modifier = Modifier.size(10.dp)) {
                    RadioButton(
                        selected = selectedOption == MisuseType.ALCOHOL,
                        onClick = { viewModel.setMisuseType(MisuseType.ALCOHOL) },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = aidifyTheme.colors.accent4,
                            unselectedColor = aidifyTheme.colors.secondaryText
                        )
                    )
                }
                Spacer(modifier = Modifier.width(13.dp))
                Text(
                    text = stringResource(id = R.string.addiction_alcohol),
                    style = aidifyTheme.typography.highlight,
                    color = aidifyTheme.colors.secondaryText
                )
            }
            Spacer(modifier = Modifier.width(35.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .clickable { viewModel.setMisuseType(MisuseType.SUBSTANCE) }
            ) {
                Box(modifier = Modifier.size(10.dp)) {
                    RadioButton(
                        selected = selectedOption == MisuseType.SUBSTANCE,
                        onClick = { viewModel.setMisuseType(MisuseType.SUBSTANCE) },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = aidifyTheme.colors.accent4,
                            unselectedColor = aidifyTheme.colors.secondaryText
                        )
                    )
                }
                Spacer(modifier = Modifier.width(13.dp))
                Text(
                    text = stringResource(id = R.string.addiction_substance),
                    style = aidifyTheme.typography.highlight,
                    color = aidifyTheme.colors.secondaryText
                )
            }
        }

        Spacer(modifier = Modifier.height(50.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            PrevScreenBtn(
                text = stringResource(id = R.string.back_button),
                isEnabled = true,
                navController = navController
            )
            Spacer(modifier = Modifier.width(20.dp))

            NextScreenBtn(
                text = stringResource(id = R.string.next_button),
                isEnabled = viewModel.continueBtnEnabled,
                navController = navController,
                route = Route.OpenQuestions,
                icon = Icons.AutoMirrored.Rounded.ArrowForwardIos

            )
        }
    }
}
