package com.example.viewmodel.viewModelAndFragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel.R
import com.example.viewmodel.databinding.ActivityFragmentMsgBinding

class FragmentMsgActivity : AppCompatActivity() {

    private val viewModel: BlankViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //驼峰命名
        val viewBinding = ActivityFragmentMsgBinding.inflate(LayoutInflater.from(this), null, false)
        setContentView(viewBinding.root)
        viewBinding.btnAddOne.setOnClickListener {
            viewModel.addOne()
        }
    }


}