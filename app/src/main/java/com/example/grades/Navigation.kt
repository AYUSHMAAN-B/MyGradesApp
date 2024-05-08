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
import com.example.grades.Data.CourseData

@Composable
fun Navigation(
    navController : NavController,
    padding : PaddingValues,
    courses : List<CourseData>,
    viewModel : MainViewModel
)
{
    NavHost(
        navController = navController as NavHostController,
        startDestination = "sem1"
    ) {
        composable("home") {
            Home(courses, viewModel)
        }
        composable("overall") {
            Overall()
        }
        composable("sem1") {
            Sem1(courses, viewModel)
        }
        composable("sem2") {
            Sem2(courses, viewModel)
        }
        composable("sem3") {
            Sem3(courses, viewModel)
        }
        composable("sem4") {
            Sem4(courses, viewModel)
        }
        composable("sem5") {
            Sem5(courses, viewModel)
        }
        composable("sem6") {
            Sem6(courses, viewModel)
        }
        composable("sem7") {
            Sem7(courses, viewModel)
        }
        composable("sem8") {
            Sem8(courses, viewModel)
        }
    }
}