package com.scriptsbundle.pay

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private val TEZ_REQUEST_CODE = 123

    private val GOOGLE_TEZ_PACKAGE_NAME = "com.google.android.apps.nbu.paisa.user"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val paybtn: Button = findViewById<Button>(R.id.upi)

        paybtn.setOnClickListener {

            val uri = Uri.Builder()
                .scheme("upi")
                .authority("pay")
                .appendQueryParameter("pa", "neeleshsahu290@oksbi")
                .appendQueryParameter("pn", "Aashi mobile gallery")
                .appendQueryParameter("mc", "0000")
                .appendQueryParameter("tr", "12465784")
                .appendQueryParameter("tn", "Payment")
                .appendQueryParameter("am", "5")
                .appendQueryParameter("cu", "INR")
                .appendQueryParameter("url", "https://stackoverflow.com/")
                .build()
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = uri
            intent.setPackage(GOOGLE_TEZ_PACKAGE_NAME)
            startActivityForResult(intent, TEZ_REQUEST_CODE)


        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TEZ_REQUEST_CODE) {
            // Process based on the data in response.
            data?.getStringExtra("Status")?.let { Log.d("result", it) };
            Log.d("result",data.toString());
        }

    }

}