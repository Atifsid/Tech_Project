package com.example.miniproject

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_call.*
import java.util.jar.Manifest


class CallActivity : AppCompatActivity() {

    internal var textNumber: String?=""
    private val REQUEST_PHONE_CALL = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call)

        val callButton = findViewById<Button>(R.id.btn_dial)

        callButton.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(this,android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), REQUEST_PHONE_CALL)

            }   else{
                startCall()
            }

        }

    }

    @SuppressLint("MissingPermission")
    private fun startCall() {
        val etTextNumber = findViewById<TextView>(R.id.text_number)
        textNumber = etTextNumber.text.toString().trim()

        val callIntent = Intent(Intent.ACTION_CALL)

        callIntent.data = Uri.parse("tel:$textNumber")
        startActivity(callIntent)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(requestCode == REQUEST_PHONE_CALL)startCall()
    }

}