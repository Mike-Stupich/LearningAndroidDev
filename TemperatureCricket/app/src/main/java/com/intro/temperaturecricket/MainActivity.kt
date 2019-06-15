package com.intro.temperaturecricket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvTempRes.visibility = (View.GONE)

        btnSubmitTemp.setOnClickListener{
            val numChirps = etNumChirps.text.toString().toFloat()
            tvTempRes.text = String.format(getString(R.string.degree_result), calcTemp(numChirps))
            tvTempRes.visibility = (View.VISIBLE)
        }
    }

    private fun calcTemp(numChirps: Float):Float {
        return (numChirps / 3 + 4)
    }

}
