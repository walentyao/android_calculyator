package com.example.calculyator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var operation = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onClickNumber(view: View) {
        val button: Button = findViewById(view.id)
        val inputNumber: TextView = findViewById(R.id.threeOutputNumber)
        val text = inputNumber.text.toString() + button.text.toString()
        inputNumber.text = text
    }
    fun onClickTextView(view: View){
        val oneOutputNumber: TextView = findViewById(R.id.oneOutputNumber)
        val twoOutputNumber: TextView = findViewById(R.id.twoOutputNumber)
        val threeOutputNumber: TextView = findViewById(R.id.threeOutputNumber)
        threeOutputNumber.text= oneOutputNumber.text.toString()
        oneOutputNumber.text=""
        twoOutputNumber.text=""
    }
    fun onClear(view: View) {
        val oneOutputNumber: TextView = findViewById(R.id.oneOutputNumber)
        val twoOutputNumber: TextView = findViewById(R.id.twoOutputNumber)
        val threeOutputNumber: TextView = findViewById(R.id.threeOutputNumber)
        oneOutputNumber.text=""
        twoOutputNumber.text=""
        threeOutputNumber.text=""
    }
    fun onClickDot(view: View){
        val threeOutputNumber: TextView = findViewById(R.id.threeOutputNumber)
        if(!threeOutputNumber.text.toString().contains('.'))
        threeOutputNumber.text=threeOutputNumber.text.toString()+"."
    }
    fun onClickZnak(view: View){
        val threeOutputNumber: TextView = findViewById(R.id.threeOutputNumber)
        if(threeOutputNumber.text.toString().startsWith('-')){
            threeOutputNumber.text = threeOutputNumber.text.toString().drop(1)
        }
        else{
            threeOutputNumber.text = "-"+threeOutputNumber.text.toString()
        }
    }
    fun onClickOperation(view: View){
        val button : Button = findViewById(view.id)
        val threeOutputNumber : TextView = findViewById(R.id.threeOutputNumber)
        val twoOutputNumber : TextView = findViewById(R.id.twoOutputNumber)
        val oneOutputNumber : TextView = findViewById(R.id.oneOutputNumber)
        if (view.id != R.id.button_ravno && !threeOutputNumber.text.equals("")) {
            if(!oneOutputNumber.text.equals("")){
                when(operation){
                    R.id.button_plus -> {oneOutputNumber.text = (oneOutputNumber.text.toString().toDouble()+threeOutputNumber.text.toString().toDouble()).toString() }
                    R.id.button_minus -> {oneOutputNumber.text = (oneOutputNumber.text.toString().toDouble()-threeOutputNumber.text.toString().toDouble()).toString()}
                    R.id.button_umn -> {oneOutputNumber.text = (oneOutputNumber.text.toString().toDouble()*threeOutputNumber.text.toString().toDouble()).toString()}
                    R.id.button_delenie -> {oneOutputNumber.text = (oneOutputNumber.text.toString().toDouble()/threeOutputNumber.text.toString().toDouble()).toString()}

                }
                twoOutputNumber.text = button.text.toString()
                threeOutputNumber.text = ""
            }else{
                twoOutputNumber.text = button.text.toString()
                oneOutputNumber.text = threeOutputNumber.text.toString()
                threeOutputNumber.text = ""
            }
            operation = view.id
        } else {
            if(!threeOutputNumber.text.equals("")){
            var num = 0.0
            when (operation) {
                R.id.button_plus -> {
                    num = oneOutputNumber.text.toString().toDouble() +
                            threeOutputNumber.text.toString().toDouble()
                }
                R.id.button_delenie -> {
                    num = oneOutputNumber.text.toString().toDouble() /
                            threeOutputNumber.text.toString().toDouble()
                }
                R.id.button_umn -> {
                    num = oneOutputNumber.text.toString().toDouble() *
                            threeOutputNumber.text.toString().toDouble()
                }
                R.id.button_minus -> {
                    num = oneOutputNumber.text.toString().toDouble() -
                            threeOutputNumber.text.toString().toDouble()
                }
            }
            twoOutputNumber.text = ""
            oneOutputNumber.text = ""
            threeOutputNumber.text = num.toString().replace(".0","")
        }else{
            twoOutputNumber.text = button.text.toString()
                operation = view.id
            }
        }
    }
}