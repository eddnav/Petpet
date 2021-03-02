package com.edd.androiddevchallenge.petpet.ui.petdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.edd.androiddevchallenge.petpet.repository.PetRepository

class PetDetailViewModel(private val petId: String): ViewModel() {
    // TODO: Use dependency injection to get this repository
    // TODO: Use mutableStateOf
    val pet = PetRepository.getPet(petId) ?: error("No pet found for id $petId")
}