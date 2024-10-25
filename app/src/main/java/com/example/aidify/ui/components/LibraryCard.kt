package com.example.aidify.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.aidify.R
import com.example.aidify.models.CardMediaType
import com.example.aidify.ui.theme.aidifyTheme
import kotlin.math.round

@Composable
fun LibraryCard(
    modifier: Modifier = Modifier,
    title: String,
    mediaType: CardMediaType,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(4.dp),
    ) {
        Card(
            modifier = modifier
                .size(width = 140.dp, height = 200.dp)
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(aidifyTheme.colors.primary500),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(
                        id = if (mediaType == CardMediaType.ARTICLE)
                            R.drawable.baseline_article_16
                        else
                            R.drawable.baseline_play_circle_16
                    ),
                    contentDescription = (if (mediaType == CardMediaType.ARTICLE)
                        R.string.article_icon_description
                    else
                        R.string.play_icon_description).toString(),
                    tint = MaterialTheme.colorScheme.onSecondary,
                    modifier = Modifier
                        .size(50.dp)
                        .alpha(0.85f)
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = title,
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 4.dp)
        )
    }
}
