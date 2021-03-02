package com.edd.androiddevchallenge.petpet.ui.common

import androidx.appcompat.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.edd.androiddevchallenge.petpet.ui.theme.darkGray

@Composable
fun FloatingBackButton(
    modifier: Modifier,
    onClick: () -> Unit
) {
    Card(
        modifier
            .size(40.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                rememberRipple(false)
            ) {
                onClick()
            }
    ) {
        Image(
            modifier = Modifier
                .size(32.dp),
            painter = painterResource(R.drawable.abc_ic_ab_back_material),
            contentDescription = null,
            contentScale = ContentScale.Inside,
            colorFilter = ColorFilter.tint(darkGray)
        )
    }
}