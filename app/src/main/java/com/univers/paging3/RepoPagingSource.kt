package com.univers.paging3

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.univers.paging3.api.PagingTestService
import com.univers.paging3.model.Repo

class RepoPagingSource(private val testService: PagingTestService) : PagingSource<Int, Repo>() {
    override fun getRefreshKey(state: PagingState<Int, Repo>): Int? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Repo> {
        return try {
            val pageSize = params.loadSize
            val page = params.key ?: 1
            val repoResponse = testService.searchRepos(page, pageSize)
            val repoItems = repoResponse.items
            val prevKey = if (page > 1) page - 1 else null
            val nextKey = if (repoItems.isNotEmpty()) page + 1 else null
            LoadResult.Page(repoItems, prevKey, nextKey)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}