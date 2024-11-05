package com.example.aidify.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.aidify.viewmodels.RecommendedOrganizationsViewModel

@Composable
fun RecommendedOrganizationsScreen(
    viewModel: RecommendedOrganizationsViewModel = viewModel(),
    navController: NavController
) {
    val organizations = viewModel.organizations.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = stringResource(R.string.recommended_organizations),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(organizations.size) { index ->
                OrganizationItem(organization = organizations[index])
            }
        }

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = {
                navController.navigate(Route.Summary.name)
            },
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            Text(text = stringResource(R.string.back_to_summary))
        }

        Spacer(modifier = Modifier.height(8.dp))


        Button(
            onClick = {
                navController.navigate(Route.Welcome.name)
            },
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            Text(text = stringResource(R.string.back_to_home))
        }
    }
}

@Composable
fun OrganizationItem(organization: Organization) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Text(
            text = organization.name,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(4.dp))


        Text(
            text = "Phone: ${organization.phone}",
            fontSize = 16.sp,
            color = Color.Gray
        )


        Text(
            text = "Email: ${organization.email}",
            fontSize = 16.sp,
            color = Color.Gray
        )


        Text(
            text = "Address: ${organization.address}",
            fontSize = 16.sp,
            color = Color.Gray
        )


        organization.description?.let { description ->
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = description,
                fontSize = 16.sp,
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.height(8.dp))


        organization.website.let { url ->
            Text(
                text = stringResource(R.string.visit_website),
                color = Color.Blue,
                modifier = Modifier.clickable {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    context.startActivity(intent)
                }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
    }
}
