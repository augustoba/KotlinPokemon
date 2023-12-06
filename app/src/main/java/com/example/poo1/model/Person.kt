package com.example.poo1.model

import android.content.ContentValues.TAG
import android.util.Log

 open class Person(var name: String,  var passport: String?=null) {

    var alive:Boolean=true

    fun die (){
        if (alive){
            this.alive=false
        }else{
            Log.e(TAG,"ya esta muerta")
        }

    }
}