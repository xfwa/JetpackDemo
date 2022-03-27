package com.example.databinding.bindingadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databinding.R
import com.example.databinding.databinding.ActivityBindingAdapterBinding

class BindingAdapterActivity : AppCompatActivity() {

   private  val myImage =
        Image("https://img1.baidu.com/it/u=4243507800,749775518&fm=253&fmt=auto&app=120&f=JPEG?w=1200&h=675")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBinding = DataBindingUtil.setContentView<ActivityBindingAdapterBinding>(
            this,
            R.layout.activity_binding_adapter
        )
        dataBinding.image = myImage
//        dataBinding.btnChangeImage.setOnClickListener {
//            myImage._image.set()
//        }
    }
}