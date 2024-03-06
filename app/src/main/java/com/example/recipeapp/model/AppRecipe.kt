package com.example.recipeapp.model

import com.example.recipeapp.data.CatergoryList
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private val retrofit = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create()).build()

val recipeService = retrofit.create(AppRecipe::class.java)

interface AppRecipe {
    @GET("categories.php")
    suspend fun getRecipes():CatergoryList

}