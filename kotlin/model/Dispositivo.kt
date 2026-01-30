Coleccion a guardar datos '/debug_dispositivos'
para este docuento, el usuario debe elegir una columna que contiene los números de serie separados por ';' debes sepsrarlos y crear varios documentos con el resultado 'noSerie'

package dev.gportillagra.formiikapp.domain.model

import androidx.annotation.Keep

@Keep
@Serializable
data class Dispositivo(
    val id: String = igual a noSerie,
	val noContrato: String? = coluna seleccionada para noContrato,
    val noSerie: String? = null
)
