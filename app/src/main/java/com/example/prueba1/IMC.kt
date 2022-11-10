package com.example.prueba1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_imc.*

class IMC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        var valoresGenero = arrayOf("Seleccione Genero","Macho","Hembra")
        var valoresRaza = arrayOf("Seleccione Raza","Mini toy","Pequeñas",
            "Medianas", "Grandes", "Gigantes")

        val adapter = ArrayAdapter(this,
            android.R.layout.simple_spinner_item, valoresGenero)
        sp_genero.adapter = adapter

        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, valoresRaza)
        sp_razas.adapter = adapter2

        btn_calcular_imc.setOnClickListener{
            var peso:Double = et_peso.text.toString().toDouble()
            var altura:Double = et_altura_hombro.text.toString().toDouble()
            var occipusio:Double = et_occipucio.text.toString().toDouble()
            var nombre:String = et_nombre.text.toString()
            var raza:String = sp_razas.selectedItem.toString()

            var imcTotal = peso/(altura * occipusio)

            val saltar: Intent = Intent(this, Resultado::class.java)
            saltar.putExtra("imcTotal", imcTotal)
            saltar.putExtra("nombre", nombre)
            saltar.putExtra("raza", raza)

            startActivity(saltar)
        }
    }
}