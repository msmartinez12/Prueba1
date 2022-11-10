package com.example.prueba1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_resultado.*
import kotlinx.android.synthetic.main.activity_resultado2.*

class Resultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val extras = intent.extras
        val imcTotal: Double = extras?.getDouble("imcTotal")?:0.0
        val nombre = extras?.getString("nombre")?:"No hay nombre :("
        val raza = extras?.getString("raza")?:"No hay raza :("
        var menor= 0.0
        var mayor = 0.0

        if(raza.equals("Mini toy")){
           menor = 1.0
           mayor = 6.0
        }else if(raza.equals("Pequeñas")){
            menor = 7.0
            mayor = 15.0
        }else if(raza.equals("Medianas")){
            menor = 14.0
            mayor = 27.0
        }else if(raza.equals("Grandes")){
            menor = 25.0
            mayor = 39.0
        }else if(raza.equals("Gigantes")){
            menor = 34.0
            mayor = 82.0
        }

        println("mayor " + mayor)
        println("menor " + menor)
        println("raza " + raza)


        tv_nombre.setText("El IMC de " + nombre + " es:")
        tv_peso_final1.setText("" + imcTotal)

        if(imcTotal <= mayor && imcTotal >= menor){
            var mensaje =  "Peso ideal"
            tv_peso_final_mensaje.setText(mensaje)
            img_1.setImageResource(R.drawable.perro)

        }else if(imcTotal > mayor){
            var mensaje =  "Sobre Peso"
            tv_peso_final_mensaje.setText(mensaje)
            img_1.setImageResource(R.drawable.perro_mas)

        }else{
            var mensaje =  "Peso inferior"
            tv_peso_final_mensaje.setText(mensaje)
            img_1.setImageResource(R.drawable.perro_menos)

        }

        btn_regresar.setOnClickListener{
            val saltar: Intent = Intent(this, MainActivity::class.java)
            startActivity(saltar)
        }

    }
}