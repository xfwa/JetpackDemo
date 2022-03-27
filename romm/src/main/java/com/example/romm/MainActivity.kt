package com.example.romm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.example.romm.databinding.ActivityMainBinding
import com.example.romm.db.UserDatabase
import com.example.romm.entity.StudentEntity
import com.example.romm.entity.UpdateNameBean
import com.example.romm.entity.UserEntity
import kotlin.concurrent.thread

private const val TAG = "xfwa"

class MainActivity : AppCompatActivity() {

    private val userDao by lazy {
        UserDatabase.getInstance(this).getUserDao()
    }

    private val studentDao by lazy {
        UserDatabase.getInstance(this).getStudentDao()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewBinding = ActivityMainBinding.inflate(LayoutInflater.from(this), null, false)
        setContentView(viewBinding.root)
        //添加数据
        viewBinding.btnAdd.setOnClickListener {
            Thread {
                userDao.addUser(UserEntity(name = "张三", age = 28))
            }.start()
        }

        //查询数据
        viewBinding.btnQueryAll.setOnClickListener {
            Thread {
                val userList = userDao.queryUser()
                userList.forEach {
                    Log.d(TAG, "查询的数据库数据是: $it")
                }
            }.start()
        }

        //修改数据
        viewBinding.btnUpdate.setOnClickListener {
            Thread {
                userDao.updateUser(UserEntity(3, "李四", 18))
            }.start()
        }

        //删除数据
        viewBinding.btnDelete.setOnClickListener {
            Thread {
                userDao.deleteUser(UserEntity(2, "张三", 28))
            }.start()
        }

        //student表增加数据
        viewBinding.btnAddStudentData.setOnClickListener {
            Thread {
                studentDao.insertStudentData(
                    StudentEntity(
                        studentName = "王五",
                        studentNo = "20220115"
                    )
                )
            }.start()
        }

        viewBinding.btnQueryStudentAllData.setOnClickListener {
            Thread {
                studentDao.queryAllStudentData().forEach {
                    Log.d(TAG, "学生表的数据: $it")
                }
            }.start()
        }

        //只修改用户名字
        viewBinding.btnUpdateUsername.setOnClickListener {
            Thread {
                userDao.updateUser2(UpdateNameBean(4, "张三"))
            }.start()
        }

    }
}