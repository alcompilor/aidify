package com.example.aidify.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForwardIos
import androidx.compose.material.icons.outlined.Quiz
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aidify.R
import com.example.aidify.models.MisuseType
import com.example.aidify.models.Route
import com.example.aidify.ui.components.NextScreenBtn
import com.example.aidify.ui.components.PrevScreenBtn
import com.example.aidify.ui.components.ScreenTitle
import com.example.aidify.ui.theme.aidifyTheme
import com.example.aidify.viewmodels.AddictionChoiceViewModel

@Composable
fun AddictionChoiceScreen(
    navController: NavController,
    viewModel: AddictionChoiceViewModel
) {
    var selectedOption by remember { mutableStateOf(viewModel.getMisuseType()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ScreenTitle(
            title = stringResource(id = R.string.addiction_choice_title),
            icon = Icons.Outlined.Quiz,
            modifier = Modifier.padding(bottom = 25.dp)
        )

        Column(
            modifier = Modifier.fillMaxWidth(0.8f),
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                RadioButton(
                    selected = selectedOption == MisuseType.ALCOHOL,
                    onClick = {
                        selectedOption = MisuseType.ALCOHOL
                        viewModel.setMisuseType(MisuseType.ALCOHOL)
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = aidifyTheme.colors.accent4,
                        unselectedColor = aidifyTheme.colors.secondaryText
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stringResource(id = R.string.addiction_alcohol),
                    style = aidifyTheme.typography.paragraph.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    ),
                    color = aidifyTheme.colors.primaryText
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                RadioButton(
                    selected = selectedOption == MisuseType.SUBSTANCE,
                    onClick = {
                        selectedOption = MisuseType.SUBSTANCE
                        viewModel.setMisuseType(MisuseType.SUBSTANCE)
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = aidifyTheme.colors.accent4,
                        unselectedColor = aidifyTheme.colors.secondaryText
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stringResource(id = R.string.addiction_substance),
                    style = aidifyTheme.typography.paragraph.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    ),
                    color = aidifyTheme.colors.primaryText
                )
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            PrevScreenBtn(
                text = stringResource(id = R.string.back_button),
                isEnabled = true,
                navController = navController
            )


            NextScreenBtn(
                text = stringResource(id = R.string.next_button),
                isEnabled = viewModel.continueBtnEnabled,
                navController = navController,
                route = Route.UNCOPE,
                icon = Icons.AutoMirrored.Rounded.ArrowForwardIos

            )
        }
    }
}
