package com.project.kotlincalc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var isNewOperator = true
    var oldNo = ""
    var opVal = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberEvent(view: View) {
        if (isNewOperator)
            editText.setText("")
        isNewOperator = false
        var clickVal: String = editText.text.toString()
        var btnSelect = view as Button
        when (btnSelect.id) {
            btn_1.id -> {
                clickVal += "1"
            }
            btn_2.id -> {
                clickVal += "2"
            }
            btn_3.id -> {
                clickVal += "3"
            }
            btn_4.id -> {
                clickVal += "4"
            }
            btn_5.id -> {
                clickVal += "5"
            }
            btn_6.id -> {
                clickVal += "6"
            }
            btn_7.id -> {
                clickVal += "7"
            }
            btn_8.id -> {
                clickVal += "8"
            }
            btn_9.id -> {
                clickVal += "9"
            }
            btn_0.id -> {
                clickVal += "0"
            }
            btn_dot.id -> {
                clickVal += "."
            }
            btn_plusMinus.id -> {
                clickVal = "-$clickVal"
            }

        }


        editText.setText(clickVal)

    }

    fun operatorEvent(view: View) {
        val clickVal = editText.text.toString()
        oldNo = clickVal
        isNewOperator = false
        var btnSelect = view as Button
        when (btnSelect.id) {
            btn_plus.id -> {
                opVal = "+"
            }
            btn_minus.id -> {
                opVal = "-"
            }
            btn_divide.id -> {
                opVal = "/"
            }
            btn_multi.id -> {
                opVal = "*"
            }
        }
        var value = clickVal.plus(opVal)
        editText.setText(value)

    }

    fun equalEvent(view: View) {
        var newNo = editText.text.toString()
        newNo = newNo.split(opVal)[1];
        var result = 0.0
        when (opVal) {
            "+" -> {
                result = oldNo.toDouble() + newNo.toDouble()
            }
            "-" -> {
                result = oldNo.toDouble() - newNo.toDouble()
            }
            "*" -> {
                result = oldNo.toDouble() * newNo.toDouble()
            }
            "/" -> {
                result = oldNo.toDouble() / newNo.toDouble()
            }

        }
        editText.setText(result.toString());
    }

    fun clearEvent(view: View) {
        editText.setText("")

    }
}