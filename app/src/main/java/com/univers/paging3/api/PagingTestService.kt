package com.univers.paging3.api

import com.univers.paging3.model.RepoResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface PagingTestService {

    @GET("search/repositories?sort=starts&q=android")
    suspend fun searchRepos(@Query("page") page: Int, @Query("per_page") perPage: Int): RepoResponse

    companion object {
        private const val BASE_URL = "https://api.github.com/"

        fun create(): PagingTestService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PagingTestService::class.java)
        }
    }
}