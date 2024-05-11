package com.example.grades.AppScreens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.grades.Data.Course
import com.example.grades.MainViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Overall(
    viewModel: MainViewModel
)
{
    val semesters = listOf("Semester 1", "Semester 2", "Semester 3", "Semester 4", "Semester 5", "Semester 6", "Semester 7", "Semester 8").groupBy { it[0] }

    val courses = viewModel.getAllCourses.collectAsState(initial = listOf()).value

    val sem1Courses = courses.filter { it.sem == 1 }
    val sem2Courses = courses.filter { it.sem == 2 }
    val sem3Courses = courses.filter { it.sem == 3 }
    val sem4Courses = courses.filter { it.sem == 4 }
    val sem5Courses = courses.filter { it.sem == 5 }
    val sem6Courses = courses.filter { it.sem == 6 }
    val sem7Courses = courses.filter { it.sem == 7 }
    val sem8Courses = courses.filter { it.sem == 8 }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        stickyHeader {
            Card(
                modifier = Modifier
                    .padding(8.dp),
                backgroundColor = Color(0xff023047)
            ) {
                Text(
                    text = "Semester 1",
                    fontSize = 24.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(8.dp)
                )
            }

            LazyRow {
                items(sem1Courses){
                        course ->
                    CourseCard(course = course)
                }
            }
        }

        stickyHeader {
            Card(
                modifier = Modifier
                    .padding(8.dp),
                backgroundColor = Color(0xff023047)
            ) {
                Text(
                    text = "Semester 2",
                    fontSize = 24.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(8.dp)
                )
            }

            LazyRow {
                items(sem2Courses){
                        course ->
                    CourseCard(course = course)
                }
            }
        }

        stickyHeader {
            Card(
                modifier = Modifier
                    .padding(8.dp),
                backgroundColor = Color(0xff023047)
            ) {
                Text(
                    text = "Semester 3",
                    fontSize = 24.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(8.dp)
                )
            }

            LazyRow {
                items(sem3Courses){
                        course ->
                    CourseCard(course = course)
                }
            }
        }

        stickyHeader {
            Card(
                modifier = Modifier
                    .padding(8.dp),
                backgroundColor = Color(0xff023047)
            ) {
                Text(
                    text = "Semester 4",
                    fontSize = 24.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(8.dp)
                )
            }

            LazyRow {
                items(sem4Courses){
                        course ->
                    CourseCard(course = course)
                }
            }
        }

        stickyHeader {
            Card(
                modifier = Modifier
                    .padding(8.dp),
                backgroundColor = Color(0xff023047)
            ) {
                Text(
                    text = "Semester 5",
                    fontSize = 24.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(8.dp)
                )
            }

            LazyRow {
                items(sem5Courses){
                        course ->
                    CourseCard(course = course)
                }
            }
        }

        stickyHeader {
            Card(
                modifier = Modifier
                    .padding(8.dp),
                backgroundColor = Color(0xff023047)
            ) {
                Text(
                    text = "Semester 6",
                    fontSize = 24.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(8.dp)
                )
            }

            LazyRow {
                items(sem6Courses){
                        course ->
                    CourseCard(course = course)
                }
            }
        }

        stickyHeader {
            Card(
                modifier = Modifier
                    .padding(8.dp),
                backgroundColor = Color(0xff023047)
            ) {
                Text(
                    text = "Semester 7",
                    fontSize = 24.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(8.dp)
                )
            }

            LazyRow {
                items(sem7Courses){
                        course ->
                    CourseCard(course = course)
                }
            }
        }

        stickyHeader {
            Card(
                modifier = Modifier
                    .padding(8.dp),
                backgroundColor = Color(0xff023047)
            ) {
                Text(
                    text = "Semester 8",
                    fontSize = 24.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(8.dp)
                )
            }

            LazyRow {
                items(sem8Courses){
                        course ->
                    CourseCard(course = course)
                }
            }
        }
    }
}

@Composable
fun CourseCard(course : Course)
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
            Row {
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
                            text =  course.name,
                            color = Color.Black
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
                            .clip(RoundedCornerShape(10.dp))
                    ) {
                        Text(
                            text = "Grade : " + course.grade.toString(),
                            color = Color.Black
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(5.dp))

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
                        text = "Credits : " + course.credits.toString(),
                        color = Color.Black
                    )
                }
            }
        }
    }

    if( course.sem == 8 )
    {
        Spacer(modifier = Modifier.height(100.dp))
    }
}