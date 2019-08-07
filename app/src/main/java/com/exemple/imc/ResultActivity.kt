package com.exemple.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        displayResult()
    }

    private fun displayResult() {
        val imc: Double = intent.getDoubleExtra("imc_result", 0.0)
        val sex: String = intent.getStringExtra("user_sex") ?: getString(R.string.spinner_value_f)
        imcTextView.text = String.format("%.2f", imc)
        when (sex) {
            getString(R.string.spinner_value_f) -> {
                displayResultMen(imc)
            }
            getString(R.string.spinner_value_m) -> {
                displayResultWomen(imc)
            }
            else -> {
            }
        }

    }

    private fun displayResultMen(imc: Double) {

        when {
            imc < 20 -> {
                statusImcTextView.text = getString(R.string.weight_low)
                configImage(R.drawable.fem_abaixo)
            }
            imc < 25 -> {
                statusImcTextView.text = getString(R.string.weight_normal)
                configImage(R.drawable.fem_ideal)
            }
            imc < 30 -> {
                statusImcTextView.text = getString(R.string.weight_sobre)
                configImage(R.drawable.fem_sobre)
            }
            imc < 40 -> {
                statusImcTextView.text = getString(R.string.weight_obeso)
                configImage(R.drawable.fem_obeso)
            }
            else -> {
                statusImcTextView.text = getString(R.string.weight_extremo)
                configImage(R.drawable.fem_extremo_obeso)
            }
        }
    }

    private fun displayResultWomen(imc: Double) {
        when {
            imc < 20 -> {
                statusImcTextView.text = getString(R.string.weight_low)
                configImage(R.drawable.masc_abaixo)
            }
            imc < 25 -> {
                statusImcTextView.text = getString(R.string.weight_normal)
                configImage(R.drawable.masc_ideal)
            }
            imc < 30 -> {
                statusImcTextView.text = getString(R.string.weight_sobre)
                configImage(R.drawable.masc_sobre)
            }
            imc < 40 -> {
                statusImcTextView.text = getString(R.string.weight_obeso)
                configImage(R.drawable.masc_obeso)
            }
            else -> {
                statusImcTextView.text = getString(R.string.weight_extremo)
                configImage(R.drawable.masc_extremo_obeso)
            }
        }
    }

    private fun configImage(resource: Int) {
        imcImageView.setImageDrawable(ContextCompat.getDrawable(this, resource))
    }
}
