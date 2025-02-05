package mx.edu.itson.asignacion4_calcualdora_imc

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    private lateinit var estatura: EditText
    private lateinit var peso: EditText
    private lateinit var btnCalcular: Button
    private lateinit var resultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Inicializar las vistas
        estatura = findViewById(R.id.etEstatura)
        peso = findViewById(R.id.etPeso)
        btnCalcular = findViewById(R.id.btnCalcular)
        resultado = findViewById(R.id.resultado)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Evento al hacer clic en el botón
        btnCalcular.setOnClickListener {
            calcularIMC()
        }
    }

    // Función para calcular el IMC
    private fun calcularIMC() {
        val estatura2 = estatura.text.toString().toFloatOrNull()
        val peso2 = peso.text.toString().toFloatOrNull()

        if (estatura2 != null && peso2 != null && estatura2 > 0) {
            val imc = peso2 / (estatura2 * estatura2)  // Cálculo correcto
            resultado.text = "IMC: %.2f".format(imc)  // Formato con 2 decimales
        } else {
            resultado.text = "Ingrese valores válidos"  // Mensaje de error
        }
    }
}
