package com.example.poo1.model

import android.widget.Toast
import com.example.poo1.MainActivity.Companion.maincontext

open class Pokemon(protected var name: String = "pok",
                   protected var attackPower: Float = 30f,
                   protected var life: Float = 100f
                ){

     fun Pokemon (n:String, aP:Float){
        this.name= n
        this. attackPower=aP
        this. life= 100f

    }

    internal fun getName(): String{ return this.name}
    internal  fun setName(name:String){  this.name=name}
    internal fun getAttackPower(): Float{ return this.attackPower}
    internal fun setAttackPower(attackPower: Float){  this.attackPower= attackPower}
    internal fun getLife(): Float{ return this.life}
    internal fun setLife(life: Float){  this.life= life}

    fun sayHi(name:String){
        maincontext?.let{
        Toast.makeText(maincontext,"Hola!!!  soy $name", Toast.LENGTH_LONG).show()}
    }
    fun cure(){this.life = 100f
        Toast.makeText(maincontext,"sanado $life", Toast.LENGTH_LONG).show()}

    fun evolve(name: String){
        this.name=name
        this.attackPower *= 1.20f
        this.sayHi(name)
    }




   open fun attack(){ Toast.makeText(maincontext,"Al ataquee " ,Toast.LENGTH_LONG).show()}


}