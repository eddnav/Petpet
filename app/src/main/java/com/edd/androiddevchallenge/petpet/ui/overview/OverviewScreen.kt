package com.edd.androiddevchallenge.petpet.ui.overview

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.edd.androiddevchallenge.petpet.R
import com.edd.androiddevchallenge.petpet.ui.theme.pink

@Composable
fun OverviewScreen(overviewViewModel: OverviewViewModel) {
    Column {
        DecorationBar()
        Box {
            LazyColumn(contentPadding = PaddingValues(16.dp, 26.dp, 16.dp, 16.dp)) {
                val pets = overviewViewModel.petList
                items(pets.size) {
                    OverviewItem(pets[it])
                    if (it != pets.size - 1) {
                        Spacer(
                            Modifier
                                .fillParentMaxWidth()
                                .height(16.dp)
                        )
                    }
                }
            }
            val gradientBrush = Brush.verticalGradient(
                colors = listOf(Color.White, Color.Transparent)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp)
                    .background(gradientBrush)
            )
        }
    }
}

@Composable
private fun DecorationBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .size(32.dp, 32.dp),
            painter = painterResource(R.drawable.ic_paw),
            contentDescription = null,
            colorFilter = ColorFilter.tint(pink)
        )
        Spacer(modifier = Modifier.width(2.dp))
        Text(
            text = stringResource(R.string.app_name),
            color = pink,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Cursive,
            style = MaterialTheme.typography.h1
        )
    }
}