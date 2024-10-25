package com.example.aidify.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.aidify.models.Question
import com.example.aidify.ui.theme.aidifyTheme

@Composable
fun OptionItemList(
    itemTextMap: Map<Question, String>,
    getOptionState: (key: Question) -> Boolean?,
    updateOptionState: (key: Question, state: Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .padding(horizontal = 7.dp)
            .then(modifier)
    ) {
        items(itemTextMap.keys.toList()) { key ->
            itemTextMap[key]?.let {
                OptionItem(
                    key = key,
                    promptText = it,
                    getOptionState = getOptionState,
                    updateOptionState = updateOptionState
                )
            }
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 20.dp, horizontal = 25.dp),
                color = aidifyTheme.colors.primary100,
                thickness = 1.7.dp
            )
        }
    }
}