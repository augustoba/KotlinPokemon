package com.example.poo1.model

import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.poo1.MainActivity.Companion.maincontext
import com.example.poo1.R
import com.google.android.material.snackbar.Snackbar

class EarthPokemon(name:String = "pok",
                   attackPower:Float = 30f,
                   life:Float = 100f)
    :Pokemon(name,attackPower,life) {
        private var depth :Int = 100

    constructor(name: String, attackPower: Float, depth: Int) : this(name, attackPower) {
        this.name = name
        this.attackPower = attackPower
        this.life =  100f
        this.depth = depth
        this.sayHi(this.name)
      }

    fun getDepth():Int{return this.depth}
    fun setDepth(maxResistance: Int){this.depth = depth}


    fun createFirePokemon(v:View){

        var etEarthName = v.findViewById<EditText>(R.id.etEarthName)
        var etEarthAttackPower = v.findViewById<EditText>(R.id.etEarthAttackPower)
        var etEarthMaxDepth = v.findViewById<EditText>(R.id.etEarthMaxDepth)

        var earthPokemon= EarthPokemon()

        if ( !etEarthName.text.toString().isNullOrEmpty() && !etEarthAttackPower.text.toString().isNullOrEmpty()
            && !etEarthMaxDepth.text.toString().isNullOrEmpty() ){
            this.setName(etEarthName.text.toString())
            this.setAttackPower(etEarthAttackPower.text.toString().toFloat())
            this.setDepth(etEarthMaxDepth.text.toString().toInt())

            var ivEarthPokemon = v.findViewById<ImageView>(R.id.ivEarthPokemon)
            ivEarthPokemon.setImageResource(R.mipmap.earth)
            ivEarthPokemon.setBackgroundColor(ContextCompat.getColor(v.context, R.color.white))

            var tvEarthPokemon = v.findViewById<TextView>(R.id.tvEarthPokemon)
            loadDataPokemon(tvEarthPokemon)
            earthPokemon.sayHi(this.getName())
        }
    }

    fun evolveEarthPokemon(v:View,earthPokemon: EarthPokemon){
        var etEvolveEarthPokemon = v.findViewById<EditText>(R.id.etEvolveEarthPokemon)
        earthPokemon.evolve(etEvolveEarthPokemon.text.toString())
        var ivEarthPokemon= v.findViewById<ImageView>(R.id.ivEarthPokemon)
        ivEarthPokemon.setImageResource(R.mipmap.earth_evolved)
        var tvEarthPokemon = v.findViewById<TextView>(R.id.tvEarthPokemon)
        loadDataPokemon(tvEarthPokemon)
        Snackbar.make(v,"evoluciono", Snackbar.LENGTH_LONG).show();
    }

    private fun loadDataPokemon(text: TextView) {
        var description: String = ""
        description += this.getName() + " ("
        description += "AP: " + this.getAttackPower().toInt()
        description += " - L: " + this.getLife().toInt() + ")"
        text.text = description
    }

    fun digTunnel(){
        Toast.makeText(maincontext,"Cabare un tunel de ${this.depth} de profundidad",
            Toast.LENGTH_LONG)
    }

}