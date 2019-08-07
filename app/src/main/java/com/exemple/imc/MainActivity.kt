package com.exemple.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculateButton.setOnClickListener {
            val weight = weightEditTextView.text.toString()
            val height = heightEditTextView.text.toString()

            if(validateValues(arrayOf(weight, height))){
                displayResult(calcIMC(weight.toDouble(), height.toDouble()))
            }
        }

        clearButton.setOnClickListener {
            weightEditTextView.text.clear()
            heightEditTextView.text.clear()
            clearButton.visibility = View.GONE
        }
    }

    private fun calcIMC(weight: Double, height: Double): Double {
        return weight / height.pow(2)
    }

    private fun validateValues(values: Array<String>): Boolean{
        return values.all { v -> v.isNotEmpty() && v.isNotBlank()  }
    }

    private fun displayResult(result:Double){
        val intent = Intent(this, ResultActivity::class.java)

        intent.putExtra("imc_result", result)
        intent.putExtra("user_sex", sexSpinner.selectedItem.toString())

        this.startActivity(intent)

    }

}
