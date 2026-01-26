package dev.gportillagra.formiikapp.domain.model

import androidx.annotation.Keep

@Keep
data class Telefono(
    val id: String,
    val noContrato: String,
    val numero: String
)