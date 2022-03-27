package com.example.databinding.recyckerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.databinding.R
import com.example.databinding.databinding.ItemDatabindingBinding
import com.example.databinding.recyckerview.bean.DataBindingData

/**
 * create by xfwa
 * on 2022/3/26
 * good good study,day day up!
 * description:
 **/
class MyAdapter : RecyclerView.Adapter<MyAdapter.TestHolder>() {


    private val testData = ArrayList<DataBindingData>()

    init {

        for (i in 0..1000) {
            testData.add(DataBindingData(("第$i 条数据")))
        }
    }

    inner class TestHolder(var dataBinding: ItemDatabindingBinding) :
        RecyclerView.ViewHolder(dataBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestHolder {
        val dataBinding = DataBindingUtil.inflate<ItemDatabindingBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_databinding,
            parent,
            false
        )
        return TestHolder(dataBinding)
    }

    override fun onBindViewHolder(holder: TestHolder, position: Int) {
        holder.dataBinding.testContent = testData[position]
    }

    override fun getItemCount(): Int = testData.size
}