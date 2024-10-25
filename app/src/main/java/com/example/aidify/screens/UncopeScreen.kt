/*
package com.example.aidify.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Spa
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aidify.R
import com.example.aidify.models.Question
import com.example.aidify.models.Route
import com.example.aidify.ui.components.NextScreenBtn
import com.example.aidify.ui.components.OptionItemList
import com.example.aidify.ui.components.PrevScreenBtn
import com.example.aidify.ui.components.ScreenTitle
import com.example.aidify.viewmodels.UncopeViewModel

@Composable
fun UncopeScreen(viewmodel: UncopeViewModel, navController: NavController) {
    val config = LocalConfiguration.current
    val listHeightFactor =
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) 0.60f else 0.87f

    Column(modifier = Modifier.fillMaxHeight()) {
        ScreenTitle(title = stringResource(R.string.uncope_screen_title), icon = Icons.Outlined.Spa)
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        OptionItemList(
            itemTextMap = getQuestions(),
            getOptionState = viewmodel::getOptionState,
            updateOptionState = viewmodel::updateOptionState,
            modifier = Modifier.fillMaxHeight(listHeightFactor)
        )

        Spacer(modifier = Modifier.weight(1f))

        Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()) {
            PrevScreenBtn(
                text = stringResource(R.string.back_button),
                isEnabled = true,
                navController = navController
            )
            Spacer(Modifier.width(5.dp))
            NextScreenBtn(
                text = stringResource(R.string.symptoms),
                isEnabled = viewmodel.nextScreenBtnEnabled,
                navController = navController,
                route = Route.OpenQuestions
            )
        }
    }
}

@Composable
fun getQuestions(): Map<Question, String> {
    return mapOf(
        Question.Q1 to stringResource(R.string.uncope_question_1),
        Question.Q2 to stringResource(R.string.uncope_question_2),
        Question.Q3 to stringResource(R.string.uncope_question_3),
        Question.Q4 to stringResource(R.string.uncope_question_4),
        Question.Q5 to stringResource(R.string.uncope_question_5),
        Question.Q6 to stringResource(R.string.uncope_question_6),
    )
}*/
