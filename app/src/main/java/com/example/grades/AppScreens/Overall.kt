package com.example.grades.AppScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Overall()
{
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(800.dp)
            .background(Color.White)
    ) {
         Text(
             text = "Overall Screen for displaying the overall grades",
             color = Color.Black
         )
    }
}