package com.example.bingoalfabetico

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.close
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity(), ClickItemMenuListener {
    private val rvList: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rv_list)
    }

    private val adapter = HomeAdapter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bindViews()
        updateList()
    }

    private fun bindViews(){
        rvList.adapter = adapter
        rvList.layoutManager = GridLayoutManager(this, 2)
    }

    private fun updateList() {
        adapter.updateList(
            arrayListOf(
                HomeMenu(
                    "Bingo Alfabético",
                    R.drawable.ic_alfabetico,
                    BingoAlfabeticoActivity(),
                    true
                ),
                HomeMenu(
                    "Bingo Numérico",
                    R.drawable.ic_construction,
                    HomeActivity(),
                    false
                )
            )
        )
    }

    override fun clickItemMenu(homeMenu: HomeMenu) {
        if (!homeMenu.ativo){
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Em contrução")
            builder.setMessage("Este jogo está em construção")
            builder.setPositiveButton("Ok", {dialogInterface: DialogInterface, i: Int -> })
            builder.show()
        }else {
            val id = homeMenu.activity::class.java
            val intent = Intent(this, id)
            startActivity(intent)
        }
    }
}