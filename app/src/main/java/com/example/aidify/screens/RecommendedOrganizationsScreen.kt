package com.example.aidify.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Business
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.aidify.R
import com.example.aidify.models.Organization
import com.example.aidify.models.Route
import com.example.aidify.ui.components.NextScreenBtn
import com.example.aidify.ui.components.ScreenTitle
import com.example.aidify.ui.theme.aidifyTheme
import com.example.aidify.viewmodels.RecommendedOrganizationsViewModel

@Composable
fun RecommendedOrganizationsScreen(
    viewModel: RecommendedOrganizationsViewModel = viewModel(),
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val organizations = viewModel.organizations.collectAsState().value
    val context = LocalContext.current

    Column {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = modifier
                .fillMaxWidth(0.95f)
                .padding(16.dp)
        ) {
            ScreenTitle(
                title = stringResource(R.string.recommended_organizations),
                icon = Icons.Outlined.Business
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(organizations.size) { index ->
                OrganizationItem(organization = organizations[index])
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            NextScreenBtn(
                text = stringResource(R.string.back_to_summary),
                isEnabled = true,
                icon = Icons.Outlined.Business,
                navController = navController,
                route = Route.Summary
            )

            Spacer(modifier = Modifier.height(8.dp))

            NextScreenBtn(
                text = stringResource(R.string.back_to_home),
                isEnabled = true,
                icon = Icons.Outlined.Business,
                navController = navController,
                route = Route.Welcome
            )
        }
    }
}

@Composable
fun OrganizationItem(organization: Organization) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = organization.name,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = aidifyTheme.colors.primaryText
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(text = "Phone: ${organization.phone}", fontSize = 16.sp, color = aidifyTheme.colors.secondaryText)
        Text(text = "Email: ${organization.email}", fontSize = 16.sp, color = aidifyTheme.colors.secondaryText)
        Text(text = "Address: ${organization.address}", fontSize = 16.sp, color = aidifyTheme.colors.secondaryText)

        organization.description?.let {
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = it, fontSize = 16.sp, color = aidifyTheme.colors.secondaryText)
        }

        organization.website.let { url ->
            Text(
                text = stringResource(R.string.visit_website),
                color = aidifyTheme.colors.accent1,
                modifier = Modifier.clickable {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    context.startActivity(intent)
                }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
    }
}
