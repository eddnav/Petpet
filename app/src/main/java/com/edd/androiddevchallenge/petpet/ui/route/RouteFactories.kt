package com.edd.androiddevchallenge.petpet.ui.route

object PetDetailRouteFactory {
    private val routeBuilder = RouteBuilder(Route.PetDetailRoute)
    fun create(petId: String) = routeBuilder
        .setArg(Route.PetDetailRoute.PET_ARG, petId)
        .build()
}