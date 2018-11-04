package pauloalvesjr.com.br.learningfinancas.utils

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.View
import kotlinx.android.synthetic.main.resumo_card.view.*
import pauloalvesjr.com.br.learningfinancas.R
import pauloalvesjr.com.br.learningfinancas.extensions.formatToReal
import pauloalvesjr.com.br.learningfinancas.models.Transaction
import pauloalvesjr.com.br.learningfinancas.models.TransactionsSummary

class TransactionsView(val context : Context,
                       val view : View,
                       val transactions : List<Transaction>) {

    val transactionsSummary = TransactionsSummary(transactions)

    fun render() {
        renderExpenses()
        renderIncomings()
        renderTotal()
    }

    private fun renderExpenses() {
        view.resumo_card_despesa.text = transactionsSummary.expenses.formatToReal()
        view.resumo_card_despesa.setTextColor(ContextCompat.getColor(context, R.color.despesa))
    }

    private fun renderIncomings() {
        view.resumo_card_receita.text = transactionsSummary.incomings.formatToReal()
        view.resumo_card_receita.setTextColor(ContextCompat.getColor(context, R.color.receita))
    }

    private fun renderTotal() {
        view.resumo_card_total.text = transactionsSummary.total.formatToReal()

        if(transactionsSummary.total >= 0) {
            view.resumo_card_total.setTextColor(ContextCompat.getColor(context, R.color.receita))
        } else {
            view.resumo_card_total.setTextColor(ContextCompat.getColor(context, R.color.despesa))
        }
    }

}