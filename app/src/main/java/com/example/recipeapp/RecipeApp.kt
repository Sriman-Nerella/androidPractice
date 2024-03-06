package com.example.recipeapp

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(
    navHostController: NavHostController
){
    val viewModel:MainViewModel = viewModel()
    val viewState = viewModel.categoryState
    NavHost(navController = navHostController, startDestination = Screens.RecipeScreen.route){
        composable(route = Screens.RecipeScreen.route){
            RecipeScreen(viewstate = viewState)
        }
        composable(route = Screens.DetailScreen.route){

        }
    }
}