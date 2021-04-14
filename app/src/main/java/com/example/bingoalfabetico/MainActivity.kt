package com.example.bingoalfabetico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var audioLetra: MediaPlayer? = null
    private val alfabeto: MutableList<String?> = mutableListOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z")
    private val letrasSorteadas: MutableList<String?> = mutableListOf()
    private var bingo = 0
    private var letraSorteada = ""
    private var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btPlay = playButton
        val btBingo = bingoButton

        embaralhaLetra()

            btPlay.setOnClickListener {
            if (bingo == 1){
                embaralhaLetra()
                bingo = 0
                letraSorteada = alfabeto[contador].toString()
                falarLetra()
                playButton.setText("Sortear outra letra")

            }
            else {
                letraSorteada = alfabeto[contador].toString()
                falarLetra()
            }
        }

        btBingo.setOnClickListener{
            bingo()
        }

        }

    private fun falarLetra(){
         when {
            letraSorteada == "A" -> audioLetra = MediaPlayer.create(this, R.raw.a)
            letraSorteada == "B" -> audioLetra = MediaPlayer.create(this, R.raw.b)
            letraSorteada == "C" -> audioLetra = MediaPlayer.create(this, R.raw.c)
            letraSorteada == "D" -> audioLetra = MediaPlayer.create(this, R.raw.d)
            letraSorteada == "E" -> audioLetra = MediaPlayer.create(this, R.raw.e)
            letraSorteada == "F" -> audioLetra = MediaPlayer.create(this, R.raw.f)
            letraSorteada == "G" -> audioLetra = MediaPlayer.create(this, R.raw.g)
            letraSorteada == "H" -> audioLetra = MediaPlayer.create(this, R.raw.h)
            letraSorteada == "I" -> audioLetra = MediaPlayer.create(this, R.raw.i)
            letraSorteada == "J" -> audioLetra = MediaPlayer.create(this, R.raw.j)
            letraSorteada == "K" -> audioLetra = MediaPlayer.create(this, R.raw.k)
            letraSorteada == "L" -> audioLetra = MediaPlayer.create(this, R.raw.l)
            letraSorteada == "M" -> audioLetra = MediaPlayer.create(this, R.raw.m)
            letraSorteada == "N" -> audioLetra = MediaPlayer.create(this, R.raw.n)
            letraSorteada == "O" -> audioLetra = MediaPlayer.create(this, R.raw.o)
            letraSorteada == "P" -> audioLetra = MediaPlayer.create(this, R.raw.p)
            letraSorteada == "Q" -> audioLetra = MediaPlayer.create(this, R.raw.q)
            letraSorteada == "R" -> audioLetra = MediaPlayer.create(this, R.raw.r)
            letraSorteada == "S" -> audioLetra = MediaPlayer.create(this, R.raw.s)
            letraSorteada == "T" -> audioLetra = MediaPlayer.create(this, R.raw.t)
            letraSorteada == "U" -> audioLetra = MediaPlayer.create(this, R.raw.u)
            letraSorteada == "V" -> audioLetra = MediaPlayer.create(this, R.raw.v)
            letraSorteada == "W" -> audioLetra = MediaPlayer.create(this, R.raw.w)
            letraSorteada == "X" -> audioLetra = MediaPlayer.create(this, R.raw.x)
            letraSorteada == "Y" -> audioLetra = MediaPlayer.create(this, R.raw.y)
            letraSorteada == "Z" -> audioLetra = MediaPlayer.create(this, R.raw.z)
        }
        audioLetra?.start()
        textView.setText("LETRA ${letraSorteada}")
        letrasSorteadas.add(letraSorteada)
        contador++


    }

    private fun embaralhaLetra(){
        alfabeto.shuffle()
    }

    private fun bingo() {
        textView.setText("AS LETRAS SORTEADAS FORAM:\n $letrasSorteadas")
        bingo = 1
        contador = 0
        playButton.setText("Outra Rodada")
    }
}