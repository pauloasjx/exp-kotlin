package pauloalvesjr.com.br.learningfinancas.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import pauloalvesjr.com.br.learningfinancas.R

class TransactionListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        var sampleList = listOf("Comida - R$ 20,50", "Economia - R$ 100,00", "Airpods - R$ 800.00")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, sampleList)

        lista_transacoes_listview.adapter = adapter
    }

}