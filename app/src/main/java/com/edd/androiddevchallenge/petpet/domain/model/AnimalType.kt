package com.edd.androiddevchallenge.petpet.domain.model

import androidx.annotation.DrawableRes
import com.edd.androiddevchallenge.petpet.R

enum class AnimalType {
    DOG, CAT, BIRD
}

@DrawableRes
fun AnimalType.getAssociatedIconRes(): Int =
    when (this) {
        AnimalType.DOG -> R.drawable.ic_dog
        AnimalType.CAT -> R.drawable.ic_cat
        AnimalType.BIRD -> R.drawable.ic_bird
    }