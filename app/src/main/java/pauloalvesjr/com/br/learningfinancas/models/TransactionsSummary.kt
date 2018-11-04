package pauloalvesjr.com.br.learningfinancas.models

import pauloalvesjr.com.br.learningfinancas.enums.TransactionType

class TransactionsSummary(val transactions : List<Transaction>) {

    val incomings get() = sumBy(TransactionType.INCOMINGS)
    val expenses get() = sumBy(TransactionType.EXPENSES)
    val total get() = incomings - expenses

    private fun sumBy(type : TransactionType) : Double {
        return transactions.filter { it.type == type }
                .sumByDouble { it.value }
    }

}