package com.example.txalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    private  var operand = 0.0
    private  var operation = " "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, "Hello MF", Toast.LENGTH_SHORT).show()
        resultTextView = findViewById<TextView>(R.id.textView)
    }

    fun onClick(clickedView: View) {
        if (clickedView is TextView) {
            var text = resultTextView.text.toString()
            val number = clickedView.text.toString()
            if (text == "0") {
                text = ""
            }
            resultTextView.text = text + number
        }
    }

    fun operationClick(clickedView: View) {
        if (clickedView is TextView) {
            operand = resultTextView.text.toString().toDouble()
            operation = clickedView.text.toString()
            resultTextView.text = "0"
        }
    }
    fun equalClick(clickedView: View){
        var secOperand = resultTextView.text.toString().toDouble()
        if(operation == ""){
            resultTextView.text = resultTextView.text
        }else {
            when (operation) {
                "+" -> resultTextView.text = (operand + secOperand).toString()
                "-" -> resultTextView.text = (operand - secOperand).toString()
                "/" -> resultTextView.text = (operand / secOperand).toString()
                "*" -> resultTextView.text = (operand * secOperand).toString()
            }
            operation = ""
            operand = 0.0
            var newnumber = resultTextView.text.toString()
            if(newnumber.substring(newnumber.length-2, newnumber.length) == ".0"){
                resultTextView.text = newnumber.substring(0, newnumber.length-2)
            }
        }
    }
    fun clearClick(clickedView: View) {
        operand = 0.0
        resultTextView.text = "0"
    }
    fun backClick(clickedView: View) {
        var newOp = operand.toString().substring(0,operand.toString().length - 2)
        if (resultTextView.text.toString().length == 1 && operand==0.0) {
            resultTextView.text = "0"
        }
        else if(resultTextView.text.toString().length==1) {
            resultTextView.text = newOp
            operand = 0.0
        }else {
            resultTextView.text = resultTextView.text.toString().substring(0, resultTextView.text.toString().length - 1)
        }
    }
    fun dotClick(clickedView: View){
        if(clickedView is TextView) {
            var sum = 0
            var kai = resultTextView.text.toString()
            println(kai)
            var a = kai.length
            var dot = clickedView.text.toString()
            for (i in 0 until a )
                if(kai.get(i)=='.'){
                    sum+=1
                }
                if (sum == 0) {
                    resultTextView.text = kai + '.'
                }

        }

    }

}

