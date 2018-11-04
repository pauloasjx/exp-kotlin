package pauloalvesjr.com.br.learningfinancas.extensions

import java.text.SimpleDateFormat
import java.util.Calendar


fun Calendar.simpleTransactionFormat() : String {
    return SimpleDateFormat("dd/MM/yyyy")
            .format(this.time)
}