package com.intro.vectorassets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnChange.setOnClickListener{
            ivPic.setImageResource(R.drawable.cake)
        }

        ivPic.setOnClickListener{
            ivPic.setImageResource(R.drawable.cake)
        }
    }
}
