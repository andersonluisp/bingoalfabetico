package com.example.bingoalfabetico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var letra: MediaPlayer? = null
    val alfabeto: MutableList<String?> = mutableListOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btPlay = playButton

        embaralhaLetra()

        btPlay.setOnClickListener {
            letra = MediaPlayer.create(this, R.raw.a);
            falarLetra()
            textView.setText("Letras embaralhadas para sorteio:\n${alfabeto.toString()}")
        }

        }

    private fun falarLetra( ){
        letra?.start()
    }

    private fun embaralhaLetra(){
        alfabeto.shuffle()
    }
}