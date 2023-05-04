package com.example.liongames

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.regex.Pattern

class RecoveryActivity : AppCompatActivity() {
    lateinit var email:EditText

    val pattern=("[a-zA-Z0-9-\\._]{1,100}" +"@"+"[a-z]{1,6}"+"\\."+"[a-z]{1,5}")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recovery)
        email=findViewById(R.id.editTextText6)
    }

    fun MailValid(text:String):Boolean
    {
        return Pattern.compile(pattern).matcher(text).matches()      }

    fun recover_action(view: View) {
        if(email.text.toString().isNotEmpty())
        {
            if (MailValid(email.text.toString())) {
                val intent = Intent(this@RecoveryActivity, RecoveryokActivity::class.java)
                startActivity(intent)
                finish()
            }
            else {
                Toast.makeText(this, "Ошибка при заполнении email", Toast.LENGTH_SHORT).show()
            }
        }
        else
        {
            val alert= AlertDialog.Builder(this)
                .setTitle("Заполните логин или email")
                .setPositiveButton("OK", null)
                .create()
                .show()
        }
    }

}