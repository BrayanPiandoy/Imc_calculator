package com.example.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat

class ResultActivity : AppCompatActivity() {

    private lateinit var tvresult:TextView
    private lateinit var tvdescription:TextView
    private lateinit var tvimc:TextView
    private lateinit var btnRecalcular:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val nombre: String = intent.extras?.getString("imc").orEmpty()

        initcomponents()
        initUi(nombre.toDouble())
        initListener()
    }

    private fun initListener() {
        btnRecalcular.setOnClickListener { onBackPressed() }
    }

    private fun initUi(result: Double) {

        tvimc.setText(result.toString())

        when(result){
            in 0.00..18.50 ->{ //bajo peso
                tvresult.text = getString(R.string.title_bajoPeso)
                tvdescription.text = getString(R.string.Description_bajoPeso)
                tvresult.setTextColor(ContextCompat.getColor(this, R.color.Peso_bajo))
            }
            in 18.51..24.99 ->{ // peso normal
                tvresult.text = getString(R.string.title_PesoNomral)
                tvdescription.text = getString(R.string.Description_pesoNormal)
                tvresult.setTextColor(ContextCompat.getColor(this, R.color.Peso_normal))
            }
            in 25.00..29.99 ->{ // sobrepeso
                tvresult.text = getString(R.string.title_Sobrepeso)
                tvdescription.text = getString(R.string.Description_sobrepeso)
                tvresult.setTextColor(ContextCompat.getColor(this, R.color.sobrepeso))
            }
            in 30.00..99.00 ->{ //obesidad
                tvresult.text = getString(R.string.title_OBESIDAD)
                tvdescription.text = getString(R.string.Description_Obesidad)
                tvresult.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
            }
        }
    }

    private fun initcomponents() {
        tvresult = findViewById(R.id.tvresult)
        tvdescription = findViewById(R.id.tvDescription)
        tvimc = findViewById(R.id.tvicm)
        btnRecalcular = findViewById(R.id.btnRecalcular)
    }


}