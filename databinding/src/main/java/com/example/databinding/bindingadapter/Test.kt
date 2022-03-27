package com.example.databinding.bindingadapter

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * create by xfwa
 * on 2022/3/26
 * good good study,day day up!
 * description:
 **/
class Test {

    companion object {
        @BindingAdapter(value = ["imageUrl", "placeHolder"], requireAll = true)
        @JvmStatic
        fun test(imageView: ImageView, imageUrl: String, placeHolder: Drawable) {
            Glide.with(imageView.context).load(imageUrl)
                .placeholder(placeHolder).into(imageView)
        }
    }


}