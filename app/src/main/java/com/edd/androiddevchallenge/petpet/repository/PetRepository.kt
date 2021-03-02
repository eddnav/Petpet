package com.edd.androiddevchallenge.petpet.repository

import com.edd.androiddevchallenge.petpet.domain.model.AnimalType
import com.edd.androiddevchallenge.petpet.domain.model.Gender
import com.edd.androiddevchallenge.petpet.domain.model.Pet
import java.time.LocalDate
import java.util.*


// TODO: Move away from this singleton, fake repository :)
object PetRepository {

    private val dogs = listOf(
        Pet(
            UUID.randomUUID(),
            AnimalType.DOG,
            "Faye",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                    "Sed viverra fermentum lorem ac facilisis. " +
                    "Curabitur nisl orci, posuere eu vehicula sed, tempor ac est. " +
                    "Duis id leo eu quam rutrum feugiat. " +
                    "Sed sodales urna metus, quis semper mauris viverra ac.",
            "Collie",
            LocalDate.of(2020, 9, 26),
            Gender.FEMALE,
            listOf("Playful", "Friendly"),
            "https://images.unsplash.com/photo-1536684084687-d5ab14f6f711?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=999&q=80"
        ),
        Pet(
            UUID.randomUUID(),
            AnimalType.DOG,
            "Caleb",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                    "Sed viverra fermentum lorem ac facilisis. " +
                    "Sed sodales urna metus, quis semper mauris viverra ac.",
            "Pug",
            LocalDate.of(2021, 1, 20),
            Gender.MALE,
            listOf("Lazy", "Puppy", "Playful"),
            "https://images.unsplash.com/photo-1604813539828-11f08d8f32f6?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1932&q=80"
        ),
        Pet(
            UUID.randomUUID(),
            AnimalType.DOG,
            "Tina",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                    "Sed viverra fermentum lorem ac facilisis. " +
                    "Sed sodales urna metus, quis semper mauris viverra ac.",
            "Golden Retriever",
            LocalDate.of(2019, 12, 20),
            Gender.FEMALE,
            listOf("Curious", "Loyal"),
            "https://images.unsplash.com/photo-1611498491685-abb3e359cf69?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=2102&q=80"
        )
    )

    private val cats = listOf(
        Pet(
            UUID.randomUUID(),
            AnimalType.CAT,
            "Dream",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                    "Sed sodales urna metus, quis semper mauris viverra ac.",
            "Siamese",
            LocalDate.of(2020, 1, 23),
            Gender.FEMALE,
            listOf("Playful", "Friendly"),
            "https://images.unsplash.com/photo-1612537563846-e22eb8e55cc2?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=933&q=80"
        ),
        Pet(
            UUID.randomUUID(),
            AnimalType.CAT,
            "Sally",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            "Brittish Shorthair",
            LocalDate.of(2019, 4, 10),
            Gender.FEMALE,
            listOf("Lazy", "Friendly"),
            "https://images.unsplash.com/photo-1548247416-ec66f4900b2e?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=963&q=80"
        )
    )

    private val birds = listOf(
        Pet(
            UUID.randomUUID(),
            AnimalType.BIRD,
            "Tee",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                    "Sed viverra fermentum lorem ac facilisis. " +
                    "Curabitur nisl orci, posuere eu vehicula sed, tempor ac est. " +
                    "Duis id leo eu quam rutrum feugiat.",
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

    fun getPet(id: String) = pets.firstOrNull { UUID.fromString(id) == it.id }
}