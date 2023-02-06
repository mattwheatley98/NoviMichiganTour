package com.example.novimichigantour.presentation

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.novimichigantour.R
import com.example.novimichigantour.domain.model.Entry
import com.example.novimichigantour.presentation.common.NoviMichiganTourBottomNavigationBar
import com.example.novimichigantour.presentation.common.NoviMichiganTourNavigationDrawer
import com.example.novimichigantour.presentation.common.NoviMichiganTourNavigationRail
import com.example.novimichigantour.presentation.utils.NoviMichiganTourNavigationType
import com.example.novimichigantour.presentation.utils.SelectionType

@Composable
fun RecommendedPlaceScreen(
    entry: Entry,
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit),
    save: (Entry) -> Unit,
    remove: (Entry) -> Unit,
    viewModel: NoviViewModel
) {
    val context = LocalContext.current
    val displayToast = { text: Int ->
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }
    val savedRecommendations = viewModel.savedRecommendations
    val openUrl = Intent(Intent.ACTION_VIEW)
    openUrl.data = Uri.parse(entry.googleMapsUrl)

    Column(
        verticalArrangement = Arrangement.spacedBy(1.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.padding(10.dp))
        Image(
            painter = painterResource(id = entry.image),
            contentDescription = stringResource(entry.title),
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .width(300.dp)
                .height(250.dp)
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Row {
            Button(onClick = {
                if (savedRecommendations.contains(entry)) {
                    displayToast(R.string.already_added)
                } else {
                    displayToast(R.string.successfully_added)
                    save(entry)
                }
            }) {
                Text(
                    text = stringResource(R.string.save),
                    fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            if (savedRecommendations.contains(entry)) {
                Button(onClick = {
                    displayToast(R.string.successfully_removed)
                    remove(entry)
                }) {
                    Text(
                        text = stringResource(R.string.remove),
                        fontSize = 20.sp
                    )
                }
            }
        }
        Text(
            style = MaterialTheme.typography.caption,
            textAlign = TextAlign.Center,
            text = stringResource(R.string.google_maps_text),
            color = MaterialTheme.colors.primary,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
                .clickable { ContextCompat.startActivity(context, openUrl, null) }
        )
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
