package com.example.viewmodel.viewModelAndFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//理解成系统帮我封装了一层findViewById,但是实际上还是使用findViewById去绑定我们的控件
class BlankViewModel : ViewModel() {

    private val testLiveData = MutableLiveData<Int>()
    private var i = 0

    fun getLiveData(): MutableLiveData<Int> {
        return testLiveData
    }

    fun addOne() {
        i++
        testLiveData.value = i
    }

}