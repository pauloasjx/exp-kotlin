package pauloalvesjr.com.br.learningfinancas.extensions

import java.text.DecimalFormat
import java.util.*

fun Double.formatToReal() : String {
    return DecimalFormat.getCurrencyInstance(Locale("pt", "br"))
            .format(this)
            .replace("R$", "R$ ")
}