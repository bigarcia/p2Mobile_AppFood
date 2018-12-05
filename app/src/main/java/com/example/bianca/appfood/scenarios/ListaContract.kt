package com.example.bianca.appfood.scenarios

import com.example.bianca.appfood.entities.Food

interface ListaContract {
    interface View{
        fun showMessage(msg: String)
        fun showList(food: List<Food>)

    }

    interface Presenter{
        fun onLoadList()
    }
}