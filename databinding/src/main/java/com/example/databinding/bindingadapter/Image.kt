package com.example.databinding.bindingadapter

import android.view.View
import androidx.databinding.ObservableField

/**
 * create by xfwa
 * on 2022/3/26
 * good good study,day day up!
 * description:
 **/
class Image(var image: String) {

    val _image = ObservableField<String>()

    init {
        _image.set(image)
    }

    fun changeImageClick(view:View){
        _image.set("https://img1.baidu.com/it/u=2547197116,1313328062&fm=253&fmt=auto&app=120&f=JPEG?w=1200&h=675")
    }

}