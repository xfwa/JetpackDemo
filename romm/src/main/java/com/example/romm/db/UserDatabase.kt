package com.example.romm.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.romm.dao.StudentDao
import com.example.romm.dao.UserDao
import com.example.romm.entity.StudentEntity
import com.example.romm.entity.UserEntity

/**
 * create by xfwa
 * on 2022/3/26
 * good good study,day day up!
 * description:
 **/
@Database(entities = [UserEntity::class,StudentEntity::class], version = 2)
abstract class UserDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    abstract fun getStudentDao(): StudentDao

    companion object {

        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    """
                                            create table student (
                                           id integer primary key autoincrement not null,
                                           studentName text not null,
                                           studentNo text not null
                                            )
                """.trimIndent()
                )
            }
        }


        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getInstance(context: Context): UserDatabase {

            val tmpInstance = INSTANCE
            if (tmpInstance != null) {
                return tmpInstance
            }

            synchronized(this) {
                val instance =
                    Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "testDb"
                    )
                        .addMigrations(MIGRATION_1_2)
                        .build()
                INSTANCE = instance
                return instance
            }
        }


    }

}