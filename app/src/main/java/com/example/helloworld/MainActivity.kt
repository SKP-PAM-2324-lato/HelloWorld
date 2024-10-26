package com.example.helloworld

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button = findViewById<Button>(R.id.acceptButton)
        button.setOnClickListener {
            val nameEdit = findViewById<EditText>(R.id.nameEdit)
            val helloText = findViewById<TextView>(R.id.helloText)

            val name = nameEdit.text
            helloText.text = "Cześć, $name"
        }

        findViewById<Button>(R.id.ageButton).setOnClickListener{
            val birthYear = findViewById<EditText>(R.id.yearEdit)
            val currentYear = LocalDate.now().year
            val age = currentYear - birthYear.text.toString().toInt()
            findViewById<TextView>(R.id.ageText).text = age.toString()
        }

        findViewById<Button>(R.id.checkButton).setOnClickListener{
            val element = findViewById<Spinner>(R.id.spinner).selectedItem.toString()
            Toast.makeText(baseContext, "Wybrano element: $element", Toast.LENGTH_LONG).show()
        }



    }
}