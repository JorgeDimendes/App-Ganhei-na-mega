package co.tiagoaguiar.ganheinamega

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // aqui onde voce decide o que o app fazer...
        setContentView(R.layout.activity_main)

        // buscar os objetos e ter a referencia deles
        val editText: EditText = findViewById(R.id.edit_number)
        val txtResult: TextView = findViewById(R.id.txt_result)
        val btnGenerate: Button = findViewById(R.id.btn_generate)

        // opção 1: XML

        // opção 2: variavel que seja do tipo (objeto anonimo) View.OnClickListener (interface)
        // btnGenerate.setOnClickListener(buttonClickListener)

        // opção 3: mais simples possivel - bloco de código que será disparado pelo onClickListener
        btnGenerate.setOnClickListener {
            // aqui podemos colocar nossa logica de programação. porque será disparado depois do
            // evento de touch do usuário

            val text = editText.text.toString()

            numberGenerator(text, txtResult)
        }
    }

    private fun numberGenerator(text: String, txtResult: TextView) {
        // validar quando o campo é vazio
        if (text.isNotEmpty()) {

            val qtd = text.toInt() // convert string para inteiro

            // validar se o campo informado é entre 6 e 15
            if (qtd >= 6 && qtd <= 15) {

                val numbers = mutableSetOf<Int>()
                val random = Random()

                while(true) {
                    val number = random.nextInt(60) // 0...59
                    numbers.add(number + 1)

                    if (numbers.size == qtd) {
                        break
                    }
                }

                txtResult.text = numbers.joinToString(" - ")

            } else {
                Toast.makeText(this, "Informe um número entre 6 e 15", Toast.LENGTH_LONG).show()
            }


        } else {
            Toast.makeText(this, "Informe um número entre 6 e 15", Toast.LENGTH_LONG).show()
        }


    }













//    val buttonClickListener = View.OnClickListener {
//        Log.i("Teste", "botao clicado!!!")
//    }

//    val buttonClickListener = object : View.OnClickListener {
//        // quem chama o onclick é o proprio SDK do android que dispara apos o evento de touch
//        override fun onClick(v: View?) {
//            Log.i("Teste", "botao clicado!!!")
//        }
//
//    }

    // opção 1: XML
//    fun buttonClicked(view: View) {
//        Log.i("Teste", "botao clicado!!!")
//    }

}