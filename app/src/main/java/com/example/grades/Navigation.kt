package com.example.grades

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.grades.AppScreens.Home
import com.example.grades.AppScreens.Overall
import com.example.grades.AppScreens.Sem1
import com.example.grades.AppScreens.Sem2
import com.example.grades.AppScreens.Sem3
import com.example.grades.AppScreens.Sem4
import com.example.grades.AppScreens.Sem5
import com.example.grades.AppScreens.Sem6
import com.example.grades.AppScreens.Sem7
import com.example.grades.AppScreens.Sem8

@Composable
fun Navigation(
    navController : NavController,
    padding : PaddingValues,
    viewModel : MainViewModel
)
{
    NavHost(
        navController = navController as NavHostController,
        startDestination = "sem1"
    ) {
        composable("home") {
            Home(viewModel)
        }
        composable("overall") {
            Overall()
        }
        composable("sem1") {
            Sem1(viewModel)
        }
        composable("sem2") {
            Sem2(viewModel)
        }
        composable("sem3") {
            Sem3(viewModel)
        }
        composable("sem4") {
            Sem4(viewModel)
        }
        composable("sem5") {
            Sem5(viewModel)
        }
        composable("sem6") {
            Sem6(viewModel)
        }
        composable("sem7") {
            Sem7(viewModel)
        }
        composable("sem8") {
            Sem8(viewModel)
        }
    }
}