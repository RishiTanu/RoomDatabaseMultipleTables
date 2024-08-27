package com.example.roomdatabasemultipletables.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.roomdatabasemultipletables.entities.Director
import com.example.roomdatabasemultipletables.entities.School
import com.example.roomdatabasemultipletables.entities.Student
import com.example.roomdatabasemultipletables.entities.Subject
import com.example.roomdatabasemultipletables.entities.relations.SchoolAndDirector
import com.example.roomdatabasemultipletables.entities.relations.SchoolWithStudents
import com.example.roomdatabasemultipletables.entities.relations.StudentSubjectCrossRef
import com.example.roomdatabasemultipletables.entities.relations.StudentWithSubjects
import com.example.roomdatabasemultipletables.entities.relations.SubjectWithStudents


@Dao
interface SchoolDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Transaction
    @Query("SELECT * FROM SCHOOL WHERE schoolName=:school")
    suspend fun getSchoolAndDirectorWithSchoolName(school: String): List<SchoolAndDirector>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(crossRef:StudentSubjectCrossRef)

    @Transaction
    @Query("SELECT * FROM School WHERE schoolName=:schoolName")
    suspend fun getSchoolWithStudents(schoolName: String): List<SchoolWithStudents>


    @Transaction
    @Query("SELECT * FROM Subject WHERE subjectName=:subjectName")
    suspend fun getStudentsOfSubject(subjectName:String): List<SubjectWithStudents>

    @Transaction
    @Query("SELECT * FROM Student WHERE studentName=:studentName")
    suspend fun getSubjectsOfStudent(studentName:String): List<StudentWithSubjects>


}