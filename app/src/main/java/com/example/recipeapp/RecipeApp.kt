package com.example.recipeapp

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.recipeapp.data.Category

@Composable
fun RecipeApp(
    navHostController: NavHostController
){
    val viewModel:MainViewModel = viewModel()
    val viewState = viewModel.categoryState
    NavHost(navController = navHostController, startDestination = Screens.RecipeScreen.route){
        composable(route = Screens.RecipeScreen.route,
            enterTransition = { slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Left, tween(220, delayMillis = 90)) },
            exitTransition = { slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.Right, tween(220,90)) }
            ){
            RecipeScreen(viewstate = viewState, navigateToDetail = {
                navHostController.currentBackStackEntry?.savedStateHandle?.set("cat",it)
                navHostController.navigate(Screens.DetailScreen.route)
            })
        }
        composable(route = Screens.DetailScreen.route,
            enterTransition = { slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Left, tween(220, delayMillis = 90)) },
            exitTransition = { slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.Right, tween(220,90)) }
            ){
            val category = navHostController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat")?: Category("","","","")
            DetailScreen(catergory = category)

        }
    }
}