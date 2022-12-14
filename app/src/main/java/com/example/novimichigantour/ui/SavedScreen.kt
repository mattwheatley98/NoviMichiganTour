package com.example.novimichigantour.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.novimichigantour.R
import com.example.novimichigantour.data.NavigationItemContent
import com.example.novimichigantour.model.Entry
import com.example.novimichigantour.model.SelectionType
import com.example.novimichigantour.ui.utils.NoviMichiganTourNavigationType

@Composable
fun SavedScreen(
    savedCollection: List<Entry>,
    onCardClicked: (Entry) -> Unit,
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit),
    resetCollection: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        if (noviUiState.savedRecommendations.isEmpty()){
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = stringResource(id = R.string.saves_appear_here),
                textAlign = TextAlign.Center)
            }
        }
        LazyColumn(
            modifier = when (navigationType) {
                NoviMichiganTourNavigationType.BOTTOM_NAVIGATION -> Modifier.padding(bottom = 0.dp)
                NoviMichiganTourNavigationType.NAVIGATION_RAIL -> Modifier.padding(start = 56.dp)
                NoviMichiganTourNavigationType.PERMANENT_NAVIGATION_DRAWER -> Modifier.padding(start = 200.dp)
            }
                .fillMaxHeight(.85f),
        ) {
            items(savedCollection) {
                EntryRow(entry = it, onCardClicked)
            }
        }
        if (noviUiState.savedRecommendations.isNotEmpty()) {
            Button(onClick = { resetCollection() }) {
                Text(text = stringResource(id = R.string.clear_list))
            }

        }

    }

    when (navigationType) {
        NoviMichiganTourNavigationType.BOTTOM_NAVIGATION -> NoviMichiganTourBottomNavigationBar(
            currentTab = noviUiState.currentTabSelection,
            onTabPressed = onTabPressed,
            navigationItemContentList = NavigationItemContent.navigationItemContentList
        )
        NoviMichiganTourNavigationType.NAVIGATION_RAIL -> NoviMichiganTourNavigationRail(
            currentTab = noviUiState.currentTabSelection,
            onTabPressed = onTabPressed,
            navigationItemContentList = NavigationItemContent.navigationItemContentList
        )
        NoviMichiganTourNavigationType.PERMANENT_NAVIGATION_DRAWER -> NoviMichiganTourNavigationDrawer(
            currentTab = noviUiState.currentTabSelection,
            onTabPressed = onTabPressed,
            navigationItemContentList = NavigationItemContent.navigationItemContentList
        )
    }
}