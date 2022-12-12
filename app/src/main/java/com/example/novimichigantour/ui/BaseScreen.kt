package com.example.novimichigantour.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.NavigationRail
import androidx.compose.material.NavigationRailItem
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.novimichigantour.R
import com.example.novimichigantour.data.SelectionType
import com.example.novimichigantour.model.Entry
import com.example.novimichigantour.ui.utils.NoviMichiganTourNavigationType

@Composable
fun BaseScreen(
    collection: List<Entry>,
    onCardClicked: () -> Unit = {},
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit),
) {

    LazyColumn(
        modifier = when (navigationType) {
            NoviMichiganTourNavigationType.BOTTOM_NAVIGATION -> Modifier.padding(bottom = 60.dp)
            NoviMichiganTourNavigationType.NAVIGATION_RAIL -> Modifier.padding(start = 60.dp)
            NoviMichiganTourNavigationType.PERMANENT_NAVIGATION_DRAWER -> Modifier.padding(start = 200.dp)
        },
    ) {
        items(collection) {
            EntryRow(entry = it, onCardClicked)
        }
    }
    val navigationItemContentList = listOf(
        NavigationItemContent(
            SelectionType.Home,
            icon = Icons.Default.Home,
            R.string.home
        ),
        NavigationItemContent(
            SelectionType.Saved,
            icon = Icons.Default.Favorite,
            R.string.saved
        ),
        NavigationItemContent(
            SelectionType.Map,
            icon = Icons.Default.Place,
            R.string.map
        ),
        NavigationItemContent(
            SelectionType.Extras,
            icon = Icons.Default.Star,
            R.string.extras
        )
    )

    when (navigationType) {
        NoviMichiganTourNavigationType.BOTTOM_NAVIGATION -> NoviMichiganTourBottomNavigationBar(
            currentTab = noviUiState.currentTabSelection,
            onTabPressed = onTabPressed,
            navigationItemContentList = navigationItemContentList
        )
        NoviMichiganTourNavigationType.NAVIGATION_RAIL -> NoviMichiganTourNavigationRail(
            currentTab = noviUiState.currentTabSelection,
            onTabPressed = onTabPressed,
            navigationItemContentList = navigationItemContentList
        )
        NoviMichiganTourNavigationType.PERMANENT_NAVIGATION_DRAWER -> NoviMichiganTourNavigationDrawer(
            currentTab = noviUiState.currentTabSelection,
            onTabPressed = onTabPressed,
            navigationItemContentList = navigationItemContentList
        )
    }
}

var route = ""

@Composable
fun EntryRow(
    entry: Entry,
    onCardClicked: () -> Unit
) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(8.dp)
            .clickable { route = entry.entryRoute; onCardClicked() }) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Image(
                painter = painterResource(id = entry.image),
                contentDescription = stringResource(id = entry.text),
                modifier = Modifier
                    .size(150.dp)
                    .padding(10.dp)
            )
            Spacer(modifier = Modifier.padding(12.dp))
            Column(
                modifier = Modifier
            ) {
                Text(
                    text = stringResource(id = entry.text),
                    modifier = Modifier
                )
            }
        }
    }
}


data class NavigationItemContent(
    val selectionType: SelectionType,
    val icon: ImageVector,
    val text: Int
)

@Composable
fun NoviMichiganTourBottomNavigationBar(
    currentTab: SelectionType,
    onTabPressed: ((SelectionType) -> Unit) = {},
    navigationItemContentList: List<NavigationItemContent>
) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxHeight()
    ) {
        BottomNavigation(

        ) {
            for (navItem in navigationItemContentList) {
                NavigationBarItem(
                    selected = currentTab == navItem.selectionType,
                    onClick = { onTabPressed(navItem.selectionType) },
                    icon = {
                        Icon(
                            imageVector = navItem.icon,
                            contentDescription = stringResource(id = navItem.text),
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun NoviMichiganTourNavigationRail(
    currentTab: SelectionType,
    onTabPressed: (SelectionType) -> Unit = {},
    navigationItemContentList: List<NavigationItemContent>
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()
    ) {
        NavigationRail() {
            for (navItem in navigationItemContentList) {
                NavigationRailItem(
                    selected = currentTab == navItem.selectionType,
                    onClick = { onTabPressed(navItem.selectionType) },
                    icon = {
                        Icon(
                            imageVector = navItem.icon,
                            contentDescription = stringResource(id = navItem.text)
                        )
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoviMichiganTourNavigationDrawer(
    currentTab: SelectionType,
    onTabPressed: (SelectionType) -> Unit = {},
    navigationItemContentList: List<NavigationItemContent>
) {
    PermanentNavigationDrawer(drawerContent = {
        PermanentDrawerSheet(
            modifier = Modifier.width(200.dp)) {
            Column(
                modifier = Modifier
                    .wrapContentWidth()
                    .fillMaxHeight()
                    .background(MaterialTheme.colors.background)
                    .padding(12.dp)
            ) {
                for (navItem in navigationItemContentList) {
                    NavigationDrawerItem(
                        label = { Text(text = stringResource(navItem.text)) },
                        selected = currentTab == navItem.selectionType,
                        onClick = { onTabPressed(navItem.selectionType) },
                        icon = {
                            Icon(
                                imageVector = navItem.icon,
                                contentDescription = stringResource(id = navItem.text)
                            )
                        },
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedContainerColor = Color.Transparent,
                            selectedContainerColor = Color.Gray //Find a better color... use Material Theming too

                        )
                    )
                }
            }
        }
    }
    )
    {
    }
}


