package com.example.aidify.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.aidify.R
import com.example.aidify.ui.theme.aidifyTheme
import com.example.aidify.utilities.stripSpecialCharacters

@Composable
fun TextSection(
    title: String,
    titleIcon: ImageVector,
    body: String?,
    modifier: Modifier = Modifier
) {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = titleIcon,
                contentDescription = "$title ${stringResource(R.string.section_icon_desc)}",
                tint = aidifyTheme.colors.secondaryText
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = title,
                style = aidifyTheme.typography.section,
                color = aidifyTheme.colors.secondaryText
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = if (!body.isNullOrEmpty()) stripSpecialCharacters(body) else stringResource(R.string.no_data),
            style = aidifyTheme.typography.paragraph,
            color = aidifyTheme.colors.primaryText,
            textAlign = TextAlign.Justify,
            modifier = Modifier.then(modifier)
        )
    }
}