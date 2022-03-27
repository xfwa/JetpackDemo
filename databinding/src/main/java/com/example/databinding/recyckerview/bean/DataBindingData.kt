package com.example.databinding.recyckerview.bean

import androidx.databinding.ObservableField

/**
 * create by xfwa
 * on 2022/3/26
 * good good study,day day up!
 * description:
 **/
class DataBindingData(var content: String) {

    val _content = ObservableField<String>()

    init {
        _content.set(content)
    }


}