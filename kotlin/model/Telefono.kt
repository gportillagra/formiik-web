package dev.gportillagra.formiikapp.domain.model

import androidx.annotation.Keep
import dev.gportillagra.formiikapp.domain.utils.newUUID

@Keep
data class Telefono(
    val id: String = String.newUUID(),
    val noContrato: String = "",
    val numero: String = ""
)