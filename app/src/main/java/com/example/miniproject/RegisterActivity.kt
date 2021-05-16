package com.example.miniproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Move to Login Screen. (Better approach than creating a new activity every time)
        tv_login.setOnClickListener { onBackPressed() }

        btn_register.setOnClickListener {
            when {
                // Check if email input field is empty, if true then print a toast.
                TextUtils.isEmpty(et_register_email.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Please enter Email.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                // Check if password input field is empty, if true then print a toast.
                TextUtils.isEmpty(et_register_password.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Please enter Password.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    // if input fields are not empty then store the input values to a val.
                    val email: String = et_register_email.text.toString().trim { it <= ' ' }
                    val password: String =
                        et_register_password.text.toString().trim { it <= ' ' }

                    // Create an instance and create a register user with email and password.
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->

                            // If the registration is successfully done.
                            if (task.isSuccessful) {

                                //Firebase registered user.
                                val firebaseUser: FirebaseUser = task.result!!.user!!

                                Toast.makeText(
                                    this@RegisterActivity,
                                    "You are registered successfully!",
                                    Toast.LENGTH_SHORT
                                ).show()

                                /**
                                 * Here the new user registered is automatically signed-in so we just sign-out
                                 * and send him to Main Screen with user id and email that user have used for registration.
                                 */

                                val intent =
                                    Intent(this@RegisterActivity, MainActivity::class.java)
                                intent.flags =
                                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                intent.putExtra("user_id", firebaseUser.uid)
                                intent.putExtra("email_id", email)
                                startActivity(intent)
                                finish()
                            } else (
                                    // If the registration is not successful then show an error message.
                                    Toast.makeText(
                                        this@RegisterActivity,
                                        task.exception!!.message.toString(),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    )
                        }
                }
            }
        }
    }
}