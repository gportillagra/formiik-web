package dev.gportillagra.formiikapp.domain.model

import androidx.annotation.Keep
import com.google.firebase.Timestamp
import com.google.firebase.firestore.ServerTimestamp
import dev.gportillagra.formiikapp.domain.utils.newUUID

@Keep
enum class TipoGestion(val label: String, private val isVisible: Boolean = true) {
    PRESENCIAL(label = "Presencial"),
    TELEFONICA(label = "Telefónica"),
    SYS_LLAMADA(label = "Telefónica", isVisible = false),
    SYS_WHATSAPP(label = "Telefónica", isVisible = false),
    REGISTRO_TELEFONO(label = "Telefónica", isVisible = false),
	UNSPECIFIED(label = "No especificado", isVisible = false);
    
    companion object {
        fun getAllowedValues() : List<TipoGestion> {
            return entries
                .filter {
                    it.isVisible == true
                }
        }
    }
}

@Keep
enum class ContactoAccion(val label: String, private val isVisible: Boolean = true) {
    DIRECTO(label = "Directo"),
    FAMILIAR(label = "Familiar"),
    TERCERO(label = "Tercero/vecino"),
    SIN_CONTACTO(label = "Sin contacto"),
	UNSPECIFIED(label = "No especificado", isVisible = false);
    
    companion object {
        fun getAllowedValues() : List<ContactoAccion> {
            return entries
                .filter {
                    it.isVisible == true
                }
        }
    }
}

@Keep
enum class ResultadoAccion(
    val label: String,
    val filtroTipoGestion: List<TipoGestion> = emptyList(),
    val filtroContactoAccion: List<ContactoAccion> = emptyList(),
	val dictamen: Dictamen? = null
) {
    SERVICIO_ACTIVO(
        label = "El servicio está activo",
        filtroTipoGestion = listOf(TipoGestion.PRESENCIAL, TipoGestion.TELEFONICA),
        filtroContactoAccion = listOf(ContactoAccion.DIRECTO, ContactoAccion.FAMILIAR),
		dictamen = Dictamen.SERVICIO_ACTIVO
    ),
    RECUPERADO_OTROS(
        label = "Recuperado por otro despacho",
        filtroTipoGestion = listOf(TipoGestion.PRESENCIAL, TipoGestion.TELEFONICA),
        filtroContactoAccion = listOf(ContactoAccion.DIRECTO, ContactoAccion.FAMILIAR, ContactoAccion.TERCERO),
		dictamen = Dictamen.RECUPERADO_OTROS
    ),
    RECUPERADO_GESTOR(
        label = "Equipo(s) recuperado (s)",
        dictamen = Dictamen.EQUIPO_RECUPERADO
    ),
    NEGATIVA_ENTREGA(
        label = "Negativa de entrega",
        filtroTipoGestion = listOf(TipoGestion.PRESENCIAL, TipoGestion.TELEFONICA),
        filtroContactoAccion = listOf(ContactoAccion.DIRECTO, ContactoAccion.FAMILIAR, ContactoAccion.TERCERO),
		dictamen = Dictamen.NEGATIVA_ENTREGA
    ),
    PERDIO_EQUIPOS(
        label = "Perdió/tiro los equipos",
        filtroTipoGestion = listOf(TipoGestion.PRESENCIAL, TipoGestion.TELEFONICA),
        filtroContactoAccion = listOf(ContactoAccion.DIRECTO, ContactoAccion.FAMILIAR),
		dictamen = Dictamen.PERDIO_EQUIPOS
    ),
    PROMESA_ENTREGA(
        label = "Promesa de entrega",
        filtroTipoGestion = listOf(TipoGestion.PRESENCIAL, TipoGestion.TELEFONICA),
        filtroContactoAccion = listOf(ContactoAccion.DIRECTO, ContactoAccion.FAMILIAR, ContactoAccion.TERCERO),
		dictamen = Dictamen.PROMESA_ENTREGA
    ),
    CAMBIO_DOMICILIO(
        label = "Cambio de domicilio/no dejo equipos",
        filtroTipoGestion = listOf(TipoGestion.PRESENCIAL, TipoGestion.TELEFONICA),
        filtroContactoAccion = listOf(ContactoAccion.FAMILIAR, ContactoAccion.TERCERO),
		dictamen = Dictamen.CAMBIO_DOMICILIO
    ),
	NO_CONOCEN_TT(
        label = "No conocen al titular",
        filtroTipoGestion = listOf(TipoGestion.PRESENCIAL),
        filtroContactoAccion = listOf(ContactoAccion.TERCERO),
		dictamen = Dictamen.ILOCALIZABLE
    ),
    NOTIFICACION_FAMILIAR(
        label = "Notificación con familiar",
        filtroTipoGestion = listOf(TipoGestion.PRESENCIAL),
        filtroContactoAccion = listOf(ContactoAccion.FAMILIAR),
		dictamen = Dictamen.NOTIFICACION
    ),
    NOTIFICACION_TERCERO(
        label = "Notificación con vecino/conocido",
        filtroTipoGestion = listOf(TipoGestion.PRESENCIAL),
        filtroContactoAccion = listOf(ContactoAccion.TERCERO),
		dictamen = Dictamen.NOTIFICACION
    ),
    NOTIFICACION_PUERTA(
        label = "Notificación en puerta",
        filtroTipoGestion = listOf(TipoGestion.PRESENCIAL),
        filtroContactoAccion = listOf(ContactoAccion.SIN_CONTACTO),
		dictamen = Dictamen.NOTIFICACION
    ),
    DOMICILIO_ABANDONADO(
        label = "Domicilio abandonado",
        filtroTipoGestion = listOf(TipoGestion.PRESENCIAL),
        filtroContactoAccion = listOf(ContactoAccion.SIN_CONTACTO),
		dictamen = Dictamen.CAMBIO_DOMICILIO
    ),
    DOMICILIO_ILOCALIZABLE(
        label = "Domicilio ilocalizable",
        filtroTipoGestion = listOf(TipoGestion.PRESENCIAL),
        filtroContactoAccion = listOf(ContactoAccion.SIN_CONTACTO),
		dictamen = Dictamen.ILOCALIZABLE
    ),
	DOMICILIO_INACCESIBLE(
        label = "Domicilio inaccesible",
        filtroTipoGestion = listOf(TipoGestion.PRESENCIAL),
        filtroContactoAccion = listOf(ContactoAccion.SIN_CONTACTO),
		dictamen = Dictamen.ILOCALIZABLE
    ),
    INFORMACION_INCOMPLETA(
        label = "Información incompleta",
        filtroTipoGestion = listOf(TipoGestion.PRESENCIAL),
        filtroContactoAccion = listOf(ContactoAccion.SIN_CONTACTO),
		dictamen = Dictamen.ILOCALIZABLE
    ),
    MANDA_BUZON(
        label = "Teléfono manda a buzón",
        filtroTipoGestion = listOf(TipoGestion.TELEFONICA),
        filtroContactoAccion = listOf(ContactoAccion.SIN_CONTACTO)
    ),
    TELEFONO_NO_EXISTE(
        label = "Teléfono no existe",
        filtroTipoGestion = listOf(TipoGestion.TELEFONICA),
        filtroContactoAccion = listOf(ContactoAccion.SIN_CONTACTO)
    ),
    TELEFONO_EQUIVOCADO(
        label = "Teléfono equivocado/no conoce a titular",
        filtroTipoGestion = listOf(TipoGestion.TELEFONICA),
        filtroContactoAccion = listOf(ContactoAccion.TERCERO)
    ),
    TELEFONO_SIN_WHATSAPP(
        label = "Teléfono no existe en WhatsApp",
        filtroTipoGestion = listOf(TipoGestion.TELEFONICA),
        filtroContactoAccion = listOf(ContactoAccion.SIN_CONTACTO)
    ),
    LLAMADA_TELEFONICA(
        label = "Llamada telefónica"
    )
    ,
    MENSAJE_WHATSAPP(
        label = "Mensaje de WhatsApp"
    ),
    MENSAJE_TEXTO(
        label = "Mensaje de texto"
    ),
	UNSPECIFIED(
        label = "Acción no especificada en base de datos"
    );
    
    companion object {
        fun getAllowedValues(
            tipoGestion: TipoGestion?,
            contactoAccion: ContactoAccion?
        ) : List<ResultadoAccion> {
            return entries
                .sortedBy {
                    it.label
                }
                .filter {
                    tipoGestion in it.filtroTipoGestion &&
                    contactoAccion in it.filtroContactoAccion
                }
        }
    }
}

@Keep
data class Accion(
    val id: String = String.newUUID(),
    val noContrato: String? = null,
    val idContacto: String? = null,
    val idUsuario: String? = null,
	val usuario: User? = null,
    @get:ServerTimestamp
    val fechaCreacion: Timestamp? = null,
    val tipoGestion: TipoGestion? = null,
    val contactoAccion: ContactoAccion? = null,
    val resultadoAccion: ResultadoAccion? = null,
    val comentario: String = "",
    val telefono: Telefono? = null,
    val editable: Boolean = false,
    val listaDispositivos: List<Dispositivo> = emptyList(),
    val urlFotos: List<String> = emptyList(),
	val alertaPdfUri: String? = null,
)