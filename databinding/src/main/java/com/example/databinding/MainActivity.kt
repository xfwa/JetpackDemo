package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val user = User("张三")

    private var flag = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //dataBinding的形式SetContentView
        val dataBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        dataBinding.userTest = user
        dataBinding.lifecycleOwner = this

        dataBinding.btnChangeName.setOnClickListener {
            if (flag) {
                user._name.set("李四")
            } else {
                user._name.set("张三")
            }
            flag = !flag
        }

    }
}