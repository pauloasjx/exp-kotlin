package pauloalvesjr.com.br.learningfinancas.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import pauloalvesjr.com.br.learningfinancas.R
import pauloalvesjr.com.br.learningfinancas.adapters.TransactionListAdapter
import pauloalvesjr.com.br.learningfinancas.enums.TransactionType
import pauloalvesjr.com.br.learningfinancas.models.Transaction
import java.math.BigDecimal
import java.util.*

class TransactionListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        var transactions = listOf(
                Transaction(30.0, "Comida", TransactionType.DESPESA),
                Transaction(50.0, "Roupa", TransactionType.DESPESA),
                Transaction(10.0, "Transporte", TransactionType.DESPESA),
                Transaction(150.0, "Salario", TransactionType.RECEITA)
        )

        lista_transacoes_listview.adapter = TransactionListAdapter(this, transactions)
    }

}