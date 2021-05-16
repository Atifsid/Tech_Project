package com.example.miniproject

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.app.ActivityCompat

class SmsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms)

        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.SEND_SMS),10)
    }

    fun onClick(v: View?){
        val num = findViewById<EditText>(R.id.edtMobno).text.toString()
        val msg = findViewById<EditText>(R.id.sms_messageEt).text.toString()
        sendMessage(num, msg)
    }

    fun sendMessage(num: String, msg: String){
        val smsManager = SmsManager.getDefault() as SmsManager
        smsManager.sendTextMessage(num,null,msg,null,null)
    }
}