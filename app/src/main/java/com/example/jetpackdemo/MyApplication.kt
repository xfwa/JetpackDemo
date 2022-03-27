package com.example.jetpackdemo

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner

/**
 * create by xfwa
 * on 2022/3/25
 * good good study,day day up!
 * description:
 **/
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
//        ProcessLifecycleOwner.get().lifecycle.addObserver(MyLifecycleTest())
        ProcessLifecycleOwner.get().lifecycle.addObserver(MyDefaultLifecycleObserver())
    }

}