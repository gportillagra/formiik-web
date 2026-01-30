package dev.gportillagra.formiikapp.domain.model

import androidx.annotation.Keep
import com.google.firebase.Timestamp
import dev.gportillagra.formiikapp.domain.utils.normalize
import dev.gportillagra.formiikapp.domain.utils.newUUID

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
    val id: String = String.newUUID(),
    val idAsignacion: String? = null,
    val noContrato: String = "",
    val nombre: String = "",
    val calle: String = "",
    val colonia: String = "",
    val codigoPostal: String = "",
    val ciudad: String = "",
    val estado: String = "",
    val entreCalles: String? = null,
    val referencias: String? = null,
    val lat: Double? = null,
    val lng: Double? = null,
    val enRuta: Boolean = false,
    val cartera: Cartera = Cartera.UNSPECIFIED,
    val segmento: Segmento = Segmento.UNSPECIFIED,
    val empresa: Empresa = Empresa.TOTALPLAY_CORTIZO,
    val fechaAsignacion: Timestamp? = null,
    val fechaVencimiento: Timestamp? = null,
    val diasMora: Int? = null,
    val ciclo: Int? = null,
    val numeroEquipos: Int? = null,
    val saldoExigible: Double? = null,
    val saldoServicio: Double? = null,
    val saldoTotal: Double? = null,
    val referenciaPago: String? = null,
    val plazoConvenio: Int? = null,
    val dictamen: Dictamen = Dictamen.UNSPECIFIED,
	val fechaDictamen: Timestamp? = null,
    val gestorAsignado: List<String> = emptyList(),
	val esArchivado: Boolean = false,
)