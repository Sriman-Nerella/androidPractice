package com.example.recipeapp

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.data.Category
import com.example.recipeapp.model.recipeService
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {

    var categoryState by mutableStateOf(RecipeState())
        private set

    init {
        fetchCategories()
    }
    private fun fetchCategories(){
        viewModelScope.launch {
            try {
                val recipes = recipeService.getRecipes()
                categoryState = categoryState.copy(
                    loading = false,
                    list = recipes.categories,
                    error = null
                )
            }catch (e:Exception){
                e.message?.let { Log.e("Big error", it) }
                categoryState = categoryState.copy(
                    loading = false,
                    list = emptyList(),
                    error = e.message
                )
            }
        }
    }

    data class RecipeState(
        val loading:Boolean = true,
        val list: List<Category> = emptyList(),
        val error:String? = null
    )
}