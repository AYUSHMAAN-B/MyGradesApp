package com.example.grades

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.grades.Data.Course
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App()
{
    val navController : NavController = rememberNavController()
    val viewModel : MainViewModel = viewModel()
    val currentScreen = remember { mutableStateOf(viewModel.currentScreen.value) }
    val title = remember { mutableStateOf(currentScreen.value.title) }
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    var expanded by remember { mutableStateOf(false) }

    var courseName by remember { mutableStateOf("") }
    var courseCredits by remember { mutableStateOf("") }
    var courseGrade by remember { mutableStateOf("") }
    var semester by remember { mutableStateOf("") }

    var semoption by remember { mutableStateOf("Semester") }

    val courses = viewModel.getAllCourses.collectAsState(initial = listOf()).value

    val showDialog = remember { mutableStateOf(false) }

    if(showDialog.value)
    {
        AlertDialog(
            onDismissRequest = { showDialog.value = false},
            containerColor = Color(0xff219ebc),
            title = { Text(text = "Add Grade", color = Color(0xff023047)) },
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
                               Text(semoption)
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
                                       semoption = "Semester 1"
                                       expanded = false
                                   }
                               )
                               DropdownMenuItem(
                                   text = { Text("Semester 2") },
                                   onClick = {
                                       semester = "2"
                                       semoption = "Semester 2"
                                       expanded = false
                                   }
                               )
                               DropdownMenuItem(
                                   text = { Text("Semester 3") },
                                   onClick = {
                                       semester = "3"
                                       semoption = "Semester 3"
                                       expanded = false
                                   }
                               )
                               DropdownMenuItem(
                                   text = { Text("Semester 4") },
                                   onClick = {
                                       semester = "4"
                                       semoption = "Semester 4"
                                       expanded = false
                                   }
                               )
                               DropdownMenuItem(
                                   text = { Text("Semester 5") },
                                   onClick = {
                                       semester = "5"
                                       semoption = "Semester 5"
                                       expanded = false
                                   }
                               )
                               DropdownMenuItem(
                                   text = { Text("Semester 6") },
                                   onClick = {
                                       semester = "6"
                                       semoption = "Semester 6"
                                       expanded = false
                                   }
                               )
                               DropdownMenuItem(
                                   text = { Text("Semester 7") },
                                   onClick = {
                                       semester = "7"
                                       semoption = "Semester 7"
                                       expanded = false
                                   }
                               )
                               DropdownMenuItem(
                                   text = { Text("Semester 8") },
                                   onClick = {
                                       semester = "8"
                                       semoption = "Semester 8"
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
                            viewModel.addCourse(
                                Course(
                                    id = courses.size + 1,
                                    name = courseName,
                                    credits = courseCredits.toInt(),
                                    grade = courseGrade.toInt(),
                                    sem = semester.toInt())
                            )

                            courseName = ""
                            courseCredits = ""
                            courseGrade = ""
                            semester = ""
                            showDialog.value = false
                            semoption = "Semester"
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

    Scaffold(
        topBar = {
             TopAppBar(
                 title = { Text(text = title.value, color = Color.White) },
                 navigationIcon = {
                     Icon(
                         painter = painterResource(id = R.drawable.ic_icon),
                         contentDescription = null,
                         tint = Color.White,
                         modifier = Modifier
                             .padding(8.dp)
                             .clickable { scope.launch {
                                scaffoldState.drawerState.open()
                                }
                             }
                     )
                 },
                 colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xff023047))
             ) },
        drawerContent = {
                Column {
                    Card (
                        modifier = Modifier
                            .padding(8.dp),
                        backgroundColor = Color(0xff023047)
                    ) {
                        Text(text = "Semesters",
                            fontSize = 32.sp,
                            color = Color.White,
                            modifier = Modifier
                                .padding(8.dp))
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    screensInSemester.forEach {screen ->
                        Row (modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween)
                        {

                            Text(text = screen.title,
                                color = Color(0xff023047))

                            Icon(imageVector = Icons.Default.KeyboardArrowRight,
                                contentDescription = null,
                                modifier = Modifier
                                    .clickable {
                                        currentScreen.value = screen
                                        title.value = screen.title
                                        viewModel.setScreen(screen)
                                        scope.launch {
                                            scaffoldState.drawerState.close()
                                        }
                                        navController.navigate(screen.route)
                                    })
                        }

                        Divider(color = Color.Black)
                    }
                }
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xff219ebc))
            ) {
                BottomNavigation(
                    modifier = Modifier
                        .wrapContentSize(),
                    backgroundColor = Color(0xff023047)
                ) {
                    screensInBottom.forEach { screen ->
                        BottomNavigationItem(
                            icon = {
                                Icon(
                                    painter = painterResource(screen.icon),
                                    contentDescription = null
                                )
                            },
                            label = { Text(screen.title, color = Color.White) },
                            selected = currentScreen.value == screen,
                            onClick = {
                                currentScreen.value = screen
                                title.value = screen.title
                                viewModel.setScreen(screen)
                                navController.navigate(screen.route)
                            },
                            selectedContentColor = Color(0xff8ecae6),
                            unselectedContentColor = Color.White
                        )
                    }
                }
            }
        },
        scaffoldState = scaffoldState,
        content = {
             Navigation(
                 navController = navController,
                 padding = it,
                 viewModel = viewModel)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showDialog.value = true },
                backgroundColor = Color(0xff023047),
                contentColor = Color.White
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_add), contentDescription = "Add Grade")
            }
        }
    )
}

val screensInBottom = listOf(
    Screens.Home,
    Screens.Overall
)

val screensInSemester = listOf(
    Screens.Sem1,
    Screens.Sem2,
    Screens.Sem3,
    Screens.Sem4,
    Screens.Sem5,
    Screens.Sem6,
    Screens.Sem7,
    Screens.Sem8
)