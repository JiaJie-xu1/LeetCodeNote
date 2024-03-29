package com.univers.paging3

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.univers.paging3.api.PagingTestService
import com.univers.paging3.model.Repo
import kotlinx.coroutines.flow.Flow

object Repository {
    private const val PAGE_SIZE = 10;

    private val pagingTestService =  PagingTestService.create()

    fun getPagingData(): Flow<PagingData<Repo>> {
        return Pager(
            config = PagingConfig(PAGE_SIZE),
            pagingSourceFactory = {
                RepoPagingSource(pagingTestService)
            }
        ).flow
    }
}