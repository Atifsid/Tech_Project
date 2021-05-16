package com.example.miniproject.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import com.example.miniproject.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FunctionsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FunctionsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val v = inflater . inflate (R.layout.fragment_functions, container, false)

        val call = v.findViewById<ImageView>(R.id.btn_call)
        val mail = v.findViewById<ImageView>(R.id.btn_mail)
        val sms = v.findViewById<ImageView>(R.id.btn_sms)
        val text = v.findViewById<ImageView>(R.id.btn_text)

        call.setOnClickListener {
            val intentCall = Intent(activity, CallActivity::class.java)
            startActivity(intentCall)
        }

        mail.setOnClickListener {
            val intentMail = Intent(activity, MailActivity::class.java)
            startActivity(intentMail)
        }

        sms.setOnClickListener {
            val intentSms = Intent(activity, SmsActivity::class.java)
            startActivity(intentSms)
        }

        text.setOnClickListener {
            val intentText = Intent(activity, TextActivity::class.java)
            startActivity(intentText)
        }
        return v
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FunctionsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FunctionsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}