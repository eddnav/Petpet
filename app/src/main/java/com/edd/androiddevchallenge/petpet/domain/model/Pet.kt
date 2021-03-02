package com.edd.androiddevchallenge.petpet.domain.model

import java.time.LocalDate
import java.util.*

data class Pet(
    val id: UUID,
    val type: AnimalType,
    val name: String,
    val description: String,
    val breed: String,
    val dateOfBirth: LocalDate,
    val gender: Gender,
    val traits: List<String>,
    val photoUrl: String
)