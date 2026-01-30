Coleccion a guardar datos '/debug_contactos'

package dev.gportillagra.formiikapp.domain.model

import androidx.annotation.Keep
import com.google.firebase.Timestamp

@Keep
enum class Cartera(val label: String? = null) {
    UNSPECIFIED,
    BACKLOG(label = "BackLog"),
    TOTALSHOP(label = "TotalShop")
}

@Keep
enum class Segmento(val label: String? = null) {
    UNSPECIFIED,
    BUCKET_91_A_120(label = "91 a 120"),
    BUCKET_121_A_150(label = "121 a 150"),
    BUCKET_151_A_180(label = "151 a 180"),
    BUCKET_181_A_210(label = "181 a 210"),
    BUCKET_211_A_240(label = "211 a 240"),
    BUCKET_241_A_270(label = "241 a 270"),
    BUCKET_271_A_300(label = "271 a 300"),
    BUCKET_MAS_DE_300(label = "Más de 300")
}

@Keep
enum class Empresa(val label: String? = null) {
    TOTALPLAY_CORTIZO(label = "TotalPlay - Cortizo Campillo & Asociados")
}

@Keep
enum class Dictamen {
    UNSPECIFIED,
	CAMBIO_DOMICILIO,
	ILOCALIZABLE,
	EQUIPO_RECUPERADO,
	RECUPERADO_OTROS,
	NEGATIVA_ENTREGA,
	PROMESA_ENTREGA,
	PERDIO_EQUIPOS,
	SERVICIO_ACTIVO,
	NOTIFICACION
}

@Keep
data class Contacto(
    val id: String = Es un valor nunerico convertido a string de 10 digitos, se deben agregar los dígitos faltantes como '0' al inicio,
    val idAsignacion: String? = null,
    val noContrato: String = Es un valor nunerico convertido a string de 10 digitos, se deben agregar los dígitos faltantes como '0' al inicio,
    val nombre: String = Texto con formato de nombre propio y sin espacios de mas al inicio y fin y entre palabras,
    val calle: String = Texto con formato de nombre propio y sin espacios de mas al inicio y fin y entre palabras,
    val colonia: String = Debe ser tomado de una lista de colonias de la colección '/asentamientos' campo 'asentamiento' filtradas por 'ciudad',
    val codigoPostal: String = Es un valor nuneroico que se debe convertir a string,
    val ciudad: String = Valor tomado de la lista cargada de la colección '/asentamientos' campo 'municipio',
    val estado: String = Texto con formato de nombre propio y sin espacios de mas al inicio y fin y entre palabras,
    val entreCalles: String? = Texto con formato de oración (mayusculas en la pirmera letra y despues de signos de puntuación) y sin espacios de mas al inicio y fin y entre palabras,
    val referencias: String? = Texto con formato de oración (mayusculas en la pirmera letra y despues de signos de puntuación) y sin espacios de mas al inicio y fin y entre palabras, si es igual a entrecalles se omite y no se parsea,
    val lat: Double? = null,
    val lng: Double? = null,
    val enRuta: Boolean = false,
    val cartera: Cartera = se debe validar que exista en el enum y si no se establece clmo Cartera.UNSPECIFIED,
    val segmento: Segmento = para parsear crea un diccionario de palabras relacionadas a cada elemento del enum Segemento (ejemplo BUCKET_121_A_150 -> 121 a 150, 121_150),
    val empresa: Empresa = Un diccionario al igual que en segemento (ejemplo TOTALPLAY_CORTIZO -> TOTALPLA, CORTIZO),
    val fechaAsignacion: Timestamp? = usa regexp para extraer el texto la primera fecha que aparezca de la columna que te de a parsear,
    val fechaVencimiento: Timestamp? = usa regexp para extraer el texto la segunda fecha que aparezca de la columna que te de a parsear,
    val diasMora: Int? = null,
    val ciclo: Int? = null,
    val numeroEquipos: Int? = null,
    val saldoExigible: Double? = null,
    val saldoServicio: Double? = null,
    val saldoTotal: Double? = null,
    val referenciaPago: String? = null,
    val plazoConvenio: Int? = null,
    val dictamen: Dictamen = No se va a recibir del excel que se importq, lo debes consultar del documento con mismo id que el actual en la colección '/contactos',
    val gestorAsignado: List<String> = vas a recibir de excel una cadena de emails separados por ';' para crear el campo de tipo array<string> para el documento de firestore,
	val esArchivado: Boolean = siempre lo debes gusrdar como false,
)