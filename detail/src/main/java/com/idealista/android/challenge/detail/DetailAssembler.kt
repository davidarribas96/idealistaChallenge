package com.idealista.android.challenge.detail

import com.idealista.android.challenge.core.CoreAssembler
import com.idealista.android.challenge.detail.data.DetailDataSource
import com.idealista.android.challenge.detail.data.DetailRepository
import com.idealista.android.challenge.detail.ui.DetailPresenter

object DetailAssembler {

    private val detailDataSource: DetailDataSource by lazy { DetailDataSource(CoreAssembler.detailApi) }

    lateinit var presenter: DetailPresenter

    val repository: DetailRepository by lazy { DetailRepository(detailDataSource) }

}