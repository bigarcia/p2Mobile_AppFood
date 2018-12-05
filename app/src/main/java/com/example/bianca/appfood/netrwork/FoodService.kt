package com.example.bianca.appfood.netrwork

import com.example.bianca.appfood.entities.FoodList
import retrofit2.Call
import retrofit2.http.GET

interface FoodService {
    @GET("latest.php")
    fun getLatestMeals(): Call<FoodList>

    @GET("random.php")
    //Call implementa uma nova thread que vai retornar um valor para nós
    fun getRandom(): Call<FoodList>
}