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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.edd.androiddevchallenge.petpet.R
import com.edd.androiddevchallenge.petpet.domain.model.AnimalType
import com.edd.androiddevchallenge.petpet.domain.model.Gender
import com.edd.androiddevchallenge.petpet.domain.model.Pet
import com.edd.androiddevchallenge.petpet.ui.route.PetDetailRouteFactory
import com.edd.androiddevchallenge.petpet.ui.theme.pink
import dev.chrisbanes.accompanist.insets.LocalWindowInsets
import dev.chrisbanes.accompanist.insets.toPaddingValues
import java.time.LocalDate
import java.util.*

// TODO: Image on back navigation bug
// The clicked item seems to be recomposed (?) once back navigation
// to this screen occurs, showing a small flash.
@Composable
fun OverviewScreen(navController: NavController, overviewViewModel: OverviewViewModel) {
    OverviewScreenContent(pets = overviewViewModel.pets, onOverviewItemClick = {
        // TODO: Nav transitions are not working with Compose yet, add some
        navController
            .navigate(PetDetailRouteFactory.create(it.id.toString()))
    })
}

@Composable
private fun OverviewScreenContent(pets: List<Pet>, onOverviewItemClick: (Pet) -> Unit) {
    Column(Modifier.padding(LocalWindowInsets.current.systemBars.toPaddingValues())) {
        DecorationBar()
        Box {
            LazyColumn(contentPadding = PaddingValues(16.dp, 26.dp, 16.dp, 16.dp)) {
                items(pets.size) {
                    OverviewItem(pets[it], onOverviewItemClick)
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
                listOf(Color.White, Color.Transparent)
            )
            Box(
                Modifier
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
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(32.dp, 32.dp),
            painter = painterResource(R.drawable.ic_paw),
            contentDescription = null,
            colorFilter = ColorFilter.tint(pink)
        )
        Spacer(Modifier.width(2.dp))
        Text(
            text = stringResource(R.string.app_name),
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Cursive,
            style = MaterialTheme.typography.h1,
            color = pink
        )
    }
}

@Preview
@Composable
private fun OverviewScreenContentPreview() {
    OverviewScreenContent(
        pets = listOf(
            Pet(
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
            Pet(
                UUID.randomUUID(),
                AnimalType.CAT,
                "Retro",
                "Siamese",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                LocalDate.of(2019, 12, 20),
                Gender.MALE,
                listOf(),
                ""
            )
        ),
        onOverviewItemClick = {}
    )
}