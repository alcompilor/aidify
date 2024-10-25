package com.example.aidify.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aidify.R
import com.example.aidify.models.CardCategory
import com.example.aidify.models.EducationalLibraryCard
import com.example.aidify.models.Route
import com.example.aidify.ui.components.LibraryCard
import com.example.aidify.ui.components.ModalCardDetails
import com.example.aidify.ui.components.NextScreenBtn
import com.example.aidify.ui.components.PrevScreenBtn
import com.example.aidify.ui.theme.aidifyTheme
import com.example.aidify.viewmodels.EducationalLibraryViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EducationalLibraryScreen(viewModel: EducationalLibraryViewModel, navController: NavController) {
    val cardList by viewModel.cardList.collectAsState()
    val isModalOpen by viewModel.isModalOpen.collectAsState()
    val selectedCard by viewModel.selectedCard.collectAsState()

    var currentTab by remember { mutableStateOf(0) }
    val categoryTabs = listOf("ALCOHOL", "SUBSTANCE")

    if (isModalOpen) {
        selectedCard?.let { card ->
            ModalCardDetails(card = card, onClose = { viewModel.closeModal() })
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopBar(navController = navController)
        TabRow(selectedTabIndex = currentTab) {
            categoryTabs.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = currentTab == index,
                    onClick = { currentTab = index }
                )
            }
        }
        when (currentTab) {
            0 -> AlcoholSection(cardList = cardList, onCardSelected = { viewModel.selectCard(it) })
            1 -> SubstanceSection(cardList = cardList, onCardSelected = { viewModel.selectCard(it) })
        }
    }
}

@Composable
fun TopBar(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        PrevScreenBtn("back", true, navController)

        Text(
            text = stringResource(R.string.educational_library_screen_title),
            style = aidifyTheme.typography.section,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )

        NextScreenBtn("start", true, navController, route = Route.OpenQuestions)
    }
}

@Composable
fun AlcoholSection(cardList: List<EducationalLibraryCard>, onCardSelected: (EducationalLibraryCard) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(cardList.size) { index ->
            val card = cardList[index]
            if (card.category == CardCategory.ALCOHOL) {
                LibraryCard(
                    title = card.title,
                    mediaType = card.mediaType,
                    modifier = Modifier.clickable { onCardSelected(card) }
                )
            }
        }
    }
}

@Composable
fun SubstanceSection(cardList: List<EducationalLibraryCard>, onCardSelected: (EducationalLibraryCard) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(cardList.size) { index ->
            val card = cardList[index]
            if (card.category == CardCategory.SUBSTANCE) {
                LibraryCard(
                    title = card.title,
                    mediaType = card.mediaType,
                    modifier = Modifier.clickable { onCardSelected(card) }
                )
            }
        }
    }
}
