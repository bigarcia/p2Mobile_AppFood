package com.example.bianca.appfood.scenarios

import com.example.bianca.appfood.entities.FoodList
import com.example.bianca.appfood.netrwork.RetrofitInicializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//Faz o acesso ao serviço e existe a lista na camada de View
class ListaPresenter (val view : ListaContract.View) : ListaContract.Presenter {

    //pega serviço no retrofit
    override fun onLoadList() {

        val foodService = RetrofitInicializer().createFoodService()
        //retorna uma lista com todas as views para exibir na view

        val call = foodService.getLatestMeals()
        //call.execute()executa de forma síncrona na mesma thread
        //call.enqueue enfileira
        //call back é uma interface que fala o que ocorre quando requisição falhar ou for bem sussecidada
        //criar objeto anonimo
        call.enqueue(object : Callback<FoodList> {
            override fun onFailure(call: Call<FoodList>, t: Throwable) {
                view.showMessage("Falha na conexão. Verifique o acesso a internet")
            }

            override fun onResponse(call: Call<FoodList>, response: Response<FoodList>) {
//verifica se retorna um FoodList
                if (response.body() != null) {
                    view.showList(response.body()!!.food)
                } else {
                    view.showMessage("Sem receita para hoje")
                }
            }
        })
    }

}

   /* override fun RandomMeal() {
        val foodService = RetrofitInicializer().createFoodService()
        val call = foodService.getRandom()

        call.enqueue(object : Callback<FoodList> {
            override fun onFailure(call: Call<FoodList>, t: Throwable) {
                view.showMessage("Falha na conexão. Verifique o acesso à Internet")
            }

           override fun onResponse(call: Call<FoodList>, response: Response<FoodList>) {
                if (response.body() != null) {
                    view.listInDetail(response.body()!!.meals.first())
                } else {
                    view.showMessage("Essa refeição não está disponível")
                }
            }
        })
    }*/
