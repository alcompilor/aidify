package com.example.aidify.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.rounded.Support
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.aidify.R
import com.example.aidify.models.Route
import com.example.aidify.ui.components.NextScreenBtn
import com.example.aidify.ui.components.OrganizationItem
import com.example.aidify.ui.components.PrevScreenBtn
import com.example.aidify.ui.components.ScreenTitle
import com.example.aidify.viewmodels.RecommendedOrganizationsViewModel

@Composable
fun RecommendedOrganizationsScreen(
    viewModel: RecommendedOrganizationsViewModel = viewModel(),
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val organizations = viewModel.organizations.collectAsState().value

    val config = LocalConfiguration.current
    val listHeightFactor =
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) 0.69f else 0.90f

    Column {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = modifier
        ) {
            ScreenTitle(
                title = stringResource(R.string.recommended_organizations),
                icon = Icons.Rounded.Support
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(listHeightFactor)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(organizations.size) { index ->
                OrganizationItem(organization = organizations[index])
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            PrevScreenBtn(
                text = stringResource(R.string.back_button),
                isEnabled = true,
                navController = navController,
            )

            NextScreenBtn(
                text = stringResource(R.string.start_button),
                isEnabled = true,
                icon = Icons.Outlined.Home,
                navController = navController,
                route = Route.Welcome
            )
        }
    }
}
