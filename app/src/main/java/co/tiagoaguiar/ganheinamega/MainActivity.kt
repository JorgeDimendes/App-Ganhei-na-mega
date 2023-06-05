package co.tiagoaguiar.ganheinamega

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Buscar os objetos e ter a referencia deles
        val editText: EditText = findViewById(R.id.editnumber)
        val txtResult: TextView = findViewById(R.id.textresult)
        val buttonGenerate: Button = findViewById(R.id.button_generateNumbers)

        // Opção 01: XML
        // Opção 02: Variavel que seja do tipo wiew.onClickListener (interface)

        // Opção 03: Mais simples possivel- Bloco de codigo que será disparado pelo onClickListener
        buttonGenerate.setOnClickListener {

            val text = editText.text.toString()

            numberGenerator(text, txtResult)
            txtResult.text = text
        }

    }

    private fun numberGenerator(text: String, txtResult: TextView) =
        //Validar quando o campo é vazio
        if (text.isNotEmpty()){

            val quantidade = text.toInt() //Converte String para inteiro

            if (quantidade >=6 && quantidade <= 15){

                val numbers = mutableSetOf<Int>()
                val random = Random()

                while(true){
                    val number = random.nextInt(60) // 0..59
                    numbers.add(number + 1)

                    if (numbers.size == quantidade){
                        break
                    }
                }

                txtResult.text = numbers.joinToString { " - " }


            }else{
                //Caso o cliente não digite nada mostra esse alerta
                Toast.makeText(this, "Informe um numero entre 6 e 15", Toast.LENGTH_LONG).show()
            }

        } else{
            //Caso o cliente não digite nada mostra esse alerta
            Toast.makeText(this, "Informe um numero entre 6 e 15", Toast.LENGTH_LONG).show()
        }


    // Validar se o compo informado é entre 6 e 15

}