package com.example.roomdatabasemultipletables.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.roomdatabasemultipletables.entities.School
import com.example.roomdatabasemultipletables.entities.Student


data class SchoolWithStudents(

    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students: List<Student>
)
