package com.example.novimichigantour.presentation.bottom_bar_screens

import android.content.ContentValues
import android.util.Log
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
import androidx.compose.ui.unit.sp
import com.example.novimichigantour.R
import com.example.novimichigantour.domain.model.Entry
import com.example.novimichigantour.presentation.NoviUiState
import com.example.novimichigantour.presentation.NoviViewModel
import com.example.novimichigantour.presentation.category_screens.EntryRow
import com.example.novimichigantour.presentation.common.NoviMichiganTourBottomNavigationBar
import com.example.novimichigantour.presentation.common.NoviMichiganTourNavigationDrawer
import com.example.novimichigantour.presentation.common.NoviMichiganTourNavigationRail
import com.example.novimichigantour.presentation.utils.NoviMichiganTourNavigationType
import com.example.novimichigantour.presentation.utils.SelectionType

private object SavedTab {
    val currentTab = SelectionType.Saved
}

@Composable
fun SavedScreen(
    savedCollection: List<Entry>,
    onCardClicked: (Entry) -> Unit,
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit),
    resetCollection: () -> Unit,
    viewModel: NoviViewModel
) {
    val savedRecommendations = viewModel.savedRecommendations

    viewModel.updateSelectedTab(SavedTab.currentTab); Log.d(ContentValues.TAG, "${SavedTab.currentTab}")
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = when (navigationType) {
            NoviMichiganTourNavigationType.BOTTOM_NAVIGATION -> Modifier.padding(bottom = 0.dp)
            NoviMichiganTourNavigationType.NAVIGATION_RAIL -> Modifier.padding(start = 56.dp)
            NoviMichiganTourNavigationType.PERMANENT_NAVIGATION_DRAWER -> Modifier.padding(start = 200.dp)
        }
            .fillMaxHeight(.85f),
    ) {

        if (savedRecommendations.isEmpty()) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = stringResource(id = R.string.saves_appear_here),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
        LazyColumn {
            items(savedCollection) {
                EntryRow(entry = it, onCardClicked)
            }
        }
        if (savedRecommendations.isNotEmpty()) {
            Button(onClick = { resetCollection() }) {
                Text(
                    text = stringResource(R.string.clear_list),
                    fontSize = 20.sp)
            }
        }
    }

    when (navigationType) {
        NoviMichiganTourNavigationType.BOTTOM_NAVIGATION -> NoviMichiganTourBottomNavigationBar(
            currentTab = noviUiState.currentTabSelection,
            onTabPressed = onTabPressed,
        )
        NoviMichiganTourNavigationType.NAVIGATION_RAIL -> NoviMichiganTourNavigationRail(
            currentTab = noviUiState.currentTabSelection,
            onTabPressed = onTabPressed,
        )
        NoviMichiganTourNavigationType.PERMANENT_NAVIGATION_DRAWER -> NoviMichiganTourNavigationDrawer(
            currentTab = noviUiState.currentTabSelection,
            onTabPressed = onTabPressed,
        )
    }
}