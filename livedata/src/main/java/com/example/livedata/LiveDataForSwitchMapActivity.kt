package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.arch.core.util.Function
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations

class LiveDataForSwitchMapActivity : AppCompatActivity() {

    private val switchLiveData = MutableLiveData<Boolean>()
    private val liveData1 = MutableLiveData<String>()
    private val liveData2 = MutableLiveData<String>()
    private var switchMap = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data_for_switch_map)
        val tvContent = this.findViewById<TextView>(R.id.tv_test_content)
        val switchMapLiveData =
            Transformations.switchMap(switchLiveData, object : Function<Boolean, LiveData<String>> {
                override fun apply(input: Boolean): LiveData<String> {
                    if (input) {
                        return liveData1
                    }
                    return liveData2
                }
            })


        switchMapLiveData.observe(this) {
            tvContent.text = it
        }

    }

    fun changeClick(view: View) {
        liveData2.value = "false的值"
        liveData1.value = "true的值"
        switchLiveData.value = switchMap
        switchMap = !switchMap

    }
}