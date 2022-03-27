package com.example.paging3.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paging3.api.GithubServerApi
import com.example.paging3.bean.Item

/**
 * create by xfwa
 * on 2022/3/27
 * good good study,day day up!
 * description:
 **/
class RepoPagingSource(private val githubServerApi: GithubServerApi) : PagingSource<Int, Item>() {

    override fun getRefreshKey(state: PagingState<Int, Item>): Int? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
        return try {
            val key = params.key ?: 1
            val loadSize = params.loadSize
            val githubServerData = githubServerApi.getGithubServerData(key, loadSize)
            val item = githubServerData.items
            val prevKey = if (key > 1) key - 1 else null
            val nextKey = if (item.isNotEmpty()) key + 1 else null
            LoadResult.Page(item, prevKey, nextKey)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}