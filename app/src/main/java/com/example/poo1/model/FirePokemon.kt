package com.example.poo1.model

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

class FirePokemon(name:String="pok",
                  attackPower : Float=30f,
                  life: Float=100f)
    : Pokemon(name,attackPower,life) {
    private var ballTemperature: Int = 90

    constructor(name: String, attackPower: Float, ballTemperature: Int) : this(name, attackPower) {
        this.ballTemperature = ballTemperature
        this.attackPower= attackPower
        this.life = 100f
        this.ballTemperature= ballTemperature
        this.sayHi(this.name)
    }
    fun getBallTemperature():Int{return this.ballTemperature}
    fun setBallTemperature(ballTemperature: Int){ this.ballTemperature = ballTemperature}

    override fun attack(){ Toast.makeText(MainActivity.maincontext,"Al ataquee con fuego " , Toast.LENGTH_LONG).show()}




    fun createNewFirePokemon(v: View){
        var etFireName = v.findViewById<EditText>(R.id.etFireName)
        Log.e(TAG,etFireName.text.toString() + "nombre al crear fire" )
        var etFireAttackPower = v.findViewById<EditText>(R.id.etFireAttackPower)
        var etFireBallTemperature = v.findViewById<EditText>(R.id.etFireBallTemperature)


        var firePokemon = FirePokemon()

        if (!etFireName.text.isNullOrEmpty()&& !etFireAttackPower.text.isNullOrEmpty()
            && !etFireBallTemperature.text.isNullOrEmpty()){
            this.setName(etFireName.text.toString())
            Log.e(TAG,etFireName.text.toString() + "name")
            Log.e(TAG,etFireAttackPower.text.toString() + "AP FIRE")
            this.setAttackPower(etFireAttackPower.text.toString().toFloat())
            this.setBallTemperature(etFireBallTemperature.text.toString().toInt())


            var ivFirePokemon = v.findViewById<ImageView>(R.id.ivFirePokemon)
            ivFirePokemon.setImageResource(R.mipmap.fire)
            ivFirePokemon.setBackgroundColor(ContextCompat.getColor(v.context, R.color.white))

            var tvFirePokemon = v.findViewById<TextView>(R.id.tvFirePokemon)
            loadDataPokemon(tvFirePokemon)
            firePokemon.sayHi(this.getName())
        }


    }

    fun evolveFirePokemon(v:View,firePokemon: FirePokemon){
        var etEvolveFirePokemon = v.findViewById<EditText>(R.id.etEvolveFirePokemon)
        firePokemon.evolve(etEvolveFirePokemon.text.toString())
        var ivFirePokemon= v.findViewById<ImageView>(R.id.ivFirePokemon)
        ivFirePokemon.setImageResource(R.mipmap.fire_evolved)
        var tvFirePokemon = v.findViewById<TextView>(R.id.tvFirePokemon)
        loadDataPokemon(tvFirePokemon)
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