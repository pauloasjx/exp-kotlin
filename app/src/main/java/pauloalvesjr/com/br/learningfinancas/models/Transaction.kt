package pauloalvesjr.com.br.learningfinancas.models

import pauloalvesjr.com.br.learningfinancas.enums.TransactionType
import java.util.*

class Transaction (
        val value : Double,
        val category : String = "Indefinido",
        val type : TransactionType,
        val calendar : Calendar = Calendar.getInstance()
)