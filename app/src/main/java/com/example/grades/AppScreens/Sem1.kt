package com.example.grades.AppScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.grades.Data.CourseData

@Composable
fun Sem1( courses : List<CourseData> )
{
    val scrollState = rememberScrollState()

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState)
    ) {

        courses.forEach {
            if( it.sem == 1 )
                CourseBox(it)
        }

        if( courses.isNotEmpty() )
        {
            Spacer(modifier = Modifier.height(15.dp))

            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xff023047))
            ) {
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(Color(0xff023047))
                ) {
                    SPI_CPI(courses, 1)
                }
            }
        }

        Spacer(modifier = Modifier.height(300.dp))
    }
}
