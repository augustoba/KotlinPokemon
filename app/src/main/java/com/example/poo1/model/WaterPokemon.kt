package com.example.poo1.model

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.poo1.MainActivity
import com.example.poo1.R
import com.google.android.material.snackbar.Snackbar

class WaterPokemon(
    name: String = "Pok",
    attackPower: Float = 30f,
    life: Float = 100f
) : Pokemon(name, attackPower, life) {

    private var maxResistance: Int = 500
    private var submergedTime: Int = 0

    constructor(name: String, attackPower: Float, maxResistance: Int) : this(name, attackPower) {
        this.maxResistance = maxResistance

    }
    fun getMaxResistance():Int{return this.maxResistance}
    fun setMaxResistance(maxResistance: Int){this.maxResistance = maxResistance}
    fun getSubmergedTime():Int{return this.submergedTime}
    fun setSubmergedTime(submergedTime : Int){this.submergedTime= submergedTime}
    fun breathe(){this.submergedTime=0}
    fun inmmerse(){this.submergedTime++}
    override fun attack(){ Toast.makeText(MainActivity.maincontext,"Al ataquee con chorro " , Toast.LENGTH_LONG).show()}

    fun createNewWaterPokemon(v: View){

        var etWaterName = v.findViewById<EditText>(R.id.etWaterName)
        Log.e(TAG,etWaterName.text.toString() + "nombre al crear water" )
        var etWaterAttackPower = v.findViewById<EditText>(R.id.etWaterAttackPower)
        var etWaterMaxResistence = v.findViewById<EditText>(R.id.etWaterMaxResistence)

        var waterPokemon = WaterPokemon()

        if (!etWaterName.text.isNullOrEmpty()&& !etWaterAttackPower.text.isNullOrEmpty()){
            this.setName(etWaterName.text.toString())
            this.setAttackPower(etWaterAttackPower.text.toString().toFloat())
            this.setMaxResistance(etWaterMaxResistence.text.toString().toInt())

            var ivWaterPokemon = v.findViewById<ImageView>(R.id.ivWaterPokemon)
            ivWaterPokemon.setImageResource(R.mipmap.water)
            ivWaterPokemon.setBackgroundColor(ContextCompat.getColor(v.context, R.color.white))

            var tvWaterPokemon = v.findViewById<TextView>(R.id.tvWaterPokemon)
            loadDataPokemon(tvWaterPokemon)
            waterPokemon.sayHi(this.getName())
        }

    }

    fun evolveWaterPokemon(v:View,waterPokemon: WaterPokemon){
        var etEvolveWaterPokemon = v.findViewById<EditText>(R.id.etEvolveWaterPokemon)
        waterPokemon.evolve(etEvolveWaterPokemon.text.toString())
        var ivWaterPokemon= v.findViewById<ImageView>(R.id.ivWaterPokemon)
        ivWaterPokemon.setImageResource(R.mipmap.water_evolved)
        var tvWaterPokemon = v.findViewById<TextView>(R.id.tvWaterPokemon)
        loadDataPokemon(tvWaterPokemon)
        Snackbar.make(v,"evoluciono", Snackbar.LENGTH_LONG).show();
    }

     private fun loadDataPokemon(text: TextView) {
        var description: String = ""
        description += this.getName() + " ("
        description += "AP: " + this.getAttackPower().toInt()
        description += " - L: " + this.getLife().toInt() + ")"
        text.text = description
    }



}



