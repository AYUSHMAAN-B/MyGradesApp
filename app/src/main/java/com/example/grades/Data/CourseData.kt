package com.example.grades.Data

data class CourseData (
    val id : Int,
    var name : String,
    var credits : Int,
    var grade : Int,
    var sem : Int,
    var isEditing : Boolean
)