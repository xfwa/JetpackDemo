package com.example.romm.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.romm.entity.StudentEntity

/**
 * create by xfwa
 * on 2022/3/26
 * good good study,day day up!
 * description:
 **/
@Dao
interface StudentDao {

    @Insert
    fun insertStudentData(vararg studentEntity: StudentEntity)

    @Query("select * from student")
    fun queryAllStudentData(): List<StudentEntity>

}