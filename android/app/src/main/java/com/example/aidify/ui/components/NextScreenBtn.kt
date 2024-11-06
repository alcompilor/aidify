package com.example.aidify.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForwardIos
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aidify.R
import com.example.aidify.models.Route
import com.example.aidify.ui.theme.aidifyTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun NextScreenBtn(
    text: String,
    isEnabled: Boolean,
    navController: NavController,
    route: Route,
    callback: suspend () -> Unit = {},
    icon: ImageVector = Icons.AutoMirrored.Rounded.ArrowForwardIos,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = {
            navController.navigate(route.name)
            CoroutineScope(Dispatchers.Main).launch {
                callback()
            }
        },
        enabled = isEnabled,
        colors = ButtonColors(
            containerColor = aidifyTheme.colors.accent1,
            contentColor = aidifyTheme.colors.primaryText,
            disabledContainerColor = aidifyTheme.colors.disabled,
            disabledContentColor = aidifyTheme.colors.primaryText
        ),
        shape = CircleShape,
        modifier = Modifier.then(modifier)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 10.dp)
        ) {
            Text(
                text = text,
                style = aidifyTheme.typography.clickable
            )
            Spacer(modifier = Modifier.width(7.dp))
            Icon(
                imageVector = icon,
                contentDescription = stringResource(R.string.next_button_desc),
                modifier = Modifier.size(18.dp)
            )
        }
    }
}