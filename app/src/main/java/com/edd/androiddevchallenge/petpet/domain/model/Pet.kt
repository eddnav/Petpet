package com.edd.androiddevchallenge.petpet.domain.model

import java.time.LocalDate

data class Pet(
    val type: AnimalType,
    val name: String,
    val breed: String,
    val dateOfBirth: LocalDate,
    val gender: Gender,
    val traits: List<String>,
    val photoUrl: String
)