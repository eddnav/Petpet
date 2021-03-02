package com.edd.androiddevchallenge.petpet.util.extension

import android.content.Context
import com.edd.androiddevchallenge.petpet.R
import java.time.LocalDate
import java.time.temporal.ChronoUnit

fun LocalDate.getTimeOldString(context: Context): String {
    val now = LocalDate.now()
    val yearAgo = now.minusYears(1)

    return when {
        this > yearAgo -> {
            val diff = ChronoUnit.MONTHS.between(this, now).toInt()
            context.resources.getQuantityString(R.plurals.label_months_old, diff, diff)
        }
        else -> {
            val diff = ChronoUnit.YEARS.between(this, now).toInt()
            context.resources.getQuantityString(R.plurals.label_years_old, diff, diff)
        }
    }
}