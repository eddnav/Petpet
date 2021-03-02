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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.edd.androiddevchallenge.petpet.domain.model.AnimalType
import com.edd.androiddevchallenge.petpet.domain.model.Gender
import com.edd.androiddevchallenge.petpet.domain.model.Pet
import com.edd.androiddevchallenge.petpet.domain.model.getAssociatedIconRes
import com.edd.androiddevchallenge.petpet.ui.theme.gray
import com.edd.androiddevchallenge.petpet.ui.theme.lightGreen
import com.edd.androiddevchallenge.petpet.util.extension.getTimeOldString
import dev.chrisbanes.accompanist.coil.CoilImage
import java.time.LocalDate

// TODO: Make a ConstraintLayout version of this.
@Composable
fun OverviewItem(pet: Pet) {
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
                                text = pet.name,
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
                                painter = painterResource(pet.type.getAssociatedIconRes()),
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(gray)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Image(
                                modifier = Modifier
                                    .size(16.dp, 16.dp),
                                painter = painterResource(pet.gender.getAssociatedIconRes()),
                                contentDescription = null
                            )
                        }
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = pet.breed,
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
                            text = pet.dateOfBirth.getTimeOldString(LocalContext.current),
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
                data = pet.photoUrl,
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
    OverviewItem(
        Pet(
            AnimalType.DOG,
            "Tina",
            "Golden Retriever",
            LocalDate.of(2019, 12, 20),
            Gender.FEMALE,
            listOf("Curious", "Loyal"),
            "https://images.unsplash.com/photo-1611498491685-abb3e359cf69?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=2102&q=80"
        )
    )
}