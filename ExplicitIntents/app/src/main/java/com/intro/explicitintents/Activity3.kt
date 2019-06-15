package com.intro.explicitintents

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_3.*

class Activity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)

        btnSubmit.setOnClickListener{
            if (etSurname.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT)
            } else {
                val surname = etSurname.text.toString().trim()
                val intent = Intent()
                intent.putExtra("surnameStr", surname)
                setResult(Activity.RESULT_OK, intent)
                this.finish()
            }
        }
        btnCancel.setOnClickListener{
            setResult(Activity.RESULT_CANCELED)
            this.finish()
        }
    }
}
