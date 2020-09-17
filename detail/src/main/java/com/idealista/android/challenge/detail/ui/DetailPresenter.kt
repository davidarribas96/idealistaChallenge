package com.idealista.android.challenge.detail.ui

import com.idealista.android.challenge.core.CoreAssembler
import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.wrench.usecase.UseCase
import com.idealista.android.challenge.detail.DetailAssembler
import com.idealista.android.challenge.detail.domain.AdDetail
import com.idealista.android.challenge.detail.domain.detail

class DetailPresenter(private val view: DetailView) {

    fun onDetailNeeded(url: String) {
        UseCase<CommonError, AdDetail>()
            .bg(detail(DetailAssembler.repository, url))
            .map { it }
            .ui {
                it.fold(
                    {

                    },
                    {
                        view.render(it.toModel())
                    }
                )
            }.run(CoreAssembler.executor)
    }

}