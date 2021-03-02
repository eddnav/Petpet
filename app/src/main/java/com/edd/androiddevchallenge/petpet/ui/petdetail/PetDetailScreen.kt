package com.edd.androiddevchallenge.petpet.ui.petdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.edd.androiddevchallenge.petpet.R
import com.edd.androiddevchallenge.petpet.domain.model.AnimalType
import com.edd.androiddevchallenge.petpet.domain.model.Gender
import com.edd.androiddevchallenge.petpet.domain.model.Pet
import com.edd.androiddevchallenge.petpet.domain.model.getAssociatedIconRes
import com.edd.androiddevchallenge.petpet.ui.common.Button
import com.edd.androiddevchallenge.petpet.ui.common.FloatingBackButton
import com.edd.androiddevchallenge.petpet.ui.common.HeartButton
import com.edd.androiddevchallenge.petpet.ui.common.Tags
import com.edd.androiddevchallenge.petpet.ui.theme.darkGray
import com.edd.androiddevchallenge.petpet.ui.theme.gray
import com.edd.androiddevchallenge.petpet.ui.theme.lightGreen
import com.edd.androiddevchallenge.petpet.util.extension.getTimeOldString
import dev.chrisbanes.accompanist.coil.CoilImage
import java.time.LocalDate
import java.util.*

@Composable
fun PetDetailScreen(navController: NavController, viewModel: PetDetailViewModel) {
    PetDetailScreenContent(viewModel.pet, onBackClicked = {
        navController.popBackStack()
    })
}

@Composable
private fun PetDetailScreenContent(pet: Pet, onBackClicked: () -> Unit) {
    Box {
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Box {
                CoilImage(
                    modifier = Modifier
                        .height(320.dp)
                        .background(lightGreen),
                    data = pet.photoUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    fadeIn = true
                )
                Column(
                    Modifier
                        .padding(32.dp, 32.dp)
                ) {
                    Spacer(Modifier.height(200.dp))
                    GeneralInformationPanel(pet)
                }
            }
            Column(
                modifier = Modifier
                    .padding(16.dp, 0.dp, 16.dp, 16.dp)
                    .weight(1f),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Traits",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.h3
                    )
                    Spacer(Modifier.height(16.dp))
                    Tags(tags = pet.traits)
                    Spacer(Modifier.height(24.dp))
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 0.dp, 0.dp, 16.dp),
                        text = pet.description,
                        style = MaterialTheme.typography.body1
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    HeartButton(onClick = {
                        // TODO
                    })
                    Spacer(Modifier.width(32.dp))
                    // TODO: Extract to a primary button composable
                    Button(
                        modifier = Modifier
                            .weight(1f),
                        onClick = {
                            // TODO
                        },
                        text = stringResource(R.string.label_adopt_now)
                    )
                }
            }
        }
    }
    FloatingBackButton(
        modifier = Modifier
            .offset(16.dp, 16.dp),
        onClick = onBackClicked
    )
}

@Composable
private fun GeneralInformationPanel(pet: Pet) {
    Card(
        elevation = 4.dp
    ) {
        Column(
            Modifier
                .defaultMinSize(Dp.Unspecified, 120.dp)
                .padding(16.dp, 16.dp, 16.dp, 16.dp)
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
                    style = MaterialTheme.typography.h2
                )
                Image(
                    modifier = Modifier
                        .size(24.dp, 24.dp),
                    painter = painterResource(pet.gender.getAssociatedIconRes()),
                    contentDescription = null
                )
            }
            Spacer(Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier
                        .size(20.dp, 20.dp),
                    painter = painterResource(pet.type.getAssociatedIconRes()),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(gray)
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text = pet.breed,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.subtitle1
                )
            }
            Spacer(Modifier.height(16.dp))
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

@Composable
@Preview
private fun PetDetailScreenContentPreview() {
    PetDetailScreenContent(
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
        onBackClicked = {}
    )
}