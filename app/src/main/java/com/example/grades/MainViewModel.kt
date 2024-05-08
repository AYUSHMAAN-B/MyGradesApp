package com.example.grades

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.grades.Data.CourseData

class MainViewModel : ViewModel()
{
    private val _currentScreen : MutableState<Screens> = mutableStateOf(Screens.Home)
    val currentScreen : MutableState<Screens> = _currentScreen

    fun setScreen(screen : Screens)
    {
        _currentScreen.value = screen
    }
}

