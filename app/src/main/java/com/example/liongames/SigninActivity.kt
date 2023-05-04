package com.example.liongames

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.regex.Pattern

class SigninActivity : AppCompatActivity() {
    lateinit var mail:EditText
    lateinit var pass:EditText

    val pattern=("[a-zA-Z0-9-\\._]{1,100}" +"@"+"[a-z]{1,6}"+"\\."+"[a-z]{1,5}")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        mail=findViewById(R.id.editTextText3)
        pass=findViewById(R.id.editTextText4)
    }
    fun emailValid(text:String):Boolean
    {
        return Pattern.compile(pattern).matcher(text).matches()      }

    fun topatch(view:View) {
        if(mail.text.toString().isNotEmpty()&&pass.text.toString().isNotEmpty())
        {
            if (emailValid(mail.text.toString())) {
                val intent = Intent(this@SigninActivity, PatchActivity::class.java)
                startActivity(intent)
                finish()
            }
            else {
                Toast.makeText(this, "Ошибка при заполнении email",Toast.LENGTH_SHORT).show()
            }
        }
        else
        {
            val alert=AlertDialog.Builder(this)
                .setTitle("Заполните текстовые поля")
                .setPositiveButton("OK", null)
                .create()
                .show()
        }
    }


    fun recover(view: View) {
        val inten = Intent(this@SigninActivity, RecoveryActivity::class.java)
        startActivity(inten)
        finish()
    }


}