package com.example.cargo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.cargo.api.ApiInterface
import com.example.cargo.paginate.ApiPaginationSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MaiViewModel @Inject constructor(
    private val api: ApiInterface
) : ViewModel() {
    val flow = Pager(
        PagingConfig(
            pageSize = Page_LoadSize,
            enablePlaceholders = false
        )
    ) {
        ApiPaginationSource(api)
    }.flow.cachedIn(viewModelScope)
}
const val Page_LoadSize = 1000