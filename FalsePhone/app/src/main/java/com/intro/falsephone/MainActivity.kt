package com.intro.falsephone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(this.intent.data != null) {
            tvData.text = this.intent.data.toString()
        } else {
            tvData.text = getString(R.string.no_data)
        }
    }
}
