package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlin.concurrent.thread

private const val TAG = "xfwa"

class MainActivity : AppCompatActivity() {

    //定义了一个livedata
    private val testLiveData = MutableLiveData<String>()
    private val testHandler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tvTestContent: TextView = findViewById(R.id.tv_test_content)

        testLiveData.observe(this) {
            Log.d(TAG, "接收到数据: $it")
            tvTestContent.text = it
        }

    }

    fun sendMsg(view: View) {
        Log.d(TAG, "发送数据 ")
        //发送数据
        testLiveData.value = "这是liveData传递过来的数据"
    }

    fun delaySendMsg(view: View) {
        testHandler.postDelayed({
            testLiveData.value = "延迟发送数据"
        }, 3000)
    }

    fun postValueSendMsg(view: View) {
        Thread {
            testLiveData.postValue("postValue")
        }.start()

    }


}