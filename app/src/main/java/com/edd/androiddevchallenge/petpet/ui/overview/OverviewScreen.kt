package com.edd.androiddevchallenge.petpet.ui.overview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.edd.androiddevchallenge.petpet.R
import com.edd.androiddevchallenge.petpet.ui.theme.darkPink

@Composable
fun OverviewScreen() {
    Column {
        Text(
            text = stringResource(R.string.app_name),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            color = darkPink,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h1
        )
    }
}