package com.example.recipeapp

sealed class Screens(val route:String) {
    data object RecipeScreen:Screens(route = "recipeScreen")
    data object DetailScreen:Screens(route = "detailScreen")
}