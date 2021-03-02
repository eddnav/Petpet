package com.edd.androiddevchallenge.petpet.ui.common

import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Button(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .height(48.dp),
        shape = MaterialTheme.shapes.medium,
        onClick = onClick) {
        Text(
            text = text,
            style = MaterialTheme.typography.button
        )
    }
}

