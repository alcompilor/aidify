package com.example.aidify.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Language
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.aidify.R
import com.example.aidify.ui.theme.aidifyTheme

@Composable
fun LanguageSpinner(
    modifier: Modifier = Modifier,
    dropdownExpansionState: Boolean,
    updateDropdownExpansionState: (value: Boolean) -> Unit,
    onLanguageChange: (String) -> Unit
) {
    val languages = listOf(
        stringResource(id = R.string.language_english) to "en",
        stringResource(id = R.string.language_swedish) to "sv"
    )

    Box(
        modifier = modifier.wrapContentSize(),
        contentAlignment = Alignment.TopEnd
    ) {
        IconButton(onClick = { updateDropdownExpansionState(!dropdownExpansionState) }) {
            Icon(
                imageVector = Icons.Rounded.Language,
                contentDescription = stringResource(id = R.string.select_language),
                tint = aidifyTheme.colors.accent4,
                modifier = Modifier.size(34.dp)
            )
        }

        DropdownMenu(
            expanded = dropdownExpansionState,
            onDismissRequest = { updateDropdownExpansionState(false) },
            modifier = Modifier
                .background(aidifyTheme.colors.primary100)
                .padding(5.dp)
                .clip(shape = RoundedCornerShape(5.dp))
        ) {

            languages.forEach { (language, code) ->
                DropdownMenuItem(
                    text = {
                        Text(
                            language,
                            color = aidifyTheme.colors.primaryText,
                            style = aidifyTheme.typography.notice
                        )
                    },
                    onClick = {
                        updateDropdownExpansionState(false)
                        onLanguageChange(code)
                    }
                )
            }
        }
    }
}
