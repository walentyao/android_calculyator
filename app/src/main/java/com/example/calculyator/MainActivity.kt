package com.example.calculyator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var operation = 0
    private lateinit var oneOutPutNumber : TextView
    private lateinit var twoOutPutNumber : TextView
    private lateinit var threeOutPutNumber : EditText
    private lateinit var button : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        oneOutPutNumber = findViewById(R.id.oneOutputNumber)
        twoOutPutNumber = findViewById(R.id.twoOutputNumber)
        threeOutPutNumber = findViewById(R.id.threeOutPutNumber)
        threeOutPutNumber.showSoftInputOnFocus = false
    }
    fun onClickNumber(view: View) {
        button = findViewById(view.id)
        val position = threeOutPutNumber.selectionStart
        var text = threeOutPutNumber.text.toString()
        text = StringBuilder(text).insert(position, button.text.toString()).toString()
        threeOutPutNumber.setText(text)
        threeOutPutNumber.setSelection(position + 1)
    }
    fun onClickDelete(view: View){
        val position = threeOutPutNumber.selectionStart
        val text1 = threeOutPutNumber.text.toString().substring(0, position - 1)
        val  text2 = threeOutPutNumber.text.toString().substring(position, threeOutPutNumber.text.toString().length)
        val text = text1.plus(text2)
        if (position > 0)
        {threeOutPutNumber.setText(text)
            threeOutPutNumber.setSelection(position - 1)}
    }
    fun onClickTextView(view: View){
        threeOutPutNumber.setText(oneOutPutNumber.text.toString())
        threeOutPutNumber.setSelection(threeOutPutNumber.text.toString().length)
        oneOutPutNumber.text=""
        twoOutPutNumber.text=""
    }
    fun onClear(view: View) {
        oneOutPutNumber.text=""
        twoOutPutNumber.text=""
        threeOutPutNumber.setText("")
    }
    fun onClickDot(view: View){
        button = findViewById(view.id)
        val position = threeOutPutNumber.selectionStart
        var text = threeOutPutNumber.text.toString()
        text = StringBuilder(text).insert(position, button.text.toString()).toString()

        if(!threeOutPutNumber.text.toString().contains('.'))
        {threeOutPutNumber.setText(text)
            threeOutPutNumber.setSelection(position + 1)}
    }
    fun onClickZnak(view: View){
        val text : String
        if(threeOutPutNumber.text.toString().startsWith('-')){
            text = threeOutPutNumber.text.toString().drop(1)
            threeOutPutNumber.setText(text)
        }
        else{
            text = "-"+threeOutPutNumber.text.toString()
            threeOutPutNumber.setText(text)
        }
    }
    fun onClickOperation(view: View){
        button = findViewById(view.id)
        if (view.id != R.id.button_ravno && !threeOutPutNumber.text.equals("")) {
            if(!oneOutPutNumber.text.equals("")){
                when(operation){
                    R.id.button_plus -> {oneOutPutNumber.text = (oneOutPutNumber.text.toString().toDouble()+threeOutPutNumber.text.toString().toDouble()).toString() }
                    R.id.button_minus -> {oneOutPutNumber.text = (oneOutPutNumber.text.toString().toDouble()-threeOutPutNumber.text.toString().toDouble()).toString()}
                    R.id.button_umn -> {oneOutPutNumber.text = (oneOutPutNumber.text.toString().toDouble()*threeOutPutNumber.text.toString().toDouble()).toString()}
                    R.id.button_delenie -> {oneOutPutNumber.text = (oneOutPutNumber.text.toString().toDouble()/threeOutPutNumber.text.toString().toDouble()).toString()}

                }
                twoOutPutNumber.text = button.text.toString()
                threeOutPutNumber.setText("")
            }else{
                twoOutPutNumber.text = button.text.toString()
                oneOutPutNumber.text = threeOutPutNumber.text.toString()
                threeOutPutNumber.setText("")
            }
            operation = view.id
        } else {
            if(!threeOutPutNumber.text.equals("")){
            var num = 0.0
            when (operation) {
                R.id.button_plus -> {
                    num = oneOutPutNumber.text.toString().toDouble() +
                            threeOutPutNumber.text.toString().toDouble()
                }
                R.id.button_delenie -> {
                    num = oneOutPutNumber.text.toString().toDouble() /
                            threeOutPutNumber.text.toString().toDouble()
                }
                R.id.button_umn -> {
                    num = oneOutPutNumber.text.toString().toDouble() *
                            threeOutPutNumber.text.toString().toDouble()
                }
                R.id.button_minus -> {
                    num = oneOutPutNumber.text.toString().toDouble() -
                            threeOutPutNumber.text.toString().toDouble()
                }
            }
            twoOutPutNumber.text = ""
            oneOutPutNumber.text = ""
            threeOutPutNumber.setText(num.toString().replace(".0",""))
                threeOutPutNumber.setSelection(threeOutPutNumber.text.toString().length)
        }else{
            twoOutPutNumber.text = button.text.toString()
                operation = view.id
            }
        }
    }
}