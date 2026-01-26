package dev.gportillagra.formiikapp.domain.model

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class Dispositivo(
    val id: String,
    val idContacto: String? = null, 
	val noContrato: String? = null,
    val noSerie: String? = null
)
