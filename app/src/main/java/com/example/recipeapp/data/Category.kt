package com.example.recipeapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val idCategory:String,
    val strCategory: String,
    val strCategoryThumb:String,
    val strCategoryDescription: String
):Parcelable

data class CatergoryList(val categories:List<Category>)
