package dev.gportillagra.formiikapp.domain.model

import androidx.annotation.Keep

@Keep
@Serializable
data class Dispositivo(
    val id: String = String.newUUID(),
	val noContrato: String? = null,
    val noSerie: String? = null
)
