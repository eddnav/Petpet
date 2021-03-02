package com.edd.androiddevchallenge.petpet.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.edd.androiddevchallenge.petpet.R

// TODO: Actually make this usable
@Composable
fun HeartButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    var toggled by remember { mutableStateOf(false) }
    Surface(
        modifier
            .size(40.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                rememberRipple(false)
            ) {
                toggled = !toggled
                onClick()
            },
        shape = CircleShape,
        elevation = 4.dp
    ) {
        Image(
            modifier = Modifier
                .size(32.dp),
            painter = painterResource(if (toggled) {
                R.drawable.ic_heart_filled
            } else {
                R.drawable.ic_heart_outline
            }),
            contentDescription = null,
            contentScale = ContentScale.Inside
        )
    }
}