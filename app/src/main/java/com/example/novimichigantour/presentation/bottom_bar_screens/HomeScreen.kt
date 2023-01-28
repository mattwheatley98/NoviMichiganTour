package com.example.novimichigantour.presentation.bottom_bar_screens

import androidx.compose.runtime.Composable
import com.example.novimichigantour.data.Categories.categoryData
import com.example.novimichigantour.domain.model.Entry
import com.example.novimichigantour.presentation.NoviUiState
import com.example.novimichigantour.presentation.NoviViewModel
import com.example.novimichigantour.presentation.category_screens.BaseScreen
import com.example.novimichigantour.presentation.common.NoviMichiganTourBottomNavigationBar
import com.example.novimichigantour.presentation.common.NoviMichiganTourNavigationDrawer
import com.example.novimichigantour.presentation.common.NoviMichiganTourNavigationRail
import com.example.novimichigantour.presentation.utils.SelectionType
import com.example.novimichigantour.ui.utils.NoviMichiganTourNavigationType

private object HomeTab {
    val currentTab = SelectionType.Home
}

@Composable
fun HomeScreen(
    onCardClicked: ((Entry) -> Unit),
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    viewModel: NoviViewModel,
    onTabPressed: (SelectionType) -> Unit)
{
    viewModel.updateSelectedTab(HomeTab.currentTab)
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

    BaseScreen(
        collection = categoryData,
        onCardClicked = onCardClicked,
        navigationType = navigationType,
        noviUiState = noviUiState,
        onTabPressed = onTabPressed
    )
}



