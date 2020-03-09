package com.prabhat.calculator

import android.view.View
import android.widget.Button
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import net.objecthunter.exp4j.ExpressionBuilder
import java.text.DecimalFormat

class MainViewModel : ViewModel() {


    var isDecimal = false
    var etValue = ObservableField<String>("")
    var totalResult = ObservableField<String>("")

    init {
        println("=init call==")
    }

    fun btnClick(view: View) {
        println("=Button click==")

        view as Button
        totalResult.set("")


        when (view.text) {
            "1" -> {
                etValue.set(etValue.get().toString() + "1")
                total()
            }
            "2" -> {
                etValue.set(etValue.get().toString() + "2")
                total()
            }
            "3" -> {
                etValue.set(etValue.get().toString() + "3")
                total()
            }

            "4" -> {
                etValue.set(etValue.get().toString() + "4")
                total()
            }
            "5" -> {
                etValue.set(etValue.get().toString() + "5")
                total()
            }
            "6" -> {
                etValue.set(etValue.get().toString() + "6")
                total()
            }
            "7" -> {
                etValue.set(etValue.get().toString() + "7")
                total()

            }
            "8" -> {
                etValue.set(etValue.get().toString() + "8")
                total()
            }
            "9" -> {
                etValue.set(etValue.get().toString() + "9")
                total()
            }
            "0" -> {
                etValue.set(etValue.get().toString() + "0")
                total()
            }
            "+" -> {
                isDecimal = false
                etValue.set(etValue.get().toString() + "+")
            }
            "-" -> {
                isDecimal = false

                etValue.set(etValue.get().toString() + "-")
            }
            "*" -> {
                isDecimal = false

                etValue.set(etValue.get().toString() + "*")
            }
            "/" -> {
                isDecimal = false

                etValue.set(etValue.get().toString() + "/")
            }
            "(" -> {
                isDecimal = false

                etValue.set(etValue.get().toString() + "(")
            }
            ")" -> {
                isDecimal = false

                etValue.set(etValue.get().toString() + ")")
            }
            "%" -> {
                isDecimal = false

                etValue.set(etValue.get().toString() + "/100*")
            }
            "." -> {
                if (!isDecimal) {
                    etValue.set(etValue.get().toString() + ".")
                    isDecimal = true
                }
            }
            "CLR" -> {
                if (etValue.get()!!.length > 0) {
                    etValue.set(etValue.get()!!.substring(0, etValue.get()!!.length - 1))
                    totalResult.set("")
                } else {
                    isDecimal = false

                }
            }
            "=" -> {
                total()
            }
        }
    }

    private fun total() {

        try {


            val expression = ExpressionBuilder(etValue.get()).build()
            val decimalFormat = DecimalFormat("##.######")
            val result = expression.evaluate()

            val result1 = decimalFormat.format(result)

            if (!result1.equals(etValue.get().toString()))
                totalResult.set(result1)

        } catch (e: Exception) {
            totalResult.set("Invalid Expression")

        }
    }

    fun onLongClick(view: View): Boolean {
        etValue.set("")
        totalResult.set("")
        isDecimal = false
        return false
    }


}