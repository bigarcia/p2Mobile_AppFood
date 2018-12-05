package com.example.bianca.appfood.scenarios

//import android.net.Uri
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.os.Bundle
import android.widget.Toast
import com.example.bianca.appfood.entities.Food
import com.example.bianca.appfood.R
import kotlinx.android.synthetic.main.activity_lista_food.*

class ListaFood : AppCompatActivity(), ListaContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_food)
        val presenter : ListaContract.Presenter = ListaPresenter(this)
        presenter.onLoadList()


     }

    override fun showList(food: List<Food>) {

        val adapter = FoodAdapter(this, food)
        /*adapter.setOnItemClickListener {position ->
            val openBrowser = Intent(Intent.ACTION_VIEW)
            openBrowser.data = Uri.parse(food.get(position).source)
            startActivity(openBrowser)
        }*/


        recyclerFood.adapter = adapter
        recyclerFood.layoutManager = LinearLayoutManager(this)
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }


}
