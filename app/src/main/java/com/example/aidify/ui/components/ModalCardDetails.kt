package com.example.aidify.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import com.example.aidify.R
import com.example.aidify.models.EducationalLibraryCard

@Composable
fun ModalCardDetails(card: EducationalLibraryCard, onClose: () -> Unit) {
    val uriHandler = LocalUriHandler.current

    AlertDialog(
        onDismissRequest = onClose,
        confirmButton = {
            TextButton(onClick = onClose) {
                Text(stringResource(id=R.string.close_btn))
            }
        },
        text = {
            Column {
                Text("Title: ${card.title}")
                Text("Description: ${card.description}")
                TextButton(onClick = {
                    uriHandler.openUri(card.link)
                }) {
                    Text(stringResource(id = R.string.visit_webpage))
                }
            }
        }
    )
}