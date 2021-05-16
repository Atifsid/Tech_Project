package com.example.miniproject

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mail)

        val sendEmailBtn = findViewById<Button>(R.id.sendEmailBtn)
        sendEmailBtn.setOnClickListener {
            val recipient = findViewById<EditText>(R.id.recipientEt).text.toString()
            val subject = findViewById<EditText>(R.id.subjectEt).text.toString()
            val message = findViewById<EditText>(R.id.messageEt).text.toString()

            sendEmail(recipient, subject, message)
        }
    }

    private fun sendEmail(recipient: String, subject: String, message: String) {
        val mIntent = Intent(Intent.ACTION_SEND)
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"
        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        mIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        mIntent.putExtra(Intent.EXTRA_TEXT, message)

        try {
            //start email intent
            startActivity(Intent.createChooser(mIntent, "Choose Email Client"))

        }
        catch (e: Exception){
            //if anything goes wrong for example no email client application or any exception
            //get and show exception message.
            Toast.makeText(this,e.message,Toast.LENGTH_LONG).show()
        }
    }
}