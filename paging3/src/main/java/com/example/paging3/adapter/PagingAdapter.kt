package com.example.paging3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.paging3.R
import com.example.paging3.bean.Item

/**
 * create by xfwa
 * on 2022/3/27
 * good good study,day day up!
 * description:
 **/
class PagingAdapter : PagingDataAdapter<Item, PagingAdapter.PagingHolder>(COMPARATOR) {

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem == newItem
            }
        }
    }

    class PagingHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name_text)
        val description: TextView = itemView.findViewById(R.id.description_text)
        val starCount: TextView = itemView.findViewById(R.id.star_count_text)
    }

    override fun onBindViewHolder(holder: PagingHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.name.text = it.name
            holder.description.text = it.description
            holder.starCount.text = it.stargazers_count.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagingHolder =
        PagingHolder(LayoutInflater.from(parent.context).inflate(R.layout.repo_item, parent, false))
}