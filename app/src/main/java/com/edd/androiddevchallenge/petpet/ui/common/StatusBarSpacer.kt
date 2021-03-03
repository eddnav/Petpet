package com.edd.androiddevchallenge.petpet.ui.common

 import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dev.chrisbanes.accompanist.insets.statusBarsHeight

@Composable
fun StatusBarSpacer(color: Color = Color.Transparent) {
    Spacer(
        Modifier
            .background(color)
            .statusBarsHeight()
            .fillMaxWidth()
    )
}