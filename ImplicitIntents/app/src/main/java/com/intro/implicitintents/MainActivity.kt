package com.intro.implicitintents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCall.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)
            startActivity(intent)
        }

        btnCallFriend.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:6133250302"))
            startActivity(intent)
        }

        btnMap.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=135 Macassa Circle, Ottawa, ON"))
            startActivity(intent)
        }

        btnWeb.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(intent)
        }
    }
}
