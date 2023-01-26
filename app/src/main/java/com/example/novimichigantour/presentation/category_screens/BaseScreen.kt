package com.example.novimichigantour.presentation.category_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.novimichigantour.domain.model.Entry
import com.example.novimichigantour.domain.model.SelectionType
import com.example.novimichigantour.presentation.NoviUiState
import com.example.novimichigantour.presentation.common.NoviMichiganTourBottomNavigationBar
import com.example.novimichigantour.presentation.common.NoviMichiganTourNavigationDrawer
import com.example.novimichigantour.presentation.common.NoviMichiganTourNavigationRail
import com.example.novimichigantour.ui.utils.NoviMichiganTourNavigationType

@Composable
fun BaseScreen(
    collection: List<Entry>,
    onCardClicked: ((Entry) -> Unit),
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit),
) {

    LazyColumn(
        modifier = when (navigationType) {
            NoviMichiganTourNavigationType.BOTTOM_NAVIGATION -> Modifier.padding(bottom = 56.dp)
            NoviMichiganTourNavigationType.NAVIGATION_RAIL -> Modifier.padding(start = 56.dp)
            NoviMichiganTourNavigationType.PERMANENT_NAVIGATION_DRAWER -> Modifier.padding(start = 200.dp)
        },
    ) {
        items(collection) {
            EntryRow(entry = it, onCardClicked)
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

@Composable
fun EntryRow(
    entry: Entry,
    onCardClicked: ((Entry) -> Unit)
) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(8.dp)
            .clickable { onCardClicked(entry) }) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Image(
                painter = painterResource(id = entry.image),
                contentDescription = stringResource(id = entry.text),
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(170.dp)
                    .height(140.dp)
                    .padding(10.dp)
                    .border(1.dp, MaterialTheme.colors.secondary)
            )
            Spacer(modifier = Modifier.padding(6.dp))
            Column(
                modifier = Modifier
            ) {
                Text(
                    text = stringResource(id = entry.text),
                    modifier = Modifier
                        .padding(end = 8.dp)
                )
            }
        }
    }
}


