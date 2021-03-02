package com.edd.androiddevchallenge.petpet.repository

import com.edd.androiddevchallenge.petpet.domain.model.AnimalType
import com.edd.androiddevchallenge.petpet.domain.model.Gender
import com.edd.androiddevchallenge.petpet.domain.model.Pet
import java.time.LocalDate


// TODO: Fix singleton, fake repository :)
object PetRepository {

    private val dogs = listOf(
        Pet(
            AnimalType.DOG,
            "Faye",
            "Collie",
            LocalDate.of(2020, 9, 26),
            Gender.FEMALE,
            listOf("Playful", "Friendly"),
            "https://images.unsplash.com/photo-1536684084687-d5ab14f6f711?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=999&q=80"
        ),
        Pet(
            AnimalType.DOG,
            "Caleb",
            "Pug",
            LocalDate.of(2021, 1, 20),
            Gender.MALE,
            listOf("Lazy", "Puppy", "Playful"),
            "https://images.unsplash.com/photo-1604813539828-11f08d8f32f6?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1932&q=80"
        ),
        Pet(
            AnimalType.DOG,
            "Tina",
            "Golden Retriever",
            LocalDate.of(2019, 12, 20),
            Gender.FEMALE,
            listOf("Curious", "Loyal"),
            "https://images.unsplash.com/photo-1611498491685-abb3e359cf69?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=2102&q=80"
        )
    )

   private val cats = listOf(
        Pet(
            AnimalType.CAT,
            "Dream",
            "Siamese",
            LocalDate.of(2020, 1, 23),
            Gender.FEMALE,
            listOf("Playful", "Friendly"),
            "https://images.unsplash.com/photo-1612537563846-e22eb8e55cc2?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=933&q=80"
        ),
        Pet(
            AnimalType.CAT,
            "Sally",
            "Brittish Shorthair",
            LocalDate.of(2019, 4, 10),
            Gender.FEMALE,
            listOf("Lazy", "Friendly"),
            "https://images.unsplash.com/photo-1548247416-ec66f4900b2e?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=963&q=80"
        )
    )

    private val birds = listOf(
        Pet(
            AnimalType.BIRD,
            "Tee",
            "Conure",
            LocalDate.of(2020, 12, 30),
            Gender.MALE,
            listOf("Playful", "Friendly", "Active"),
            "https://images.unsplash.com/photo-1562054438-9e28c06d1277?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=2689&q=80"
        )
    )

    val pets = listOf(
        dogs,
        cats,
        birds
    ).flatten().shuffled()
}