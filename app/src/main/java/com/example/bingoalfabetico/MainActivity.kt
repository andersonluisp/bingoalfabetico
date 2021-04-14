package com.example.bingoalfabetico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var letra: MediaPlayer? = null
    private val alfabeto: MutableList<String?> = mutableListOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z")
    private val letrasSorteadas: MutableList<String?> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btPlay = playButton
        val btBingo = bingoButton
        var contador = 1
        var letraSorteada = ""
        embaralhaLetra()

        btPlay.setOnClickListener {
            letraSorteada = alfabeto[contador].toString()

            when {
                letraSorteada == "A" -> letra = MediaPlayer.create(this, R.raw.a)
                letraSorteada == "B" -> letra = MediaPlayer.create(this, R.raw.b)
                letraSorteada == "C" -> letra = MediaPlayer.create(this, R.raw.c)
                letraSorteada == "D" -> letra = MediaPlayer.create(this, R.raw.d)
                letraSorteada == "E" -> letra = MediaPlayer.create(this, R.raw.e)
                letraSorteada == "F" -> letra = MediaPlayer.create(this, R.raw.f)
                letraSorteada == "G" -> letra = MediaPlayer.create(this, R.raw.g)
                letraSorteada == "H" -> letra = MediaPlayer.create(this, R.raw.h)
                letraSorteada == "I" -> letra = MediaPlayer.create(this, R.raw.i)
                letraSorteada == "J" -> letra = MediaPlayer.create(this, R.raw.j)
                letraSorteada == "K" -> letra = MediaPlayer.create(this, R.raw.k)
                letraSorteada == "L" -> letra = MediaPlayer.create(this, R.raw.l)
                letraSorteada == "M" -> letra = MediaPlayer.create(this, R.raw.m)
                letraSorteada == "N" -> letra = MediaPlayer.create(this, R.raw.n)
                letraSorteada == "O" -> letra = MediaPlayer.create(this, R.raw.o)
                letraSorteada == "P" -> letra = MediaPlayer.create(this, R.raw.p)
                letraSorteada == "Q" -> letra = MediaPlayer.create(this, R.raw.q)
                letraSorteada == "R" -> letra = MediaPlayer.create(this, R.raw.r)
                letraSorteada == "S" -> letra = MediaPlayer.create(this, R.raw.s)
                letraSorteada == "T" -> letra = MediaPlayer.create(this, R.raw.t)
                letraSorteada == "U" -> letra = MediaPlayer.create(this, R.raw.u)
                letraSorteada == "V" -> letra = MediaPlayer.create(this, R.raw.v)
                letraSorteada == "W" -> letra = MediaPlayer.create(this, R.raw.w)
                letraSorteada == "X" -> letra = MediaPlayer.create(this, R.raw.x)
                letraSorteada == "Y" -> letra = MediaPlayer.create(this, R.raw.y)
                letraSorteada == "Z" -> letra = MediaPlayer.create(this, R.raw.z)
            }
            falarLetra()
            textView.setText("LETRA {${letraSorteada}")
            letrasSorteadas.add(letraSorteada)
            contador++
        }

        btBingo.setOnClickListener{
            textView.setText("AS LETRAS SORTEADAS FORAM:\n $letrasSorteadas")
        }

        }

    private fun falarLetra( ){
        letra?.start()
    }

    private fun embaralhaLetra(){
        alfabeto.shuffle()
    }
}