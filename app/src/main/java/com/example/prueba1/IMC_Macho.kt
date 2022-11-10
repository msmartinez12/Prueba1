package com.example.prueba1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_imc_macho.*

class IMC_Macho : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_macho)

        var valoresRaza = arrayOf("Seleccione Raza","Mini toy","Pequeñas",
            "Medianas", "Grandes", "Gigantes")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, valoresRaza)
        sp_raza1.adapter = adapter

        btn_calcular1.setOnClickListener{
            var hs:Double = et_rodilla.text.toString().toDouble()
            var nombre:String = et_nombre1.text.toString()
            var cp:Double = et_circunferencia.text.toString().toDouble()
            var raza:String = sp_raza1.selectedItem.toString()


            var imcTotal = (1.4 * hs) + (0.7 * cp) + 4

            val saltar: Intent = Intent(this, Resultado::class.java)
            saltar.putExtra("imcTotal", imcTotal)
            saltar.putExtra("nombre", nombre)
            saltar.putExtra("raza", raza)

            startActivity(saltar)
        }
    }
}