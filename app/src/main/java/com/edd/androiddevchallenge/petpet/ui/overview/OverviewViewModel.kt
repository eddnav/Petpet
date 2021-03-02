package com.edd.androiddevchallenge.petpet.ui.overview

import androidx.lifecycle.ViewModel
import com.edd.androiddevchallenge.petpet.repository.PetRepository

class OverviewViewModel : ViewModel() {
    // TODO: Use dependency injection to get this repository
    // TODO: Use mutableStateOf
    val pets = PetRepository.pets
}