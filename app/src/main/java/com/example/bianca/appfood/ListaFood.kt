package com.example.bianca.appfood

//import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_lista_food.*

class ListaFood : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_food)
    }

    fun exibeLista(list: List<Food>) {

        val adapter = FoodAdapter(this, list)

        recyclerFood.adapter = adapter
        recyclerFood.layoutManager = LinearLayoutManager(this)
    }
}
