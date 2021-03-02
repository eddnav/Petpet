package com.edd.androiddevchallenge.petpet.ui.common

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.edd.androiddevchallenge.petpet.ui.theme.darkGray

@Composable
fun Tags(
    modifier: Modifier = Modifier,
    tags: List<String>
) {
    WrappingRow(
        modifier = modifier,
        verticalGap = 8.dp,
        horizontalGap = 8.dp
    ) {
        tags.forEach {
            Surface(
                shape = MaterialTheme.shapes.small,
                elevation = 4.dp
            ) {
                Text(
                    modifier = Modifier.padding(16.dp, 8.dp),
                    text = it,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = darkGray,
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
    }
}