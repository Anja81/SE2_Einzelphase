package com.example.myapplication

import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class Client(val textFeld: TextView) {

     fun send(mNr: String) {
        Thread {
            try {
                val socket = Socket("se2-isys.aau.at", 53212)
                val outToServer = PrintWriter(socket.getOutputStream(), true)
                val inFromServer = BufferedReader(InputStreamReader(socket.getInputStream()))
                outToServer.println(mNr)
                val res = inFromServer.readLine()
                socket.close()

                GlobalScope.launch(Dispatchers.Main) {
                    textFeld.text = res
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }.start()
    }

}