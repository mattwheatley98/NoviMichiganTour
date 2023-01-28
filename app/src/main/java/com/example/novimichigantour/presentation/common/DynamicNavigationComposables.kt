package com.example.novimichigantour.presentation.common

import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Icon
import androidx.compose.material.NavigationRail
import androidx.compose.material.NavigationRailItem
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.novimichigantour.data.NavigationItemData.navigationItemDataList
import com.example.novimichigantour.presentation.utils.SelectionType

@Composable
fun NoviMichiganTourBottomNavigationBar(
    currentTab: SelectionType,
    onTabPressed: ((SelectionType) -> Unit) = {},
) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxHeight()
    ) {
        BottomNavigation() {
            for (navItem in navigationItemDataList) {
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
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()
    ) {
        NavigationRail() {
            for (navItem in navigationItemDataList) {
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
) {
    PermanentNavigationDrawer(drawerContent = {
        PermanentDrawerSheet(
            modifier = Modifier.width(200.dp)) {
            Column(
                modifier = Modifier
                    .wrapContentWidth()
                    .fillMaxHeight()
                    .padding(12.dp)
            ) {
                for (navItem in navigationItemDataList) {
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
                            selectedContainerColor = Color.Gray

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