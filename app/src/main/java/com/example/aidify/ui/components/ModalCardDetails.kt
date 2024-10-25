package com.example.aidify.ui.components

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.Popup
import com.example.aidify.R
import com.example.aidify.ui.theme.aidifyTheme
import com.example.aidify.models.EducationalLibraryCard

// Popup
@Composable
fun ModalCardDetails(card: EducationalLibraryCard, onClose: () -> Unit) {
    val uriHandler = LocalUriHandler.current
    AlertDialog(
        onDismissRequest = { onClose() },
        // non-default buttons
        confirmButton = {
            null
        },
        dismissButton = {
            null
        },
        // customized popup
        text = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                LibraryCard(Modifier, card.title, card.mediaType)
                Text(
                    text = "Description: ${card.description}",
                    style = aidifyTheme.typography.paragraph,
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
                            colors = ButtonDefaults.buttonColors(containerColor = aidifyTheme.colors.accent1)
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
                            colors = ButtonDefaults.buttonColors(containerColor = aidifyTheme.colors.accent3)
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
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .background(aidifyTheme.colors.primary100, RoundedCornerShape(12.dp)),
        properties = DialogProperties(usePlatformDefaultWidth = false)
    )
}