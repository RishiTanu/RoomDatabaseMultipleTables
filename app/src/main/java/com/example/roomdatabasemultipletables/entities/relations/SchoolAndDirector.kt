package com.example.roomdatabasemultipletables.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.roomdatabasemultipletables.entities.Director
import com.example.roomdatabasemultipletables.entities.School

data class SchoolAndDirector(
    @Embedded val school:School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)