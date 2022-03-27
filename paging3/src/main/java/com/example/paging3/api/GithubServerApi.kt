package com.example.paging3.api

import com.example.paging3.bean.RepoResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * create by xfwa
 * on 2022/3/27
 * good good study,day day up!
 * description:
 **/
interface GithubServerApi {

    @GET("search/repositories?sort=stars&q=Android")
   suspend fun getGithubServerData(@Query("page") page: Int, @Query("per_page") perPage: Int): RepoResponse


    companion object {
        private const val BASE_URL = "https://api.github.com/"

        fun create(): GithubServerApi {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubServerApi::class.java)
        }

    }

}