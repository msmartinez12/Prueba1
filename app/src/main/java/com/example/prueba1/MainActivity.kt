package com.example.prueba1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_imc.setOnClickListener{
            val saltar: Intent = Intent(this, IMC::class.java)
            startActivity(saltar)
        }

        btn_grasa_macho.setOnClickListener{
            val saltar: Intent = Intent(this, IMC_Macho::class.java)
            startActivity(saltar)
        }

        btn_grasa_hembra.setOnClickListener{
            val saltar: Intent = Intent(this, IMC_Hembra::class.java)
            startActivity(saltar)
        }

    }
}