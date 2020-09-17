package com.idealista.android.challenge.detail.data

import com.idealista.android.challenge.core.api.DetailApi
import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.model.entity.AdDetailEntity
import com.idealista.android.challenge.core.wrench.type.Either

class DetailDataSource(private val api: DetailApi) {

    fun detail(url:String): Either<CommonError, AdDetailEntity> = api.detail(url)
}