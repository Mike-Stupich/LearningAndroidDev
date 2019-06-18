package com.intro.intentschallenge

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_new_contact.*

class NewContact : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_contact)

        val intent = Intent()
        ivHappy.setOnClickListener{
            intent.putExtra("faceChoice", R.drawable.happy)
            passDataToMain(intent)
        }

        ivNeutral.setOnClickListener{
            intent.putExtra("faceChoice", R.drawable.neutral)
            passDataToMain(intent)
        }

        ivSad.setOnClickListener{
            intent.putExtra("faceChoice", R.drawable.sad)
            passDataToMain(intent)
        }
    }

    private fun passDataToMain(intent: Intent) {
        if (etName.text.isEmpty() || etPhone.text.isEmpty()
            || etWeb.text.isEmpty() || etLoc.text.isEmpty()) {
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show()
        } else {
            intent.putExtra("name", etName.text.toString().trim())
            intent.putExtra("phone", etPhone.text.toString().trim())
            intent.putExtra("web", etWeb.text.toString().trim())
            intent.putExtra("loc", etLoc.text.toString().trim())
            setResult(Activity.RESULT_OK, intent)
            this.finish()
        }
    }
}
