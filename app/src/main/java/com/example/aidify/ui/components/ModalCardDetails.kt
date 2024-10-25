package com.example.aidify.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.example.aidify.R
import com.example.aidify.models.EducationalLibraryCard
import com.example.aidify.ui.theme.aidifyTheme

// Popup
@Composable
fun ModalCardDetails(card: EducationalLibraryCard, onClose: () -> Unit) {
    val uriHandler = LocalUriHandler.current
    AlertDialog(
        onDismissRequest = { onClose() },
        confirmButton = {},
        dismissButton = {},
        text = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                LibraryCard(Modifier, card.title, card.mediaType)
                Text(
                    text = "${stringResource(R.string.description)}: ${card.description}",
                    style = aidifyTheme.typography.paragraph,
                    color = aidifyTheme.colors.primaryText,
                    modifier = Modifier.padding(10.dp),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            onClick = {
                                uriHandler.openUri(card.link)
                            },
                            modifier = Modifier
                                .width(100.dp)
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = aidifyTheme.colors.accent1,
                                contentColor = aidifyTheme.colors.primaryText
                            )
                        ) {
                            Text(
                                stringResource(id = R.string.visit_webpage),
                                style = aidifyTheme.typography.clickable
                            )
                        }

                        Button(
                            onClick = onClose,
                            modifier = Modifier
                                .width(100.dp)
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = aidifyTheme.colors.accent3,
                                contentColor = aidifyTheme.colors.primaryText
                            )
                        ) {
                            Text(
                                stringResource(id = R.string.close_btn),
                                style = aidifyTheme.typography.clickable
                            )
                        }
                    }
                }
            }
        },
        properties = DialogProperties(usePlatformDefaultWidth = false),
        containerColor = aidifyTheme.colors.background,
        modifier = Modifier
            .fillMaxWidth(0.9f)
    )
}