package dev.gportillagra.formiikapp.domain.model

import androidx.annotation.Keep
import androidx.compose.ui.graphics.vector.ImageVector
import com.google.firebase.Timestamp
import dev.gportillagra.formiikapp.domain.utils.newUUID
import dev.gportillagra.formiikapp.presentation.icons.AppIcons

@Keep
enum class Agencia {
    CORTIZO_CAMPILLO
}

@Keep
enum class StatusPrealerta(val label: String, val icon: ImageVector) {
    ABIERTA(label = "ABIERTA", icon = AppIcons.Outlined.ReportMedical),
	REVISION(label = "Enviar a revisión", icon = AppIcons.Outlined.ReportSearch),
	AUTORIZADA(label = "Marcar como autorizada", icon = AppIcons.Outlined.CheckupList),
	PAGADA(label = "Marcar como pagada", icon = AppIcons.Outlined.ReportMoney)
}

fun StatusPrealerta.next(): StatusPrealerta {
    val nextOrdinal = (this.ordinal + 1) % StatusPrealerta.entries.size
    return StatusPrealerta.entries[nextOrdinal]
}

@Keep
data class Prealerta(
    val id: String = String.newUUID(),
	//val idUsuario: String? = null,
	val gestor: List<String> = emptyList(),
    val noSemana: Int? = null,
    val fechaEntradaAlmacen: Timestamp? = null,
	val fechaAutorizacion: Timestamp? = fechaEntradaAlmacen,
	val agencia: Agencia = Agencia.CORTIZO_CAMPILLO,
	val status: StatusPrealerta = StatusPrealerta.ABIERTA
)