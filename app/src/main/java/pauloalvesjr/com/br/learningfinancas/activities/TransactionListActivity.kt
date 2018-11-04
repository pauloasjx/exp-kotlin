package pauloalvesjr.com.br.learningfinancas.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import kotlinx.android.synthetic.main.resumo_card.*
import pauloalvesjr.com.br.learningfinancas.R
import pauloalvesjr.com.br.learningfinancas.adapters.TransactionListAdapter
import pauloalvesjr.com.br.learningfinancas.enums.TransactionType
import pauloalvesjr.com.br.learningfinancas.models.Transaction
import pauloalvesjr.com.br.learningfinancas.utils.TransactionsView

class TransactionListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        var transactions = listOf(
                Transaction(30.0, "Comida", TransactionType.EXPENSES),
                Transaction(50.0, "Roupa", TransactionType.EXPENSES),
                Transaction(10.0, "Transporte", TransactionType.EXPENSES),
                Transaction(150.0, "Salario", TransactionType.INCOMINGS),
                Transaction(140.0, "Meias", TransactionType.EXPENSES)
        )

        val view = window.decorView

        TransactionsView(this, view, transactions).render()

        lista_transacoes_listview.adapter = TransactionListAdapter(this, transactions)
    }

}