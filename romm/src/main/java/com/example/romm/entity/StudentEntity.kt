package com.example.romm.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * create by xfwa
 * on 2022/3/26
 * good good study,day day up!
 * description:
 **/
@Entity(tableName = "student")
data class StudentEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "studentName")
    var studentName: String,
    @ColumnInfo(name = "studentNo")
    var studentNo: String
)