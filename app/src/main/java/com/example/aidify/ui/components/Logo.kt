package com.example.aidify.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.example.aidify.R
import com.example.aidify.ui.theme.aidifyTheme

@Composable
fun Logo(
    text: String,
    image: Int,
    width: Dp,
    height: Dp,
    spacer: Dp,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = stringResource(R.string.app_logo_desc),
            modifier = Modifier
                .width(width)
                .height(height)
                .then(modifier),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.padding(spacer))
        Text(
            text = text,
            color = aidifyTheme.colors.secondaryText,
            style = aidifyTheme.typography.headline.copy(
                fontSize = 42.sp
            )
        )
    }
}