package com.example.liongames

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.regex.Pattern

class RegActivity : AppCompatActivity() {
    lateinit var mail: EditText
    lateinit var pass: EditText
    lateinit var passcheck: EditText

    val pattern = ("[a-zA-Z0-9-\\._]{1,100}" +"@"+"[a-z]{1,6}"+"\\."+"[a-z]{1,5}")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)
        mail = findViewById(R.id.editTextText)
        pass = findViewById(R.id.editTextText2)
        passcheck = findViewById(R.id.editTextText5)
    }


    fun backtosignin(view: View) {
        val inten = Intent(this@RegActivity, SigninActivity::class.java)
        startActivity(inten)
        finish()
    }

    fun MailValid(text: String): Boolean {
        return Pattern.compile(pattern).matcher(text).matches()
    }



    fun regaction(view: View) {
        if (mail.text.toString().isNotEmpty() && pass.text.toString()
                .isNotEmpty() && passcheck.text.toString().isNotEmpty()
        ) {
            if (MailValid(mail.text.toString()))
                if (pass.text.toString()==passcheck.text.toString())
                {
                val intent = Intent(this@RegActivity, PatchActivity::class.java)
                startActivity(intent)
                finish()
                } else {
                Toast.makeText(this, "Пароли не совпадают!", Toast.LENGTH_SHORT).show()
                }
            else {
                Toast.makeText(this,"Ошибка в заполнении email!", Toast.LENGTH_SHORT).show()
            }

        } else {
            val alert = AlertDialog.Builder(this)
                .setTitle("Заполните текстовые поля")
                .setPositiveButton("OK", null)
                .create()
                .show()
        }
    }
}
