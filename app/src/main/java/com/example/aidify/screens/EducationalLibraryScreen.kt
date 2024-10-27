package com.example.aidify.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocalLibrary
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aidify.R
import com.example.aidify.models.CardCategory
import com.example.aidify.models.Route
import com.example.aidify.ui.components.LibrarySection
import com.example.aidify.ui.components.ModalCardDetails
import com.example.aidify.ui.components.NextScreenBtn
import com.example.aidify.ui.components.PrevScreenBtn
import com.example.aidify.ui.components.ScreenTitle
import com.example.aidify.ui.theme.aidifyTheme
import com.example.aidify.viewmodels.EducationalLibraryViewModel

@Composable
fun EducationalLibraryScreen(viewModel: EducationalLibraryViewModel, navController: NavController) {
    val config = LocalConfiguration.current
    val listHeightFactor =
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) 0.60f else 0.88f

    val cardList by viewModel.cardList.collectAsState()
    val isModalOpen by viewModel.isModalOpen.collectAsState()
    val selectedCard by viewModel.selectedCard.collectAsState()
    val currentTab by viewModel.currentTab.collectAsState()

    val categoryTabs = listOf(
        stringResource(R.string.alcohol_category),
        stringResource(R.string.substance_category)
    )

    if (isModalOpen) {
        selectedCard?.let { card ->
            ModalCardDetails(card = card, onClose = { viewModel.closeModal() })
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ScreenTitle(
            title = stringResource(R.string.educational_library_screen_title),
            icon = Icons.Outlined.LocalLibrary
        )
        TabRow(
            selectedTabIndex = currentTab,
            containerColor = aidifyTheme.colors.primary100,
            contentColor = aidifyTheme.colors.primaryText,
            indicator = { tabPositions ->
                Box(
                    Modifier
                        .tabIndicatorOffset(tabPositions[currentTab])
                        .width(150.dp)
                        .height(3.dp)
                        .background(aidifyTheme.colors.accent4)
                )
            },
            modifier = Modifier
                .padding(vertical = 10.dp)
                .clip(shape = RoundedCornerShape(10.dp))
        ) {
            categoryTabs.forEachIndexed { index, title ->
                Tab(
                    text = {
                        Text(
                            title,
                            style = aidifyTheme.typography.clickable,
                            color = aidifyTheme.colors.secondaryText
                        )
                    },
                    selected = currentTab == index,
                    onClick = { viewModel.switchTab(index) }
                )
            }
        }
        when (currentTab) {
            0 -> LibrarySection(
                cardList = cardList,
                onCardSelected = { viewModel.selectCard(it) },
                category = CardCategory.ALCOHOL,
                modifier = Modifier.fillMaxHeight(listHeightFactor)
            )

            1 -> LibrarySection(
                cardList = cardList,
                onCardSelected = { viewModel.selectCard(it) },
                category = CardCategory.SUBSTANCE,
                modifier = Modifier.fillMaxHeight(listHeightFactor)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth()
        ) {
            PrevScreenBtn(
                text = stringResource(R.string.back_button),
                isEnabled = true,
                navController = navController
            )
            NextScreenBtn(
                text = stringResource(R.string.start_button),
                isEnabled = true,
                navController = navController,
                route = Route.OpenQuestions,
                icon = Icons.Rounded.Home
            )
        }
    }
}