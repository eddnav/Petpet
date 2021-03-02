package com.edd.androiddevchallenge.petpet.domain.model

import androidx.annotation.DrawableRes
import com.edd.androiddevchallenge.petpet.R

enum class Gender {
    FEMALE, MALE
}

@DrawableRes
fun Gender.getAssociatedIconRes(): Int =
    when (this) {
        Gender.FEMALE -> R.drawable.ic_female
        Gender.MALE -> R.drawable.ic_male
    }