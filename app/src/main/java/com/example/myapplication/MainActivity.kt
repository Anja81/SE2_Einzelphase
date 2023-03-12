package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCon = findViewById<Button>(R.id.buttonConnect);
        val btnCalc = findViewById<Button>(R.id.buttonCalc);
        val textRes = findViewById<TextView>(R.id.textViewRes);
        var mNr = findViewById<EditText>(R.id.editTextNumber);
        var textServer = findViewById<TextView>(R.id.textViewServer)

        var client: Client = Client(textServer);


        btnCon.setOnClickListener{
            client.send(mNr.text.toString())
        }

        btnCalc.setOnClickListener {
            var mNrIn = mNr.text
            var mNrOut = ""

            for (i in 0..mNrIn.length - 1) {
                if (i % 2 == 1) {
                    mNrOut += (mNrIn[i].toInt() + 48).toChar()
                } else {
                    mNrOut += mNrIn[i]
                }
            }
            textRes.text = "Ihre neu berechnete MNr ist: $mNrOut"
        }
    }
}