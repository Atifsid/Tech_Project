package com.example.miniproject

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.jar.Manifest


class CallActivity : AppCompatActivity() {

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
        val callIntent = Intent(Intent.ACTION_CALL)
        val phoneNumber = findViewById<EditText>(R.id.text_number).toString()
        callIntent.data = Uri.parse("tel:$phoneNumber")
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