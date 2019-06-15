package com.intro.explicitintents

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val ACTIVITY3 = 3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvResults.visibility = View.GONE

        btnAct2.setOnClickListener{
            if (etName.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show()
            } else {
                val name = etName.text.toString().trim()
                val intent = Intent(this, Activity2::class.java)
                intent.putExtra("NameStr", name)
                startActivity(intent)
            }
        }

        btnAct3.setOnClickListener {
            val intent = Intent(this, Activity3::class.java)
            startActivityForResult(intent, ACTIVITY3)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ACTIVITY3) {
            if (resultCode == Activity.RESULT_OK) {
                val surname = data!!.getStringExtra("surnameStr")
                tvResults.text = surname

            } else if (resultCode == Activity.RESULT_CANCELED) {
                tvResults.text = getString(R.string.no_data_received)
            }
        }
        tvResults.visibility = View.VISIBLE
    }
}
