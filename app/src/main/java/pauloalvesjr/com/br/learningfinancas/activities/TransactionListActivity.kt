package pauloalvesjr.com.br.learningfinancas.activities

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import kotlinx.android.synthetic.main.form_transacao.view.*
import kotlinx.android.synthetic.main.transacao_item.view.*
import pauloalvesjr.com.br.learningfinancas.R
import pauloalvesjr.com.br.learningfinancas.adapters.TransactionListAdapter
import pauloalvesjr.com.br.learningfinancas.enums.TransactionType
import pauloalvesjr.com.br.learningfinancas.extensions.simpleTransactionFormat
import pauloalvesjr.com.br.learningfinancas.models.Transaction
import pauloalvesjr.com.br.learningfinancas.utils.TransactionsView
import java.text.SimpleDateFormat
import java.util.*
import java.util.logging.SimpleFormatter

class TransactionListActivity : AppCompatActivity() {

    val transactions : MutableList<Transaction> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val view = window.decorView

        TransactionsView(this, view, transactions).render()

        lista_transacoes_adiciona_receita.setOnClickListener {
            val viewForm = LayoutInflater.from(this)
                    .inflate(R.layout.form_transacao, view as ViewGroup, false)

            viewForm.form_transacao_data.setOnClickListener { 
                DatePickerDialog(this,
                        DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                            val date = Calendar.getInstance()
                            date.set(year, month, dayOfMonth)
                            viewForm.form_transacao_data.setText(date.simpleTransactionFormat())
                        }, 2018, 10, 5)
                        .show()
            }
            viewForm.form_transacao_categoria.adapter =
                    ArrayAdapter.createFromResource(this, R.array.categorias_de_receita, android.R.layout.simple_spinner_dropdown_item)

            AlertDialog.Builder(this)
                    .setTitle(R.string.adiciona_receita)
                    .setView(viewForm)
                    .setPositiveButton("Confirmar") { dialog, which ->
                        val value = viewForm.form_transacao_valor.text.toString().toDouble()
                        val category = viewForm.form_transacao_categoria.selectedItem.toString()
                        val dateString = viewForm.form_transacao_data.text.toString()

                        val date : Date = SimpleDateFormat("dd/MM/yyyy").parse(dateString)
                        val dateCalendar = Calendar.getInstance()
                        dateCalendar.time = date

                        val transaction = Transaction(value, category, TransactionType.INCOMINGS, dateCalendar)

                        transactions.add(transaction)
                        lista_transacoes_adiciona_menu.close(true)
                        TransactionsView(this, view, transactions).render()

                    }
                    .setNegativeButton("Cancelar", null)
                    .show()
        }

        lista_transacoes_listview.adapter = TransactionListAdapter(this, transactions)
    }

}