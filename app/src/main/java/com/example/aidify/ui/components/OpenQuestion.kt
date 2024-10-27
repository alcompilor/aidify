package com.example.aidify.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Help
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.aidify.R
import com.example.aidify.ui.theme.aidifyTheme

@Composable
fun OpenQuestion(
    modifier: Modifier = Modifier,
    question: String,
    response: String,
    placeholderText: String,
    onValueChange: (String) -> Unit
) {
    Row {
        Icon(
            imageVector = Icons.Outlined.Help,
            contentDescription = "Question icon",
            modifier = Modifier
                .size(24.dp)
                .width(24.dp),
            tint = aidifyTheme.colors.primary100
        )
        Text(
            text = question,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            style = aidifyTheme.typography.highlight,
            color = aidifyTheme.colors.secondaryText
        )
    }

    Spacer(modifier = Modifier.padding(12.dp))
    OutlinedTextField(
        value = response,
        onValueChange = {
            onValueChange(it)
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .shadow(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = aidifyTheme.colors.primary200,
            unfocusedContainerColor = aidifyTheme.colors.primary100,
        ),
        textStyle = aidifyTheme.typography.input,
        placeholder = {
            Text(
                text = placeholderText,
                fontStyle = FontStyle.Italic
            )
        }
    )
}