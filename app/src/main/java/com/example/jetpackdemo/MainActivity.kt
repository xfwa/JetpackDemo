package com.example.jetpackdemo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

private const val TAG = "xfwa"

internal class MyLifeCycle(context: Context) {
    fun resume() {
        // TODO: 做一些其他的操作
        Log.d(TAG, "resume: ")
    }

    fun destroy() {
        Log.d(TAG, "destroy: ")
    }

}


class MainActivity : AppCompatActivity() {

    private val myLifeCycle by lazy {
        MyLifeCycle(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        lifecycle.addObserver(MyLifecycleTest())
//        lifecycle.addObserver(MyDefaultLifecycleObserver())
    }



}