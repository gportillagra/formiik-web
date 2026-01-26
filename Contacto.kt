package dev.gportillagra.formiikapp.domain.model

import androidx.annotation.Keep
import com.google.firebase.Timestamp
import dev.gportillagra.formiikapp.domain.utils.normalize
import dev.gportillagra.formiikapp.domain.utils.newUUID

@Keep
enum class Cartera(val label: String?) {
    UNSPECIFIED,
    BACKLOG(label = "BackLog"),
    TOTALSHOP(label = "TotalShop")
}

@Keep
enum class Segmento(val label: String?) {
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
enum class Empresa(val label: String?) {
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
    val id: String,
    val idAsignacion: String?,
    val fechaCreacion: Timestamp?,
    val noContrato: String,
    val nombre: String,
    val calle: String,
    val colonia: String,
    val codigoPostal: String,
    val ciudad: String,
    val estado: String,
    val entreCalles: String?,
    val referencias: String?,
    val lat: Double?,
    val lng: Double?,
    val enRuta: Boolean = false,
    val cartera: Cartera,
    val segmento: Segmento,
    val empresa: Empresa = Empresa.TOTALPLAY_CORTIZO,
    val fechaAsignacion: Timestamp?,
    val fechaVencimiento: Timestamp?,
    val diasMora: Int?,
    val ciclo: Int?,
    val numeroEquipos: Int?,
    val saldoExigible: Double?,
    val saldoServicio: Double?,
    val saldoTotal: Double?,
    val referenciaPago: String?,
    val plazoConvenio: Int?,
    val gestorAsignado: List<String>,
	val esArchivado: Boolean = false
)

/*
Tengo informacion en la hoja "BD_DATOS" y con la formula query quiero que logres una nueva tabla con los siguientes campos respetando los valores y especificaciones que se muestran en cada uno

    val id: String -> Comuna A (0 a la izquierda),
    val idAsignacion: String? -> Columna B,
    val noContrato: String -> Igual que "id",
    val nombre: String -> Columna F,
    val calle: String -> Coluna N,
    val colonia: String -> Columns O,
    val codigoPostal: String -> Coluns P (Formato Texto),
    val ciudad: String -> Columna Q,
    val estado: String -> Columa R,
    val entreCalles: String? columna Z,
    val referencias: String? Coluns AA,
    val lat: Double? -> Colums Ab,
    val lng: Double? -> Coluns AC,
    val enRuta: Boolean -> Siempre false,
    val cartera: Cartera -> Columns E,
    val segmento: Segmento -> debe tomar el valor de la columa M y buscalra en hoja "_const!A:B" y tomsr el resultado de coluna 2 de esta búsqueda,
    val empresa: Empresa -> hacer lo mismo que para el valor segemento pero ahora tomando el valor de la columna G,
    val fechaAsignacion: Timestamp? -> Tomsr el valor de la columna B que siempre tiene el formato "17/01/2026 AL 16/02/2026 BL" si te das cuenta contiene dos fechas y texto, solo debes estraer la primera fecha,
    val fechaVencimiento: Timestamp? -> Tomsr el valor de la columna B que siempre tiene el formato "17/01/2026 AL 16/02/2026 BL" si te das cuenta contiene dos fechas y texto, solo debes estraer la segunda fecha,
    val diasMora: Int? -> tomar el valor de la columna L,
    val ciclo: Int? -> Tomar el valor de la columna I,
    val numeroEquipos: Int? -> Tomar el valor de la columna W,
    val saldoServicio: Double? -> Tomar el valor de la columna J,
    val saldoTotal: Double? -> Tomar el valor de la columna K,
	val esArchivado: Boolean = false -> siempre false
*/