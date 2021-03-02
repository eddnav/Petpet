package com.edd.androiddevchallenge.petpet.ui.route

sealed class Route {

    abstract val value: String

    object OverviewRoute : Route() {
        override val value = "/overview"
    }

    object PetDetailRoute : Route() {
        const val PET_ARG = "petId"
        override val value = "/pet/{${PET_ARG}}"
    }
}