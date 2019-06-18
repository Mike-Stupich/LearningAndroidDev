package com.intro.intentschallenge

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val NEWCONTACT = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCreateNew.setOnClickListener{
            val intent = Intent(this, NewContact::class.java)
            startActivityForResult(intent, NEWCONTACT)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == NEWCONTACT) {
            if (resultCode == Activity.RESULT_OK) {
                ivFace.setImageResource(data!!.getIntExtra("faceChoice", R.drawable.neutral))
                tvName.text = data.getStringExtra("name")

                ivPhone.setOnClickListener{
                    val intent = Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:${data.getStringExtra("phone")}"))
                    startActivity(intent)
                }

                ivLoc.setOnClickListener{
                    val intent = Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:0,0?q=${data.getStringExtra("loc")}"))
                    startActivity(intent)
                }

                ivWeb.setOnClickListener{
                    var webAddr = data.getStringExtra("web")
                    if (webAddr!!.length < 8 || webAddr.substring(0, 8) != "https://") { webAddr = "https://$webAddr" }
                    val intent = Intent(Intent.ACTION_VIEW,
                        Uri.parse(webAddr))
                    startActivity(intent)
                }

                ivFace.visibility = View.VISIBLE
                tvName.visibility = View.VISIBLE
                ivPhone.visibility = View.VISIBLE
                ivLoc.visibility = View.VISIBLE
                ivWeb.visibility = View.VISIBLE
            }
        }
    }
}
