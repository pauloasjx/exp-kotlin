package pauloalvesjr.com.br.learningfinancas.adapters

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.transacao_item.view.*
import pauloalvesjr.com.br.learningfinancas.R
import pauloalvesjr.com.br.learningfinancas.enums.TransactionType
import pauloalvesjr.com.br.learningfinancas.extensions.formatToReal
import pauloalvesjr.com.br.learningfinancas.extensions.limit
import pauloalvesjr.com.br.learningfinancas.extensions.simpleTransactionFormat
import pauloalvesjr.com.br.learningfinancas.models.Transaction

class TransactionListAdapter(private val context : Context,
                             private val transactions : List<Transaction>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflate = LayoutInflater.from(context)
                .inflate(R.layout.transacao_item, parent, false)

        val transaction = transactions[position]

        when (transaction.type) {
            TransactionType.INCOMINGS -> {
                inflate.transacao_valor.setTextColor(ContextCompat.getColor(context, R.color.receita))
                inflate.transacao_icone.setBackgroundResource(R.drawable.icone_transacao_item_receita)
            }
            TransactionType.EXPENSES -> {
                inflate.transacao_valor.setTextColor(ContextCompat.getColor(context, R.color.despesa))
                inflate.transacao_icone.setBackgroundResource(R.drawable.icone_transacao_item_despesa)
            }
        }

        inflate.transacao_valor.text = transaction.value.formatToReal()
        inflate.transacao_categoria.text = transaction.category.limit(14)
        inflate.transacao_data.text = transaction.calendar.simpleTransactionFormat()

        return inflate
    }

    override fun getItem(position: Int): Any {
        return transactions[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return transactions.size
    }
}