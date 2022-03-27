package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations

class LiveDataForMapActivity : AppCompatActivity() {

    private val testLiveData = MutableLiveData<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data_for_map)
        val tvContent = findViewById<TextView>(R.id.tv_test_content);
        val liveMap = Transformations.map(testLiveData) { input -> "livedata发送过来的数据是->$input" }
        liveMap.observe(this) {
            tvContent.text = it
        }
    }

    fun mapChangeClick(view: View) {
        testLiveData.value = 1000
    }
}