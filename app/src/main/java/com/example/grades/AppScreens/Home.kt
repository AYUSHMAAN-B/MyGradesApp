package com.example.grades.AppScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.grades.Data.CourseData
import com.example.grades.MainViewModel

@Composable
fun Home(
    courses : List<CourseData>
) {
    val scrollState = rememberScrollState()
    val viewModel : MainViewModel = viewModel()

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState)
    ) {
        courses.forEach {
            CourseBox(it)
        }

        if( courses.isNotEmpty() && viewModel.currentScreen.value.title != "HOME" )
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
                    SPI_CPI(courses, 6)
                }
            }
        }

        Spacer(modifier = Modifier.height(300.dp))
    }
}

@Composable
fun CourseBox(courseData : CourseData)
{
    Box(
        modifier = Modifier
            .padding(top = 8.dp, start = 8.dp, end = 8.dp)
            .clip(RoundedCornerShape(5.dp))
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xff023047))
                .padding(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(RoundedCornerShape(5.dp))
            ) {
                Box(
                    modifier = Modifier
                        .wrapContentSize()
                        .background(Color(0xff8ecae6))
                        .padding(8.dp)
                        .clip(RoundedCornerShape(10.dp))
                ) {
                    Text(
                        text =  courseData.name,
                        color = Color.Black
                    )
                }
            }

            Spacer(modifier = Modifier.height(5.dp))

            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(RoundedCornerShape(5.dp))
                ) {
                    Box(
                        modifier = Modifier
                            .wrapContentSize()
                            .background(Color(0xff8ecae6))
                            .padding(8.dp)
                            .clip(RoundedCornerShape(10.dp))
                    ) {
                        Text(
                            text = "Credits : " + courseData.credits.toString(),
                            color = Color.Black
                        )
                    }
                }

                Spacer(modifier = Modifier.width(2.dp))

                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(RoundedCornerShape(5.dp))
                ) {
                    Box(
                        modifier = Modifier
                            .wrapContentSize()
                            .background(Color(0xff8ecae6))
                            .padding(8.dp)
                            .clip(RoundedCornerShape(10.dp))
                    ) {
                        Text(
                            text = "Grade : " + courseData.grade.toString(),
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SPI_CPI(courses : List<CourseData>, sem : Int )
{
    var totalCredits = 0
    var totalGrades = 0

    courses.forEach {
        if (it.sem == sem)
        {
            totalCredits += it.credits
            totalGrades += it.credits * it.grade
        }
    }

    val spi = totalGrades.toFloat() / totalCredits
    val cpi = totalGrades.toFloat() / totalCredits

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .padding(2.dp)
                .clip(RoundedCornerShape(5.dp))
        ) {
            Box(
                modifier = Modifier
                    .wrapContentSize()
                    .background(Color(0xff8ecae6))
                    .padding(8.dp)
            ) {
                Text(
                    text = "SPI : $spi",
                    color = Color.Black,
                    fontSize = 20.sp
                )
            }
        }

        Box(
            modifier = Modifier
                .padding(2.dp)
                .clip(RoundedCornerShape(5.dp))
        ) {
            Box(
                modifier = Modifier
                    .wrapContentSize()
                    .background(Color(0xff8ecae6))
                    .padding(8.dp)
            ) {
                Text(
                    text = "CPI : $cpi",
                    color = Color.Black,
                    fontSize = 20.sp
                )
            }
        }
    }
}

