package com.example.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * create by xfwa
 * on 2022/3/25
 * good good study,day day up!
 * description:
 **/
class MyViewModel : ViewModel() {


    private var i = 0
    private val testNum = MutableLiveData<Int>()

    fun getTestNum(): MutableLiveData<Int> {
        return testNum
    }

    fun addOne() {
        i++
        testNum.value = i
    }

}