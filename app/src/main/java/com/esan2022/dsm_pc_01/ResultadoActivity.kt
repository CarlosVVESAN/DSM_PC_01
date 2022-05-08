package com.esan2022.dsm_pc_01

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val df = DecimalFormat("#.##")
        val btnSave: Button = findViewById(R.id.btnSave)
        val imcNum = intent.getStringExtra("imcNum")
        val imcStr = intent.getStringExtra("imcStr")
        val imcColor = intent.getStringExtra("imcColor")
        findViewById<TextView>(R.id.txtIMC).apply{
            val imcNumDouble: Double = imcNum.toString().toDouble()
            val imcNumNew = df.format(imcNumDouble)
            text = imcNumNew.toString()
        }
        val txtClasi: TextView = findViewById(R.id.txtClasi)
        txtClasi.text = imcStr.toString()
        txtClasi.setTextColor(Color.parseColor(imcColor));
        btnSave.setOnClickListener {
            val imcNumDouble: Double = imcNum.toString().toDouble()
            val imcNumNew = df.format(imcNumDouble).toString()
            Toast.makeText(applicationContext, "Tu IMC es de: $imcNumNew", Toast.LENGTH_LONG).show()
        }

    }
}