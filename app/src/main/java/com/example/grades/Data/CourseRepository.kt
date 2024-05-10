package com.example.grades.Data

import kotlinx.coroutines.flow.Flow

class CourseRepository (private val courseDa0 : CourseDao)
{
    suspend fun addCourse(course : Course ) = courseDa0.addCourse(course)

    suspend fun deleteCourse(course : Course) = courseDa0.deleteCourse(course)

    suspend fun updateCourse(course : Course) = courseDa0.updateCourse(course)

    fun getAllCourses() : Flow<List<Course>> = courseDa0.getAllCourses()
}