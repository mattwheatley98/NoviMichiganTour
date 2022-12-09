package com.example.novimichigantour.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.novimichigantour.model.Entry
import com.example.novimichigantour.ui.theme.NoviMichiganTourTheme

@Composable
fun BaseScreen(
    collection: List<Entry>,
    onCardClicked: () -> Unit = {}
) {

    LazyColumn(
        modifier = Modifier,
    ) {
        items(collection) {
            EntryRow(entry = it, onCardClicked)
        }
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
            .clickable { route = entry.entryRoute; onCardClicked()  }) {
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

@Preview
@Composable
fun CategoriesScreenLightPreview() {
    NoviMichiganTourTheme(darkTheme = false) {
        CategoriesScreen {}
    }
}

@Preview
@Composable
fun CategoriesScreenDarkPreview() {
    NoviMichiganTourTheme(darkTheme = true) {
        CategoriesScreen {}
    }
}