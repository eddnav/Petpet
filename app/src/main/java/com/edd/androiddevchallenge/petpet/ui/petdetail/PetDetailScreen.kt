package com.edd.androiddevchallenge.petpet.ui.petdetail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.edd.androiddevchallenge.petpet.domain.model.AnimalType
import com.edd.androiddevchallenge.petpet.domain.model.Gender
import com.edd.androiddevchallenge.petpet.domain.model.Pet
import java.time.LocalDate
import java.util.*

@Composable
fun PetDetailScreen(viewModel: PetDetailViewModel) {
    PetDetailScreenContent(viewModel.pet)
}

@Composable
private fun PetDetailScreenContent(pet: Pet) {
    Text(pet.name)
}

@Composable
@Preview
private fun PetDetailScreenContentPreview() {
    PetDetailScreenContent(
        Pet(
            UUID.randomUUID(),
            AnimalType.DOG,
            "Tina",
            "Golden Retriever",
            LocalDate.of(2019, 12, 20),
            Gender.FEMALE,
            listOf(),
            ""
        )
    )
}