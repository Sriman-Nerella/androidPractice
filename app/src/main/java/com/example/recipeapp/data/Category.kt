package com.example.recipeapp.data

data class Category(
    val idCategory:String,
    val strCategory: String,
    val strCategoryThumb:String,
    val strCategoryDescription: String
)

data class CatergoryList(val categories:List<Category>)
