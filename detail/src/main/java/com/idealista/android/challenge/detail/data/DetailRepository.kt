package com.idealista.android.challenge.detail.data

import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.model.entity.AdDetailEntity
import com.idealista.android.challenge.core.wrench.type.Either
import com.idealista.android.challenge.detail.domain.AdDetail
import com.idealista.android.challenge.detail.domain.toDomain

class DetailRepository(private val dataSource: DetailDataSource) {

    fun detail(url:String): Either<CommonError, AdDetail> = dataSource.detail(url).map { it.toDomain() }
}