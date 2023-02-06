package com.example.novimichigantour.presentation.bottom_bar_screens

import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.novimichigantour.R
import com.example.novimichigantour.data.Recommendations.recommendationsAnnArbor
import com.example.novimichigantour.data.Recommendations.recommendationsDetroit
import com.example.novimichigantour.data.Recommendations.recommendationsMichiganVacations
import com.example.novimichigantour.data.Recommendations.recommendationsNearbyAttractions
import com.example.novimichigantour.data.Recommendations.recommendationsParks
import com.example.novimichigantour.data.Recommendations.recommendationsRestaurants
import com.example.novimichigantour.data.Recommendations.recommendationsShopping
import com.example.novimichigantour.data.Recommendations.recommendationsThingsToDo
import com.example.novimichigantour.presentation.NoviUiState
import com.example.novimichigantour.presentation.NoviViewModel
import com.example.novimichigantour.presentation.common.NoviMichiganTourBottomNavigationBar
import com.example.novimichigantour.presentation.common.NoviMichiganTourNavigationDrawer
import com.example.novimichigantour.presentation.common.NoviMichiganTourNavigationRail
import com.example.novimichigantour.presentation.utils.NoviMichiganTourNavigationType
import com.example.novimichigantour.presentation.utils.SelectionType
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

private object MapTab {
    val currentTab = SelectionType.Map
}

@Composable
fun MapScreen(
    navigationType: NoviMichiganTourNavigationType,
    noviUiState: NoviUiState,
    onTabPressed: ((SelectionType) -> Unit),
    parksState: (Boolean) -> Unit,
    shoppingState: (Boolean) -> Unit,
    restaurantsState: (Boolean) -> Unit,
    thingsToDoState: (Boolean) -> Unit,
    nearbyAttractionsState: (Boolean) -> Unit,
    detroitState: (Boolean) -> Unit,
    annArborState: (Boolean) -> Unit,
    michiganVacationsState: (Boolean) -> Unit,
    savedState: (Boolean) -> Unit,
    viewModel: NoviViewModel
) {
    viewModel.updateSelectedTab(MapTab.currentTab); Log.d(ContentValues.TAG, "${MapTab.currentTab}")
    Column(
        modifier = when (navigationType) {
            NoviMichiganTourNavigationType.BOTTOM_NAVIGATION -> Modifier.padding(bottom = 0.dp)
            NoviMichiganTourNavigationType.NAVIGATION_RAIL -> Modifier.padding(start = 56.dp)
            NoviMichiganTourNavigationType.PERMANENT_NAVIGATION_DRAWER -> Modifier.padding(start = 200.dp)
        },
    ) {
        val noviPositionState = LatLng(42.475556473172155, -83.4875781403792)
        GoogleMap(
            modifier = Modifier
                .fillMaxHeight(.70f),
            cameraPositionState = rememberCameraPositionState() {
                position = CameraPosition.fromLatLngZoom(noviPositionState, 10f)
            }
        ) {
            for (location in recommendationsParks) {
                Marker(
                    state = MarkerState(location.location),
                    title = stringResource(location.title),
                    icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN),
                    visible = noviUiState.parksCheckbox
                )
            }
            for (location in recommendationsShopping) {
                Marker(
                    state = MarkerState(location.location),
                    title = stringResource(location.title),
                    icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW),
                    visible = noviUiState.shoppingCheckbox
                )
            }
            for (location in recommendationsRestaurants) {
                Marker(
                    state = MarkerState(location.location),
                    title = stringResource(location.title),
                    icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED),
                    visible = noviUiState.restaurantsCheckbox
                )
            }
            for (location in recommendationsThingsToDo) {
                Marker(
                    state = MarkerState(location.location),
                    title = stringResource(location.title),
                    icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA),
                    visible = noviUiState.thingsToDoCheckbox
                )
            }
            for (location in recommendationsNearbyAttractions) {
                Marker(
                    state = MarkerState(location.location),
                    title = stringResource(location.title),
                    icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE),
                    visible = noviUiState.nearbyAttractionsCheckbox
                )
            }
            for (location in recommendationsDetroit) {
                Marker(
                    state = MarkerState(location.location),
                    title = stringResource(location.title),
                    icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN),
                    visible = noviUiState.detroitCheckbox
                )
            }
            for (location in recommendationsAnnArbor) {
                Marker(
                    state = MarkerState(location.location),
                    title = stringResource(location.title),
                    icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE),
                    visible = noviUiState.annArborCheckbox
                )
            }
            for (location in recommendationsMichiganVacations) {
                Marker(
                    state = MarkerState(location.location),
                    title = stringResource(location.title),
                    icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET),
                    visible = noviUiState.michiganVacationsCheckbox
                )
            }

            for (location in noviUiState.savedRecommendations) {
                Marker(
                    state = MarkerState(location.location),
                    title = stringResource(id = location.title),
                    icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE),
                    visible = noviUiState.savedCheckbox
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        MapMarkerToggleLayout(
            noviUiState = noviUiState,
            parksState = parksState,
            shoppingState = shoppingState,
            restaurantsState = restaurantsState,
            thingsToDoState = thingsToDoState,
            nearbyAttractionsState = nearbyAttractionsState,
            detroitState = detroitState,
            annArborState = annArborState,
            michiganVacationsState = michiganVacationsState,
            savedState = savedState
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

@Composable
fun MapMarkerToggleLayout(
    noviUiState: NoviUiState,
    parksState: (Boolean) -> Unit,
    shoppingState: (Boolean) -> Unit,
    restaurantsState: (Boolean) -> Unit,
    thingsToDoState: (Boolean) -> Unit,
    nearbyAttractionsState: (Boolean) -> Unit,
    detroitState: (Boolean) -> Unit,
    annArborState: (Boolean) -> Unit,
    michiganVacationsState: (Boolean) -> Unit,
    savedState: (Boolean) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        Column() {
            MapMarkerCheckbox(
                text = stringResource(id = R.string.parks),
                onCheckedChange = parksState,
                checked = noviUiState.parksCheckbox
            )
            MapMarkerCheckbox(
                text = stringResource(id = R.string.shopping),
                onCheckedChange = shoppingState,
                noviUiState.shoppingCheckbox
            )
            MapMarkerCheckbox(
                text = stringResource(id = R.string.restaurants),
                onCheckedChange = restaurantsState,
                noviUiState.restaurantsCheckbox
            )
        }
        Column() {
            MapMarkerCheckbox(
                text = stringResource(id = R.string.things_to_do),
                onCheckedChange = thingsToDoState,
                checked = noviUiState.thingsToDoCheckbox
            )
            MapMarkerCheckbox(
                text = stringResource(id = R.string.nearby_attractions),
                onCheckedChange = nearbyAttractionsState,
                checked = noviUiState.nearbyAttractionsCheckbox
            )
            MapMarkerCheckbox(
                text = stringResource(id = R.string.detroit),
                onCheckedChange = detroitState,
                checked = noviUiState.detroitCheckbox
            )
        }
        Column() {
            MapMarkerCheckbox(
                text = stringResource(id = R.string.ann_arbor),
                onCheckedChange = annArborState,
                checked = noviUiState.annArborCheckbox
            )
            MapMarkerCheckbox(
                text = stringResource(id = R.string.michigan_vacations),
                onCheckedChange = michiganVacationsState,
                checked = noviUiState.michiganVacationsCheckbox
            )
            MapMarkerCheckbox(
                text = stringResource(id = R.string.saved),
                onCheckedChange = savedState,
                checked = noviUiState.savedCheckbox
            )
        }
    }
}

//Checklist
@Composable
fun MapMarkerCheckbox(
    text: String,
    onCheckedChange: (Boolean) -> Unit,
    checked: Boolean,
) {
    Card(
        modifier = Modifier
            .width(140.dp)
            .height(50.dp)
            .padding(3.dp)
            .clickable { onCheckedChange(checked) },
        elevation = 4.dp
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                style = MaterialTheme.typography.caption,
                text = text,
                modifier = Modifier.padding(2.dp)
            )
            Spacer(modifier = Modifier.width(3.dp))
            Checkbox(
                checked = checked,
                onCheckedChange = null,
            )
        }

    }
}

