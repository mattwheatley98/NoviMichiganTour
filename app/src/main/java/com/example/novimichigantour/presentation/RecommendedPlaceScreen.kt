package com.example.novimichigantour.presentation

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.novimichigantour.R
import com.example.novimichigantour.domain.model.Entry
import com.example.novimichigantour.domain.model.SelectionType
import com.example.novimichigantour.presentation.common.NoviMichiganTourBottomNavigationBar
import com.example.novimichigantour.presentation.common.NoviMichiganTourNavigationDrawer
import com.example.novimichigantour.presentation.common.NoviMichiganTourNavigationRail
import com.example.novimichigantour.ui.utils.NoviMichiganTourNavigationType

@Composable
fun RecommendedPlaceScreen(
    entry: Entry,
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit),
    save: (Entry) -> Unit,
    remove: (Entry) -> Unit
) {
    val context = LocalContext.current
    val displayToast = { text: Int ->
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }
    Column(
        verticalArrangement = Arrangement.spacedBy(1.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.padding(10.dp))
        Image(
            painter = painterResource(id = entry.image),
            contentDescription = stringResource(entry.text),
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .width(300.dp)
                .height(250.dp)
        )
        Text(
            style = MaterialTheme.typography.caption,
            textAlign = TextAlign.Justify,
            text = stringResource(entry.description),
            modifier = Modifier
                .padding(16.dp)
        )
        Row {
            Button(onClick = {
                if (noviUiState.savedRecommendations.contains(entry)) {
                    displayToast(R.string.already_added)
                } else {
                    displayToast(R.string.successfully_added)
                    save(entry)
                }
            }) {
                Text(text = stringResource(R.string.save))
            }
            Spacer(modifier = Modifier.width(10.dp))
            if (noviUiState.savedRecommendations.contains(entry)) {
                Button(onClick = {
                    displayToast(R.string.successfully_removed)
                    remove(entry) }) {
                    Text(text = stringResource(id = R.string.remove))
                }
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
