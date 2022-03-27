package com.example.paging3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.example.paging3.api.Repository
import com.example.paging3.bean.Item
import kotlinx.coroutines.flow.Flow

/**
 * create by xfwa
 * on 2022/3/27
 * good good study,day day up!
 * description:
 **/
class GithubServiceViewModel : ViewModel() {

    fun getGithubServiceData(): Flow<PagingData<Item>> {
        return Repository.getPagingData()
    }

}