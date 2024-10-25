package com.example.aidify.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.aidify.models.Question
import com.example.aidify.ui.theme.aidifyTheme

@Composable
fun DualOption(
    key: Question,
    positiveLabel: String,
    negativeLabel: String,
    getOptionState: (key: Question) -> Boolean?,
    updateOptionState: (key: Question, state: Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row {
        Button(
            onClick = {
                updateOptionState(key, true)
            },
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(
                contentColor = aidifyTheme.colors.primaryText,
                containerColor = if (getOptionState(key) == true) aidifyTheme.colors.accent3 else aidifyTheme.colors.primary100
            ),
            modifier = Modifier.then(modifier)
        ) {
            Text(text = positiveLabel, style = aidifyTheme.typography.clickable)
        }

        Spacer(modifier = Modifier.width(12.dp))

        Button(
            onClick = {
                updateOptionState(key, false)
            },
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(
                contentColor = aidifyTheme.colors.primaryText,
                containerColor = if (getOptionState(key) == false) aidifyTheme.colors.accent1 else aidifyTheme.colors.primary100
            ),
            modifier = Modifier.then(modifier)
        ) {
            Text(text = negativeLabel, style = aidifyTheme.typography.clickable)
        }
    }
}