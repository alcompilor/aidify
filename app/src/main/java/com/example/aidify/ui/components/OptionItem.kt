
package com.example.aidify.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.BubbleChart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.aidify.R
import com.example.aidify.models.Question
import com.example.aidify.ui.theme.aidifyTheme

@Composable
fun OptionItem(
    key: Question,
    promptText: String,
    getOptionState: (key: Question) -> Boolean?,
    updateOptionState: (key: Question, state: Boolean) -> Unit,
    icon: ImageVector = Icons.Rounded.BubbleChart,
    positiveLabel: String = stringResource(R.string.binary_option_yes),
    negativeLabel: String = stringResource(R.string.binary_option_no),
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = stringResource(R.string.item_icon_desc),
            tint = aidifyTheme.colors.accent4,
            modifier = Modifier.size(36.dp)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Column {
            Text(
                text = promptText,
                color = aidifyTheme.colors.primaryText,
                style = aidifyTheme.typography.highlight,
                modifier = Modifier.then(modifier)
            )
            Spacer(modifier = Modifier.padding(vertical = 6.dp))
            DualOption(
                key = key,
                positiveLabel = positiveLabel,
                negativeLabel = negativeLabel,
                getOptionState = getOptionState,
                updateOptionState = updateOptionState
            )
        }
    }
}

