package com.edd.androiddevchallenge.petpet.ui.overview

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.edd.androiddevchallenge.petpet.R
import com.edd.androiddevchallenge.petpet.ui.theme.pink

@Composable
fun OverviewScreen() {
    Column {
        Text(
            text = stringResource(R.string.app_name),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            color = pink,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Cursive,
            style = MaterialTheme.typography.h1
        )
        LazyColumn(contentPadding = PaddingValues(16.dp)) {
            items(3) {
                OverviewItem()
                if (it != 3) {
                    Spacer(
                        Modifier
                            .fillParentMaxWidth()
                            .height(16.dp)
                    )
                }
            }
        }
    }
}