package com.esan2022.dsm_pc_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtPeso: EditText = findViewById(R.id.txtPeso)
        val txtTalla: EditText = findViewById(R.id.txtTalla)
        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        btnCalcular.setOnClickListener {
            val pesoKg: Double = txtPeso.text.toString().toDouble()
            val tallaCm: Double = txtTalla.text.toString().toDouble()
            val tallaM: Double = tallaCm / 100
            val imc: Double = (pesoKg / (tallaM*tallaM))
            var imcStr: String = ""
            var color: String = ""
            if (imc < 18.5) {
                imcStr = "Bajo Peso"
                color = "#FFC300"
            } else if(18.5 >= imc && imc <= 24.9) {
                imcStr = "Normal"
                color = "#109328"
            } else if(25.0 >= imc && imc <= 29.9) {
                imcStr = "Sobrepeso"
                color = "#FF5733"
            } else if(30.0 >= imc && imc <= 34.5) {
                imcStr = "Obesidad grado I"
                color = "#FF5733"
            } else if(35.0 >= imc && imc <= 39.9) {
                imcStr = "Obesidad grado II"
                color = "#C70039"
            } else if(imc >= 40.0) {
                imcStr = "Obesidad grado III"
                color = "#C70039"
            }

//            val txtYourIMC: TextView = findViewById(R.id.txtYourIMC)
            val i = Intent(this, ResultadoActivity::class.java).apply {
                putExtra("imcNum", "$imc")
                putExtra("imcStr", "$imcStr")
                putExtra("imcColor", "$color")
            }
            startActivity(i)
        }
    }
}