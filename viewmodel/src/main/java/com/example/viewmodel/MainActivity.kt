package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private val myViewModel by lazy {
        ViewModelProvider(this).get(MyViewModel::class.java)
    }
    private lateinit var tvTest: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvTest = this.findViewById(R.id.tv_test)
        myViewModel.getTestNum().observe(this) {
            tvTest.text = it.toString()
        }
    }

    fun addOneClick(view: View) {
        myViewModel.addOne()
    }
}