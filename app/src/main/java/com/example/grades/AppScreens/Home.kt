package com.example.grades.AppScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
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
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
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
fun CourseBox(courseData: CourseData)
{
    var showOptions by remember { mutableStateOf(false) }
    val showDialog = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .padding(top = 8.dp, start = 8.dp, end = 8.dp)
            .clip(RoundedCornerShape(5.dp))
            .pointerInput(Unit) {
                detectTapGestures(
                    onLongPress = {
                        showOptions = true
                    }
                )
            }
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

    if(showDialog.value)
    {
        var courseName by remember { mutableStateOf(courseData.name) }
        var courseCredits by remember { mutableStateOf(courseData.credits.toString()) }
        var courseGrade by remember { mutableStateOf(courseData.grade.toString()) }
        var semester by remember { mutableStateOf(courseData.sem.toString()) }
        var expanded by remember { mutableStateOf(false) }

        AlertDialog(
            onDismissRequest = { showDialog.value = false},
            containerColor = Color(0xff219ebc),
            title = { Text(text = "Edit Grade", color = Color(0xff023047)) },
            text = {
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(RoundedCornerShape(10.dp))
                ) {
                    Column (
                        modifier = Modifier
                            .wrapContentSize()
                            .background(Color(0xff023047)),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OutlinedTextField(
                            value = courseName,
                            label = { Text(text = "Course Name") },
                            onValueChange = { courseName = it },
                            singleLine = true,
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                textColor = Color.White,
                                focusedBorderColor = Color(0xff219ebc),
                                unfocusedBorderColor = Color(0xff219ebc)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        )

                        Row (
                            modifier = Modifier
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            OutlinedTextField(
                                value = courseCredits,
                                label = { Text(text = "Credits") },
                                onValueChange = { courseCredits = it },
                                singleLine = true,
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    textColor = Color.White,
                                    focusedBorderColor = Color(0xff219ebc),
                                    unfocusedBorderColor = Color(0xff219ebc)),
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(8.dp)
                            )

                            OutlinedTextField(
                                value = courseGrade,
                                label = { Text(text = "Grade") },
                                onValueChange = { courseGrade = it },
                                singleLine = true,
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    textColor = Color.White,
                                    focusedBorderColor = Color(0xff219ebc),
                                    unfocusedBorderColor = Color(0xff219ebc)),
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(8.dp)
                            )
                        }

                        Button(onClick = { expanded = true },
                            modifier = Modifier
                                .padding(bottom = 8.dp))
                        {
                            Text("Semester")
                            Icon(
                                Icons.Default.ArrowDropDown,
                                contentDescription = "Drop Down Arrow"
                            )
                        }

                        DropdownMenu(expanded = expanded,
                            onDismissRequest = {expanded = false})
                        {
                            DropdownMenuItem(
                                text = { Text("Semester 1") },
                                onClick = {
                                    semester = "1"
                                    expanded = false
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Semester 2") },
                                onClick = {
                                    semester = "2"
                                    expanded = false
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Semester 3") },
                                onClick = {
                                    semester = "3"
                                    expanded = false
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Semester 4") },
                                onClick = {
                                    semester = "4"
                                    expanded = false
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Semester 5") },
                                onClick = {
                                    semester = "5"
                                    expanded = false
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Semester 6") },
                                onClick = {
                                    semester = "6"
                                    expanded = false
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Semester 7") },
                                onClick = {
                                    semester = "7"
                                    expanded = false
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Semester 8") },
                                onClick = {
                                    semester = "8"
                                    expanded = false
                                }
                            )
                        }
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        if( courseName.isNotEmpty()
                            && courseCredits.toInt() > 0
                            && courseGrade.toInt() > 0
                            && semester.isNotEmpty() )
                        {
                            courseData.name = courseName
                            courseData.credits = courseCredits.toInt()
                            courseData.grade = courseGrade.toInt()
                            courseData.sem = semester.toInt()

                            courseName = ""
                            courseCredits = ""
                            courseGrade = ""
                            semester = ""
                            showDialog.value = false
                        }
                    }
                ) {
                    Text(text = "Add")
                }
            },
            dismissButton = {
                Button(
                    onClick = { showDialog.value = false }
                ) {
                    Text(text = "Cancel")
                }
            }
        )
    }

    if(showOptions)
    {
        AlertDialog(
            onDismissRequest = { showOptions = false},
            containerColor = Color(0xff219ebc),
            title = { Text(text = "Choose", color = Color(0xff023047)) },
            text = { },
            confirmButton = {
                Button(
                    onClick = {
                        showDialog.value = true
                        showOptions = false
                    }
                ) {
                    Text(text = "Edit")
                }
            },
            dismissButton = {
                Button(
                    onClick = { showOptions = false }
                ) {
                    Text(text = "Delete")
                }
            }
        )
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

