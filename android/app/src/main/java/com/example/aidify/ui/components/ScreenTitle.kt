package com.example.aidify.ui.components

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
import androidx.compose.ui.unit.dp
import com.example.aidify.ui.theme.aidifyTheme

@Composable
fun ScreenTitle(
    title: String,
    icon: ImageVector = Icons.Rounded.BubbleChart,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 5.dp)
    ) {
        Icon(
            imageVector = icon,
            tint = aidifyTheme.colors.secondaryText,
            contentDescription = "Icon for $title screen",
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = title,
            style = aidifyTheme.typography.headline,
            color = aidifyTheme.colors.secondaryText,
            modifier = Modifier.then(modifier)
        )
    }
}