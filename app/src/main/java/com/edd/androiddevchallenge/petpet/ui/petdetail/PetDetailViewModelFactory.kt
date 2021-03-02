package com.edd.androiddevchallenge.petpet.ui.petdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PetDetailViewModelFactory(private val petId: String) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = PetDetailViewModel(petId) as T
}