package com.example.imccalculator

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class FirtsActivity : AppCompatActivity() {

    private lateinit var cdFemenino:CardView
    private lateinit var cdMasculino:CardView
    private lateinit var tvHeigth:TextView
    private lateinit var rsHeigth:RangeSlider
    private lateinit var btnRW: FloatingActionButton
    private lateinit var btnSW: FloatingActionButton
    private lateinit var twWeight: TextView
    private lateinit var btnRA: FloatingActionButton
    private lateinit var btnSA: FloatingActionButton
    private lateinit var twAge: TextView
    private lateinit var btncalcular:Button


    private var isMaleSelected:Boolean = true
    private var isfameSelected:Boolean = false
    private var actWeight:Int = 60
    private var actAge:Int = 10
    private var actHeight:Int = 120

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firts)
        initComponents()
        initListener()
        initUI()
    }

    private fun initUI() {
        setGendercolor()
        setWeight()
        setAge()
    }

    private fun initListener() {

        cdFemenino.setOnClickListener {
            setGendercolor()
            changeGender()
            setGendercolor()
        }
        cdMasculino.setOnClickListener {
            setGendercolor()
            changeGender()
            setGendercolor()
        }

        rsHeigth.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            actHeight = df.format(value).toInt()
            tvHeigth.text = "$actHeight cm"
        }


        btnSW.setOnClickListener {
            actWeight += 1
            setWeight()
        }
        btnRW.setOnClickListener {
            actWeight -= 1
            setWeight()
        }

        btnSA.setOnClickListener {
            actAge += 1
            setAge()
        }
        btnRA.setOnClickListener {
            actAge -= 1
            setAge()
        }

        btncalcular.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("imc",calcularImc())
            startActivity(intent)
        }
    }

    private fun calcularImc():String {
        val numd = DecimalFormat("#.##")
        val imc = actWeight/(actHeight.toDouble()/100 * actHeight.toDouble()/100)
        val result = numd.format(imc).toDouble()
        return result.toString()
    }

    private fun setAge() {
        twAge.text = actAge.toString()
    }

    private fun setWeight() {
        twWeight.text = actWeight.toString()

    }

    private fun initComponents(){

        cdFemenino =findViewById(R.id.cdFemenino)
        cdMasculino =findViewById(R.id.cdMasculino)
        tvHeigth = findViewById(R.id.heigt)
        rsHeigth = findViewById(R.id.rsHeigth)
        btnRW = findViewById(R.id.btnRW)
        btnSW = findViewById(R.id.btnSW)
        twWeight = findViewById(R.id.twWeight)
        btnRA = findViewById(R.id.btnRA)
        btnSA = findViewById(R.id.btnSA)
        twAge = findViewById(R.id.twAge)
        btncalcular = findViewById(R.id.btncalcular)
    }

    private fun setGendercolor(){

        cdMasculino.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        cdFemenino.setCardBackgroundColor(getBackgroundColor(isfameSelected))

    }

    private fun changeGender(){
        isMaleSelected = !isMaleSelected
        isfameSelected = !isfameSelected
    }

    private fun getBackgroundColor(isSelectedComponent:Boolean) : Int {

        val referencecolor = if(isSelectedComponent){

           R.color.backgroun_component_selected

        }else{

            R.color.backgroun_component

        }

        return ContextCompat.getColor(this, referencecolor)
    }

}