package com.example.paging3.api

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.paging3.bean.Item
import com.example.paging3.paging.RepoPagingSource
import kotlinx.coroutines.flow.Flow

/**
 * create by xfwa
 * on 2022/3/27
 * good good study,day day up!
 * description:
 **/
object Repository {

    private const val PAGE_SIZE = 50

    private val githubService = GithubServerApi.create()

    fun getPagingData(): Flow<PagingData<Item>> {
        return Pager(
            config = PagingConfig(PAGE_SIZE),
            pagingSourceFactory = { RepoPagingSource(githubService) }).flow
    }


}