package com.example.databinding.recyckerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databinding.R
import com.example.databinding.databinding.ActivityBindingAdapterBinding
import com.example.databinding.databinding.ActivityRecyclerViewBinding
import com.example.databinding.recyckerview.adapter.MyAdapter

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBinding = DataBindingUtil.setContentView<ActivityRecyclerViewBinding>(
            this,
            R.layout.activity_recycler_view
        )

        dataBinding.rvTest.adapter = MyAdapter()

    }
}