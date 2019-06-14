package com.intro.magicidapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvResults.visibility = View.GONE

        btnIdSubmit.setOnClickListener {
            val idNum = etID.text.toString().trim()
            val dob = idNum.substring(0, 6)
            val sex = idNum[6].toString().toInt()
            val sGender = if (sex < 5) "Female" else "Male"
            val nationality = idNum[10].toString().toInt()
            val sNationality = if (nationality == 0) "SA Citizen" else "Permanent Resident"
            tvResults.text = String.format("%s\n%s\n%s",
                String.format(getString(R.string.dob), dob),
                String.format(getString(R.string.gender), sGender),
                String.format(getString(R.string.nationality), sNationality))
            tvResults.visibility = View.VISIBLE
        }

    }

}