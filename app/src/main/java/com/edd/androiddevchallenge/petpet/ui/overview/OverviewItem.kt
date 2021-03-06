package com.edd.androiddevchallenge.petpet.ui.overview

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.edd.androiddevchallenge.petpet.ui.theme.darkGray
import com.edd.androiddevchallenge.petpet.ui.theme.gray
import com.edd.androiddevchallenge.petpet.ui.theme.lightGreen
import com.edd.androiddevchallenge.petpet.util.extension.getTimeOldString
import dev.chrisbanes.accompanist.coil.CoilImage
import java.time.LocalDate
import java.util.*

// TODO: Make a ConstraintLayout version of this.
@Composable
fun OverviewItem(pet: Pet, onClick: (Pet) -> Unit) {
    Box {
        Column {
            Spacer(Modifier.height(8.dp))
            Row {
                Spacer(Modifier.width(100.dp))
                Card(
                    modifier = Modifier
                        // TODO: Card ripple bug?
                        // Seems card do not clip the ripple to their shapes,
                        // probably unintentional.
                        .clickable {
                            onClick(pet)
                        },
                    elevation = 4.dp
                ) {
                    Column(
                        Modifier
                            .defaultMinSize(Dp.Unspecified, 140.dp)
                            .padding(56.dp, 16.dp, 16.dp, 16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = pet.name,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                style = MaterialTheme.typography.h3
                            )
                            Row {
                                Image(
                                    modifier = Modifier
                                        .size(20.dp, 20.dp),
                                    painter = painterResource(pet.type.getAssociatedIconRes()),
                                    contentDescription = null,
                                    colorFilter = ColorFilter.tint(gray)
                                )
                                Spacer(Modifier.width(4.dp))
                                Image(
                                    modifier = Modifier
                                        .size(20.dp, 20.dp),
                                    painter = painterResource(pet.gender.getAssociatedIconRes()),
                                    contentDescription = null
                                )
                            }
                        }
                        Spacer(Modifier.height(2.dp))
                        Column(
                            modifier = Modifier.weight(1f),
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = pet.breed,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                style = MaterialTheme.typography.subtitle1
                            )
                            Text(
                                text = pet.dateOfBirth.getTimeOldString(LocalContext.current),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                style = MaterialTheme.typography.subtitle1,
                                color = darkGray
                            )
                        }
                    }
                }
            }
        }
        Card(
            modifier = Modifier
                .size(140.dp),
            elevation = 4.dp,
            backgroundColor = lightGreen,
        ) {
            CoilImage(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        onClick(pet)
                    },
                data = pet.photoUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                fadeIn = true
            )
        }
    }
}

@Preview
@Composable
private fun OverviewItemPreview() {
    OverviewItem(
        pet = Pet(
            UUID.randomUUID(),
            AnimalType.DOG,
            "Tina",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            "Golden Retriever",
            LocalDate.of(2019, 12, 20),
            Gender.FEMALE,
            listOf(),
            ""
        ),
        onClick = {}
    )
}