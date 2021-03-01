package com.edd.androiddevchallenge.petpet.ui.overview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.edd.androiddevchallenge.petpet.R
import com.edd.androiddevchallenge.petpet.ui.theme.gray
import com.edd.androiddevchallenge.petpet.ui.theme.lightGreen
import dev.chrisbanes.accompanist.coil.CoilImage

// TODO: Make a ConstraintLayout version of this.
@Composable
fun OverviewItem() {
    Box {
        Column {
            Spacer(Modifier.height(8.dp))
            Row {
                Spacer(Modifier.width(100.dp))
                Card(elevation = 4.dp) {
                    Column(
                        modifier = Modifier
                            .defaultMinSize(Dp.Unspecified, 140.dp)
                            .fillMaxWidth()
                            .padding(56.dp, 16.dp, 16.dp, 16.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "Sam",
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                style = MaterialTheme.typography.h3
                            )
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                            ) {
                                Spacer(
                                    Modifier
                                        .fillMaxWidth()
                                )
                            }
                            Image(
                                modifier = Modifier
                                    .size(16.dp, 16.dp),
                                painter = painterResource(R.drawable.ic_dog),
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Image(
                                modifier = Modifier
                                    .size(16.dp, 16.dp),
                                painter = painterResource(R.drawable.ic_male),
                                contentDescription = null
                            )
                        }
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "Breed",
                            color = gray,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.subtitle1
                        )
                        Box(
                            modifier = Modifier
                                .weight(1f)
                        ) {
                            Spacer(
                                Modifier
                                    .fillMaxHeight()
                            )
                        }
                        Text(
                            text = "1 month old",
                            color = gray,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.subtitle1
                        )
                    }
                }
            }
        }
        Card(
            modifier = Modifier
                .size(140.dp),
            elevation = 4.dp,
            backgroundColor = lightGreen
        ) {
            CoilImage(
                fadeIn = true,
                contentDescription = null,
                data = "https://i.dailymail.co.uk/1s/2020/06/29/22/30198268-8472445-image-a-4_1593464962804.jpg",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(MaterialTheme.shapes.medium)
                    .fillMaxSize()
            )
        }
    }
}

@Preview
@Composable
fun OverviewItemPreview() {
    OverviewItem()
}