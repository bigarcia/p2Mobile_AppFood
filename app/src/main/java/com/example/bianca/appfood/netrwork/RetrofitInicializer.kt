package com.example.bianca.appfood.netrwork

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInicializer {

    val retrofit = Retrofit.Builder()
    .baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

    //Criar serviço baseado na interface. Retorna um FoodService
    fun createFoodService() = retrofit.create(FoodService::class.java)

}