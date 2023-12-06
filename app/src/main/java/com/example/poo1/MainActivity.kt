package com.example.poo1

import android.content.ContentValues.TAG
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.poo1.model.EarthPokemon
import com.example.poo1.model.FirePokemon
import com.example.poo1.model.Pokemon
import com.example.poo1.model.WaterPokemon
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    companion object{
        lateinit var maincontext: Context
    }

    private lateinit var pok : Pokemon
    private lateinit var  waterPokemon: WaterPokemon
    private lateinit var  firePokemon: FirePokemon
    private lateinit var earthPokemon: EarthPokemon

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        maincontext = applicationContext
        waterPokemon = WaterPokemon()
        firePokemon= FirePokemon()
        earthPokemon= EarthPokemon()


        var btFight = findViewById<Button>(R.id.btFight)
        btFight.setOnClickListener {
            fight(waterPokemon, firePokemon)
        }

      }

    fun createNewPokemon(v: View){
        var etName = findViewById<EditText>(R.id.etName)
        var etAttackPower = findViewById<EditText>(R.id.etAttackPower)

        pok = Pokemon()

        if (!etName.text.isNullOrEmpty()&& !etAttackPower.text.isNullOrEmpty()){
            Log.e(TAG,etName.text.toString())
            Log.e(TAG,etAttackPower.text.toString())


            pok.setName(etName.text.toString())

            pok.setAttackPower(etAttackPower.text.toString().toFloat())
            var ivPokemon = findViewById<ImageView>(R.id.ivPokemon)
            ivPokemon.setImageResource(R.mipmap.pokemon)

            var tvPokemon = findViewById<TextView>(R.id.tvPokemon)
            loadDataPokemon(tvPokemon,pok)
            pok.sayHi(pok.getName())
            etName.text.clear()
            etAttackPower.text.clear()
        }

    }


    fun createNewWaterPokemon(v: View){


        waterPokemon.createNewWaterPokemon(findViewById<View>(android.R.id.content))
        Log.e(TAG,waterPokemon.getName() + "EN LA CREACION")
    }

    fun cureWaterPokemon(v: View){
        waterPokemon.cure()
        var tvWaterPokemon = findViewById<TextView>(R.id.tvWaterPokemon)
        loadDataPokemon(tvWaterPokemon,waterPokemon)

    }

    fun sayHiWaterPokemon(v:View){waterPokemon.sayHi(waterPokemon.getName()) }
    fun evolveWaterPokemon(v:View){
       waterPokemon.evolveWaterPokemon(findViewById<View>(android.R.id.content),waterPokemon)
    }

    private fun fight(p1: WaterPokemon, p2: FirePokemon) {
        Log.v(TAG,p1.getName() + p2.getName())

        var emtLog = findViewById<EditText>(R.id.emtLog)
        val textViewToShowLog = findViewById<TextView>(R.id.textViewToShowLog)
        textViewToShowLog.text = emtLog.text.toString()
        emtLog.setText("")


        var text = ""

        text += "\n${p1.getName()} (${p1.getLife().toInt()}) Vs ${p2.getName()} (${p2.getLife().toInt()})"

        while (p1.getLife() > 0 && p2.getLife() > 0){
            text += "\n${p1.getName()} ataca!"
             p1.attack();
            p2.setLife(p2.getLife() - p1.getAttackPower())
           text += "\n${p1.getName()} (${p1.getLife().toInt()}) Vs ${p2.getName()} (${p2.getLife().toInt()})"

            if (p2.getLife() > 0){

               text += "\n${p2.getName()} ataca!"

                p2.attack()
                p1.setLife(p1.getLife() - p2.getAttackPower())
                text += "\n${p1.getName()} (${p1.getLife().toInt()}) Vs ${p2.getName()} (${p2.getLife().toInt()})"

            }
        }


        if (p1.getLife() > 0){

            Toast.makeText(maincontext,"EL CAMPEON ES ${p1.getName()}", Toast.LENGTH_LONG).show()
        }

        else{

            Toast.makeText(maincontext,"EL CAMPEON ES ${p2.getName()}" , Toast.LENGTH_LONG).show()
        }

        emtLog.setText(text)
        Log.e(TAG,text + "TEXTO AL FINAL")


        var tvFirePokemon = findViewById<TextView>(R.id.tvFirePokemon)
        loadDataPokemon(tvFirePokemon, firePokemon)

        var tvEarthPokemon = findViewById<TextView>(R.id.tvEarthPokemon)
        loadDataPokemon(tvEarthPokemon, earthPokemon)
    }

   fun createNewFirePokemon (v: View){

       firePokemon.createNewFirePokemon(findViewById<View>(android.R.id.content))
       Log.e(TAG,firePokemon.getName() + "EN LA CREACION")
   }
    fun evolveFirePokemon(v:View){
        firePokemon.evolveFirePokemon(findViewById<View>(android.R.id.content),firePokemon)
    }
    fun cureFirePokemon(v: View){
        firePokemon.cure()
        var tvFirePokemon = findViewById<TextView>(R.id.tvFirePokemon)
        loadDataPokemon(tvFirePokemon,firePokemon)

    }

    fun sayHiFirePokemon(v:View){firePokemon.sayHi(firePokemon.getName()) }

    fun createNewEarthPokemon(v: View){

        earthPokemon.createFirePokemon (findViewById<View>(android.R.id.content))


    }
    fun cureEarthPokemon(v: View){
        earthPokemon.cure()
        var tvEarthPokemon = findViewById<TextView>(R.id.tvEarthPokemon)
        loadDataPokemon(tvEarthPokemon,earthPokemon)

    }

    fun evolveEarthPokemon(v:View){
        earthPokemon.evolveEarthPokemon(findViewById<View>(android.R.id.content),earthPokemon)
    }



    private fun loadDataPokemon(text: TextView,pokemon: Pokemon){
        var description: String = ""

        description += pokemon.getName() + " ("
        description += "AP: "+ pokemon.getAttackPower().toInt()
        description += " - L: " + pokemon.getLife().toInt() + ")"
        text.text = description
    }
}

