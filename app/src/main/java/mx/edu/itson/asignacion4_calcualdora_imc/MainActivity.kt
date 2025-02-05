package mx.edu.itson.asignacion4_calcualdora_imc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //variables
    var estatura = findViewById<EditText>(R.id.etEstatura)
    var peso = findViewById<EditText>(R.id.etPeso)
    var imc = findViewById<Button>(R.id.btnCalcular)
    var resultado = findViewById<TextView>(R.id.resultado)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //evento button clic o clicListener
        imc.setOnClickListener {
            calcularIMC()
        }
    }

    //funcion
    fun calcularIMC() {
        var estatura = estatura.text.toString().toDoubleOrNull()
        var peso = peso.text.toString().toDoubleOrNull()
        if ((estatura != null || peso != null) && (estatura != 0.0 || peso != 0.0)) {
            var imc = peso / (estatura * estatura)
            resultado.setText(imc.toString())
            return
        }else{
            resultado.setText("Ingrese valores válidos")
            return
        }

    }
}