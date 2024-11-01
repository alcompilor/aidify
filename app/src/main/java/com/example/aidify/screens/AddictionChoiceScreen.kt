package com.example.aidify.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.NavigateNext
import androidx.compose.material.icons.outlined.Quiz
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
                    text = stringResource(id = R.string.addiction_drugs),
                    style = aidifyTheme.typography.paragraph.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    ),
                    color = aidifyTheme.colors.primaryText
                )
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = { navController.navigate(Route.UNCOPE.name) },
            enabled = viewModel.continueBtnEnabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = aidifyTheme.colors.accent1,
                contentColor = aidifyTheme.colors.primaryText
            ),
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(vertical = 12.dp)
                .height(50.dp)
        ) {
            Text(
                text = stringResource(id = R.string.continue_button),
                style = aidifyTheme.typography.clickable,
            )
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.NavigateNext,
                contentDescription = null,
                modifier = Modifier.padding(start = 4.dp)
            )
        }

    }
}
