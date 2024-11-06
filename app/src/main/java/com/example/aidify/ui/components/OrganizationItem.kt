package com.example.aidify.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.aidify.R
import com.example.aidify.models.Organization
import com.example.aidify.ui.theme.aidifyTheme

@Composable
fun OrganizationItem(organization: Organization) {
    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.spacedBy(7.dp),
        modifier = Modifier
            .fillMaxWidth()
            .background(color = aidifyTheme.colors.primary100, shape = RoundedCornerShape(22.dp))
            .padding(20.dp)
    ) {
        Text(
            text = organization.name,
            style = aidifyTheme.typography.section,
            color = aidifyTheme.colors.primaryText
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("${stringResource(R.string.phone_span)}: ")
                }
                withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                    append(
                        organization.phone
                    )
                }
            },
            style = aidifyTheme.typography.notice,
            color = aidifyTheme.colors.secondaryText,
            modifier = Modifier.clickable {
                val dialIntent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:${organization.phone}")
                }
                if (dialIntent.resolveActivity(context.packageManager) != null) {
                    context.startActivity(dialIntent)
                }
            }
        )

        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("${stringResource(R.string.email_span)}: ")
                }
                withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                    append(
                        organization.email
                    )
                }
            },
            style = aidifyTheme.typography.notice,
            color = aidifyTheme.colors.secondaryText,
            modifier = Modifier.clickable {
                val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:${organization.email}")
                }
                if (emailIntent.resolveActivity(context.packageManager) != null) {
                    context.startActivity(emailIntent)
                }
            }
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("${stringResource(R.string.address_span)}: ")
                }
                append(organization.address)
            },
            style = aidifyTheme.typography.notice,
            color = aidifyTheme.colors.secondaryText
        )

        organization.description?.let {
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("${stringResource(R.string.about_span)}:\n")
                    }
                    append(it)
                },
                style = aidifyTheme.typography.paragraph,
                color = aidifyTheme.colors.secondaryText
            )
        }
        Spacer(modifier = Modifier.height(5.dp))


        organization.website.let { url ->
            if (url.isNotEmpty()) {
                Text(
                    text = stringResource(R.string.visit_website),
                    style = aidifyTheme.typography.clickable,
                    textDecoration = TextDecoration.Underline,
                    color = aidifyTheme.colors.primaryText,
                    modifier = Modifier.clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        if (intent.resolveActivity(context.packageManager) != null) {
                            context.startActivity(intent)
                        }
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(2.dp))
    }
}