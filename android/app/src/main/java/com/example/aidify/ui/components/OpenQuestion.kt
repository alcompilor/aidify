package com.example.aidify.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Help
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.aidify.R
import com.example.aidify.ui.theme.aidifyTheme

@Composable
fun OpenQuestion(
    question: String,
    response: String,
    placeholderText: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        Row {
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.Help,
                contentDescription = stringResource(R.string.question_icon_description),
                modifier = Modifier
                    .size(24.dp)
                    .width(24.dp),
                tint = aidifyTheme.colors.accent4
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = question,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start,
                style = aidifyTheme.typography.highlight,
                color = aidifyTheme.colors.secondaryText
            )
        }

        Spacer(modifier = Modifier.padding(12.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(horizontal = 18.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .then(modifier)
        ) {
            OutlinedTextField(
                value = response,
                onValueChange = {
                    onValueChange(it)
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = aidifyTheme.colors.primary200,
                    unfocusedContainerColor = aidifyTheme.colors.primary100,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    unfocusedPlaceholderColor = aidifyTheme.colors.secondaryText,
                    focusedPlaceholderColor = aidifyTheme.colors.secondaryText,
                    focusedTextColor = aidifyTheme.colors.primaryText,
                    cursorColor = aidifyTheme.colors.accent4,
                    unfocusedTextColor = aidifyTheme.colors.primaryText,
                ),
                textStyle = aidifyTheme.typography.input,
                placeholder = {
                    Text(
                        text = placeholderText,
                        style = aidifyTheme.typography.input.copy(
                            fontStyle = FontStyle.Italic
                        ),
                        color = aidifyTheme.colors.secondaryText
                    )
                },
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}