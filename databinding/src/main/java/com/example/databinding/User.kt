package com.example.databinding

import androidx.databinding.ObservableField


/**
 * create by xfwa
 * on 2022/3/26
 * good good study,day day up!
 * description:
 **/
class User(var name: String) {
    val _name = ObservableField<String>()

    init {
        _name.set(name)
    }

}