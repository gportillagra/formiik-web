Coleccion a guardar datos '/debug_telefonos'
para parsear wste docuemto debes permitir al usuario agregar una o varias columnas del excel oara elejor cuales contienen los numeros de contacto
puede ser una o varias columnas y omitir si los datos que xontiene son iguales

package dev.gportillagra.formiikapp.domain.model

import androidx.annotation.Keep
import dev.gportillagra.formiikapp.domain.utils.newUUID

@Keep
data class Telefono(
    val id: String = Formado por 'noContrato-numero',
    val noContrato: String corresponde a noContrato de Contacto
    val numero: String
)