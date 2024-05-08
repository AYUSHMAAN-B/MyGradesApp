package com.example.grades.Data

data class CourseData (
    val id : Int,
    val name : String,
    val credits : Int,
    val grade : Int,
    val sem : Int,
    val isEditing : Boolean
)