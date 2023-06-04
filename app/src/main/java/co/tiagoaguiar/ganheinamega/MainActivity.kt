package co.tiagoaguiar.ganheinamega

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

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

    private fun numberGenerator(text: String, txtResult: TextView){

    }

}